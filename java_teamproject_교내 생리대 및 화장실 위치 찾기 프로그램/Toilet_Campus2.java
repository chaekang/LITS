import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Toilet_Campus2 extends JPanel implements ActionListener{
	JPanel building, toiletinfo, currentpanel;
	JButton b1, b2, b3, b4, b5, b6, b7;
	JLabel label;

	public Toilet_Campus2(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		building = new JPanel();
		building.setLayout(new BoxLayout(building, BoxLayout.X_AXIS));

		b1 = new JButton("프라임관");
		b1.setFont(new Font("SanSerif", Font.BOLD, 20));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		b2 = new JButton("과학관");
		b2.setFont(new Font("SanSerif", Font.BOLD, 20));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		b3 = new JButton("도서관");
		b3.setFont(new Font("SanSerif", Font.BOLD, 20));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);

		b4 = new JButton("르네상스");
		b4.setFont(new Font("SanSerif", Font.BOLD, 20));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.addActionListener(this);

		b5 = new JButton("미술대학");
		b5.setFont(new Font("SanSerif", Font.BOLD, 20));
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.addActionListener(this);

		b6 = new JButton("약학대학");
		b6.setFont(new Font("SanSerif", Font.BOLD, 20));
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.addActionListener(this);

		b7 = new JButton("음악대학");
		b7.setFont(new Font("SanSerif", Font.BOLD, 20));
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.addActionListener(this);

		building.add(b1);
		building.add(Box.createHorizontalStrut(20));
		building.add(b2);
		building.add(Box.createHorizontalStrut(20));
		building.add(b3);
		building.add(Box.createHorizontalStrut(20));
		building.add(b4);
		building.add(Box.createHorizontalStrut(20));
		building.add(b5);
		building.add(Box.createHorizontalStrut(20));
		building.add(b6);
		building.add(Box.createHorizontalStrut(20));
		building.add(b7);

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
			Prime panel = new Prime();
			add(panel);
			currentpanel = panel;
		}

		else if (e.getSource() == b2){
			Science panel2 = new Science();
			add(panel2);
			currentpanel = panel2;
			
		}
		else if (e.getSource() == b3){
			Library panel3 = new Library();
			add(panel3);
			currentpanel = panel3;
			
		}
		else if (e.getSource() == b4){
			Renaissance panel4 = new Renaissance();
			add(panel4);
			currentpanel = panel4;
			
		}
		else if (e.getSource() == b5){
			Art panel5 = new Art();
			add(panel5);
			currentpanel = panel5;
			
		}
		else if (e.getSource() == b6){
			Medicine panel6 = new Medicine();
			add(panel6);
			currentpanel = panel6;
			
		}
		else if (e.getSource() == b7){
			Music panel7 = new Music();
			add(panel7);
			currentpanel = panel7;
			
		}

		revalidate();
        repaint();

	}

}
