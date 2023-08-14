import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class LocatePanel extends JPanel{
		
		// 교내 생리대 위치 기본 정보
		String[] list0 = new String[] {"제 1 캠퍼스", "제 2 캠퍼스"};
		String[] list1 = new String[]{"명신관", "순헌관", "진리관", "새힘관", "학생회관"};
		String[] list2 = new String[]{"프라임관", "중앙도서관", "과학관", "미술대학", "르네상스관",
										"음학대학", "약학대학"};
		
		String[] locate1 = new String[] {"2층 정순옥 라운지 내부",
										"지하 1층 카페 건너편 기둥 옆",
										"1층 법학도서관 무인반납함 옆",
										"1층 엘리베이터 앞 협탁",
										"3층 301호 앞"};
		String[] locate2 = new String[] {"2층 엘리베이터 옆",
										"6층 열람실 화장실 앞",
										"1층 ATM기 앞 계단",
										"1층 미니 휴게실 사물함 위",
										"지하 1층 엘리베이터 옆",
										"1층 자판기 옆",
										" 1층 엘리베이터 좌측 녹색 사물함 옆"};
		
		// Component
		JLabel mLabel = new JLabel();
		JLabel l1Label = new JLabel("해당 건물의 생리대 위치는");
		JLabel l2Label = new JLabel("_____________");
		JLabel l3Label = new JLabel("입니다.");
		
		JPanel mPanel, iPanel;
		JPanel IOPanel, fPanel;
		JPanel comPanel, bPanel;
		JPanel f1Panel, f2Panel, f3Panel;
		JPanel empty;
		
		JButton show = new JButton("위치 확인하기");
		
		// campus list, structure list
		JComboBox cCombo = new JComboBox(list0);
		JComboBox sCombo = new JComboBox(list1);
		
		// map image
		ImageIcon defImg = new ImageIcon("./Images/default.png");
		ImageIcon c1Img = new ImageIcon("./Images/cam1.png");
		ImageIcon c2Img = new ImageIcon("./Images/cam2.png");
		
		
		public LocatePanel() {
			setPanel();
			setComponent();
			setComponentFont();
			addListener();
			setVisible(true);
		}
		
		void setPanel() {
			
			setLayout(new GridLayout(1,2));
			
			mPanel = new JPanel();
			mLabel.setIcon(defImg);
			mPanel.add(mLabel);
			
			// ================================ iPanel ================================
			
			// info panel
			iPanel = new JPanel(new GridLayout(2,1));
			
			// io panel
			IOPanel = new JPanel(new GridLayout(3,1));
			
			empty = new JPanel();
			
			comPanel = new JPanel(new FlowLayout());
			comPanel.add(cCombo); comPanel.add(sCombo);
			
			bPanel = new JPanel();
			bPanel.add(show);
			
			IOPanel.add(empty); IOPanel.add(comPanel); IOPanel.add(bPanel);
			
			fPanel = new JPanel(new GridLayout(3,1));
			
			iPanel.add(IOPanel); iPanel.add(fPanel);
			
			// final result panel
			f1Panel = new JPanel();
			f2Panel = new JPanel();
			f3Panel = new JPanel();
			
			f1Panel.add(l1Label); f2Panel.add(l2Label); f3Panel.add(l3Label); 
			fPanel.add(f1Panel); fPanel.add(f2Panel); fPanel.add(f3Panel);
			
			// ================================ iPanel ================================
			
			
			// add to main panel
			add(mPanel); add(iPanel);
			setVisible(true);
		}
		
		void setComponent() {
			
			setBackground(Color.white);
			
			mPanel.setOpaque(true); iPanel.setOpaque(true);
			empty.setOpaque(true); IOPanel.setOpaque(true); 
			bPanel.setOpaque(true); fPanel.setOpaque(true); 
			f1Panel.setOpaque(true); f1Panel.setOpaque(true); 
			f3Panel.setOpaque(true); cCombo.setOpaque(true);
			show.setOpaque(true);
			
			// size
			cCombo.setPreferredSize(new Dimension(100, 30));
			
			// background
			mPanel.setBackground(Color.white); iPanel.setBackground(Color.white);
			empty.setBackground(Color.white); IOPanel.setBackground(Color.white); 
			comPanel.setBackground(Color.white); bPanel.setBackground(Color.white); 
			fPanel.setBackground(Color.white); f1Panel.setBackground(Color.white);
			f2Panel.setBackground(Color.white); f3Panel.setBackground(Color.white);
			cCombo.setBackground(Color.white); show.setBackground(Color.black);
			
			// 테두리
			fPanel.setBorder(new TitledBorder(new LineBorder(Color.black,5),"생리대 위치"));
			
			cCombo.setEditable(true); sCombo.setEditable(true);
			cCombo.getEditor().getEditorComponent().setBackground(Color.white);
			sCombo.getEditor().getEditorComponent().setBackground(Color.white);
			
		}
		
		// font method
		void setComponentFont() {
			Font bold = new Font("맑은 고딕", Font.BOLD, 14);
			
			show.setFont(bold);
			show.setForeground(Color.white);
			
			l1Label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			l2Label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			l3Label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		}

		// 생리대 위치 버튼 이벤트
		public void addListener() {
			show.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int index = sCombo.getSelectedIndex();
					
					if (cCombo.getSelectedIndex() == 0) {
						l2Label.setText(locate1[index]);
						l2Label.setForeground(new Color(224, 191, 230));
					}
					
					if (cCombo.getSelectedIndex() == 1) {
						
						l2Label.setText(locate2[index]);
						l2Label.setForeground(new Color(224, 191, 230));
					}
				}
			});
			
			// 약도 event
			cCombo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if ((String)cCombo.getSelectedItem() == "제 1 캠퍼스") {
						mLabel.setIcon(c1Img);
						sCombo.removeAllItems();
						for (int i = 0; i < list1.length; i++) {
							sCombo.addItem(list1[i]);
						}
					}
					if ((String)cCombo.getSelectedItem() == "제 2 캠퍼스") {
						mLabel.setIcon(c2Img);
						sCombo.removeAllItems();
						for (int i = 0; i < list2.length; i++) {
							sCombo.addItem(list2[i]);
						}
					}	
				}
			});
		}
}
