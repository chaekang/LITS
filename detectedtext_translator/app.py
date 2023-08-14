import cv2
import boto3
import numpy as np
import openai
import streamlit as st

st.title("이미지 번역 어플리케이션")

uploaded_file = st.file_uploader("이미지를 업로드 해주세요.")
try:
    file_bytes = uploaded_file.read()
    session = boto3.Session(profile_name='default')
    client = session.client('rekognition')
    image = {'Bytes': file_bytes}
    response = client.detect_text(Image=image)
    textDetections = response['TextDetections']

    for text in textDetections:
        print(text)
        print('Detected text:' + text['DetectedText'])
        print('Confidence: ' + "{:.2f}".format(text['Confidence']) + "%")
        print('Id: {}'.format(text['Id']))
        if 'ParentId' in text:
            print('Parent Id: {}'.format(text['ParentId']))
        print('Type:' + text['Type'])
    
    nd_bytes = np.asarray(bytearray(file_bytes), dtype=np.uint8)
    im = cv2.imdecode(nd_bytes, 1)
    h, w, _ = im.shape
    
    for text in textDetections:
        print(text)
        if not 'ParentId' in text:
            t_color = (0, 255, 0)
            if text['Confidence'] < 90:
                t_color = (255, 0, 0)
            elif text['Confidence'] < 80:
                t_color = (0, 0, 255)
    
            bbox = text['Geometry']['BoundingBox']
            x1 = int(text['Geometry']['BoundingBox']['Left'] * w)
            y1 = int(text['Geometry']['BoundingBox']['Top'] * h)
            x2 = int((text['Geometry']['BoundingBox']['Left']+text['Geometry']['BoundingBox']['Width']) * w)
            y2 = int((text['Geometry']['BoundingBox']['Top']+text['Geometry']['BoundingBox']['Height']) * h)
            cv2.rectangle(im, (x1, y1), (x2, y2), t_color, 2)
            texts = text['DetectedText']
            st.text(text['DetectedText'])
    
    st.image(im, channels="BGR")
    
    api_key = st.text_input('openai api key')
    if api_key:
        openai.api_key = api_key
    
    lang_list = ('Korean', 'Chinese', 'Japanese', 'Spanish', 'French')
    
    st.header('Translator')
    
    col1, col2 = st.columns(2)
    result =''
    with col1:
        option = st.selectbox('Lang', lang_list)
        q = st.text_area('From')
        if q:
            source_language = "English"
            target_language = option
    
            prompt = f"Translate the following text from {source_language} to {target_language}:\nText: {texts}\nTranslation:"
    
            response = openai.Completion.create(
                model='text-davinci-003',
                prompt = prompt,
                temperature = 0,
                max_tokens = 100,
                top_p =1,
            )
            print(response.choices[0].text.strip())
            result = response.choices[0].text.strip()
    
            with col2:
                st.text_area('To', value=result)
except:
    pass
