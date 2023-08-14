import java.awt.*;
import javax.swing.*;

class PandaImage{
	
	PandaImage(){
	
	}
	
	public void PandaImageDraw(Graphics g) {

		//Panda's ear//
		g.setColor(Color.BLACK);
		g.fillOval(45-44, 47-46, 20, 20);
		g.fillOval(80-44, 47-46, 20, 20);

		//Panda's arm
		g.fillRoundRect(45-44, 90-46, 17, 25, 20, 20);


		g.fillRoundRect(83-44, 90-46, 17, 25, 20, 20);

		//Panda's leg//
		g.fillRoundRect(56-44, 106-46, 17, 25, 20, 20);
		g.fillRoundRect(73-44, 106-46, 17, 25, 20, 20);

		//Panda's body//
		g.setColor(Color.WHITE);
		g.fillRoundRect(53-44, 85-46, 40, 40, 30, 30);
		g.setColor(Color.BLACK);//jeb add
		g.drawRoundRect(53-44, 85-46, 40, 40, 30, 30);//jeb add
        
        	//Panda's face//
		g.setColor(Color.WHITE);
		g.fillOval(50-44, 50-46, 45, 45);
        
		//Panda's eye//
		g.setColor(Color.BLACK);
		g.fillOval(53-44, 60-46, 16, 23);
		g.fillOval(75-44, 60-46, 16, 23);
		g.drawOval(50-44, 50-46, 45, 45);//jeb add
        
		//Panda's pupil//
		g.setColor(Color.WHITE);
		g.fillOval(60-44, 68-46, 5, 5);
		g.fillOval(80-44, 68-46, 5, 5);
        
		//Panda's nose//
		g.setColor(Color.BLACK);
		g.fillOval(68-44, 80-46, 8, 8);
        
        
	}
}
