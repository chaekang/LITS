import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame{
	JMenuBar bar;
	JMenu position, toilet, duedate, community;
	JMenuItem pad, campus1, campus2, calculator, chat;
	Font font, font2;
	JPanel mainpanel, currentpanel;
	JFrame mainframe;

	public MainFrame(String msg){

		mainframe = new JFrame(msg);
		mainframe.setLayout(null);

        mainpanel = new JPanel();
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(90, 0, 1000, 640);

        mainframe.add(mainpanel);

		Maindisplay panel = new Maindisplay();
		mainpanel.add(panel);
		currentpanel = panel;

		makeMenu();
	    mainframe.setSize(1200, 700);
		mainframe.setVisible(true);
	}

	void makeMenu(){
		bar = new JMenuBar();
		bar.setLayout(new BoxLayout(bar, BoxLayout.X_AXIS));
		font = new Font("SanSerif", Font.BOLD, 20);
		font2 = new Font("SanSerif", Font.BOLD, 15);

		position = new JMenu("생리대/화장실 위치");
		pad = new JMenuItem("생리대 위치");
		toilet = new JMenu("화장실 위치");
		position.add(pad);
		position.add(toilet);

		campus1 = new JMenuItem("제 1 캠퍼스");
		campus2 = new JMenuItem("제 2 캠퍼스");
		toilet.add(campus1);
		toilet.add(campus2);

		duedate = new JMenu("나의 생리 예정일");
		calculator = new JMenuItem("생리 예정일 계산");
		duedate.add(calculator);

		community = new JMenu("커뮤니티");
		chat = new JMenuItem("눈송이 채팅방");
		community.add(chat);
		
		bar.add(Box.createHorizontalStrut(50));
		bar.add(position);
		bar.add(Box.createHorizontalStrut(280));
		bar.add(duedate);
		bar.add(Box.createHorizontalStrut(340));
		bar.add(community);

		position.setFont(font);
		duedate.setFont(font);
		community.setFont(font);
		pad.setFont(font2);
		toilet.setFont(font2);
		campus1.setFont(font2);
		campus2.setFont(font2);
		calculator.setFont(font2);
		chat.setFont(font2);

		position.setForeground(new Color(255, 255, 255));
		duedate.setForeground(new Color(255, 255, 255));
		community.setForeground(new Color(255, 255, 255));
		
		bar.setPreferredSize(new Dimension(1200, 40));
		bar.setBackground(new Color(224, 191, 230));

		mainframe.setJMenuBar(bar);

		MenuActionListener listener = new MenuActionListener();
		campus1.addActionListener(listener);
		campus2.addActionListener(listener);
		chat.addActionListener(listener);
		pad.addActionListener(listener);
		calculator.addActionListener(listener);
	}

	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (currentpanel != null){
				mainpanel.remove(currentpanel);
			}
			if (e.getSource() == pad){
				LocatePanel panel1 = new LocatePanel();
				mainpanel.add(panel1); 
				currentpanel = panel1;
			}
			else if (e.getSource() == campus1){
				Toilet_Campus1 panel2 = new Toilet_Campus1();
				mainpanel.add(panel2);
				currentpanel = panel2;
			}
			else if (e.getSource() == campus2){
				Toilet_Campus2 panel3 = new Toilet_Campus2();
				mainpanel.add(panel3);
				currentpanel = panel3;
			}
			else if (e.getSource() == calculator){
				CalPanel panel4 = new CalPanel();
				mainpanel.add(panel4); 
				currentpanel = panel4;
			}
			
			else if (e.getSource() == chat){
				ChatPanel panel5 = new ChatPanel();
				mainpanel.add(panel5); 
				currentpanel = panel5;
			}
			
			mainframe.revalidate();
			mainframe.repaint();

		}
	}
}


