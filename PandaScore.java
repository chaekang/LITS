import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PandaScore extends JPanel {

	public JLabel label;
	public JLabel time_label;
	public ImageIcon image;
	public JLabel[] imageLabel = new JLabel[20];
	public int score;

    public PandaScore() {
		score=0;
		setBackground(Color.WHITE);
		setLayout(null);
		label = new JLabel("Score: " + score);
		label.setFont(new Font("Arial", Font.BOLD, 30));
		label.setBounds(25, 720, 180, 70);
		time_label = new JLabel("Time: ");
		time_label.setFont(new Font("Arial", Font.BOLD, 25));
		time_label.setBounds(25, 20, 180, 50);
		add(label);
		add(time_label);

		image = new ImageIcon("Bamboo_label.png");

		for (int i = 0; i < 20; i++) { 
			imageLabel[i] = new JLabel();
			imageLabel[i].setIcon(image);

			if (i%2 == 1) {
				imageLabel[i].setBounds(40, 660-65*(i/2), 70, 60);
			}
			else {
				imageLabel[i].setBounds(120, 660-65*(i/2), 70, 60);
			}
			add(imageLabel[i]);
			imageLabel[i].setVisible(false);
			
		}
		updateScore(0);
		setVisible(true);
	}
    public void updateTime(int up_time) {
		time_label.setText("Time: " + up_time);
    }

    public void updateScore(int newScore) {
		if (score != newScore) {
			score = newScore;
			label.setText("Score: " + score);
			updateImageLabels(); 
		}
    }
	public void updateImageLabels() {
		for (int i = 0; i < 20; i++) {
			if(i < score){
				imageLabel[i].setVisible(true);
			}	
			else{
				imageLabel[i].setVisible(false);
			} 
		}
	}

}
