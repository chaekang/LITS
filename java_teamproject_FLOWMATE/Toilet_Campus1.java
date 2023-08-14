import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Toilet_Campus1 extends JPanel implements ActionListener{
	JPanel building, toiletinfo, currentpanel;
	JButton b1, b2, b3, b4, b5;
	JLabel label;

	public Toilet_Campus1(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		building = new JPanel();
		building.setLayout(new BoxLayout(building, BoxLayout.X_AXIS));

		b1 = new JButton("순헌관");
		b1.setFont(new Font("SanSerif", Font.BOLD, 20));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		b2 = new JButton("학생회관");
		b2.setFont(new Font("SanSerif", Font.BOLD, 20));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		b3 = new JButton("명신관");
		b3.setFont(new Font("SanSerif", Font.BOLD, 20));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);

		b4 = new JButton("새힘관");
		b4.setFont(new Font("SanSerif", Font.BOLD, 20));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.addActionListener(this);

		b5 = new JButton("진리관");
		b5.setFont(new Font("SanSerif", Font.BOLD, 20));
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.addActionListener(this);

		building.add(b1);
		building.add(Box.createHorizontalStrut(50));
		building.add(b2);
		building.add(Box.createHorizontalStrut(50));
		building.add(b3);
		building.add(Box.createHorizontalStrut(50));
		building.add(b4);
		building.add(Box.createHorizontalStrut(50));
		building.add(b5);

		building.setBackground(Color.WHITE);

		toiletinfo = new JPanel();
		
		
		label = new JLabel("현재 위치한 건물을 선택해주세요.", JLabel.CENTER);
		label.setFont(new Font("SanSerif", Font.BOLD, 30));

		toiletinfo.add(label);
		currentpanel = toiletinfo;

		toiletinfo.setBackground(Color.WHITE);
		
		building.setAlignmentX(Component.CENTER_ALIGNMENT);
        toiletinfo.setAlignmentX(Component.CENTER_ALIGNMENT);

	    add(Box.createVerticalStrut(20));
		add(building);
		add(Box.createVerticalStrut(20));
		add(toiletinfo);

		setBackground(Color.WHITE);
	}

	

	public void actionPerformed (ActionEvent e){
		if (currentpanel != null){
			remove(currentpanel);
		}

		if (e.getSource() == b1){
			Soonhun panel = new Soonhun();
			add(panel);
			currentpanel = panel;
		}

		else if (e.getSource() == b2){
			Student panel2 = new Student();
			add(panel2);
			currentpanel = panel2;
			
		}
		else if (e.getSource() == b3){
			Myungsin panel3 = new Myungsin();
			add(panel3);
			currentpanel = panel3;
			
		}
		else if (e.getSource() == b4){
			Saehim panel4 = new Saehim();
			add(panel4);
			currentpanel = panel4;
			
		}
		else if (e.getSource() == b5){
			Jinri panel5 = new Jinri();
			add(panel5);
			currentpanel = panel5;
			
		}

		revalidate();
        repaint();

	}

}