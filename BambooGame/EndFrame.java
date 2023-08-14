import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EndFrame extends JFrame  {
	
	public JLabel titleLabel;
	public JLabel scoreLabel;
	public JPanel gridPanel;
	public JButton bt_yes;
	public JButton bt_no;

	EndFrame() {

		gridPanel = new JPanel();
		gridPanel.setLayout(null);
		add(gridPanel);

		bt_yes = new JButton("Game Again");
		bt_yes.setFont(new Font("Arial", Font.BOLD, 20));
		bt_yes.setBounds(30, 270, 200, 70);
		bt_no = new JButton("Exit");
		bt_no.setFont(new Font("Arial", Font.BOLD, 20));
		bt_no.setBounds(255, 270, 200, 70);
		gridPanel.add(bt_yes);
		gridPanel.add(bt_no);
		
		
		titleLabel = new JLabel("GAME");		
		titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 20, 500, 130);
		gridPanel.add(titleLabel);

		scoreLabel = new JLabel("Time :");
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setBounds(0, 150, 500, 70);
		gridPanel.add(scoreLabel);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setSize(500,400);
		bt_yes.addActionListener(new EndEvent());
		bt_no.addActionListener(new EndEvent());
	}
	class EndEvent implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bt_yes){
				setVisible(false);
				PandaMain.endframe_Message=1;
			}
			if(e.getSource()==bt_no){
				scoreLabel.setText("End in 2 seconds");
				PandaMain.endframe_Message=2;
			}
	
		}
	}			
}
