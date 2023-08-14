import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.time.*;	

class  CalendarDialog extends JDialog implements ActionListener
{
	Container container = getContentPane();

	JPanel nPanel = new JPanel();
	JPanel cPanel = new JPanel();

	JButton bBefore = new JButton("◀");
	JButton bAfter = new JButton("▶");

	JLabel lDate = new JLabel("00년 0월");

	JButton[] buttons = new JButton[49];
	String[] dayNames = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};

	ActionListener listener;

	LocalDate clickedDate = null;

	CalendarFunction cF = new CalendarFunction();

	public CalendarDialog(JFrame jf)
	{
		super(jf, true);
		setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		setTitle("마지막 생리 종료일 입력");
		setSize(500, 400);
		setLocation(700, 200);
		init();
		addListener();
	}

	private void init()
	{
		container.setLayout(new BorderLayout());
		container.add("North", nPanel);
		container.add("Center", cPanel);

		container.setBackground(Color.WHITE);

		nPanel.setLayout(new FlowLayout());
		nPanel.add(bBefore);
		nPanel.add(lDate);
		nPanel.add(bAfter);

		nPanel.setOpaque(true);
		nPanel.setBackground(Color.WHITE);

		lDate.setText(cF.getCalText());

		bBefore.setBackground(Color.WHITE);
		bAfter.setBackground(Color.WHITE);

		Font f1 = new Font("맑은 고딕", Font.PLAIN, 15);
		lDate.setFont(f1);

		cPanel.setLayout(new GridLayout(7, 7));

		for (int i=0;i<buttons.length ; i++)
		{
			buttons[i] = new JButton();
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setBorderPainted(false);
			cPanel.add(buttons[i]);

			if(i<7)
				buttons[i].setText(dayNames[i]);

			if(i%7==0)
				buttons[i].setForeground(Color.RED);
			if(i%7==6)
				buttons[i].setForeground(Color.BLUE);
		}
		cF.setButtons(buttons);
		cF.calSet();
	}

	private void addListener()
	{
		listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String i = e.getActionCommand();
				try
				{
					clickedDate = cF.getClickedDate(Integer.parseInt(i));
					setVisible(false);
				} catch (NumberFormatException ex) {}
			}
		};

		cF.setButtonsListener(buttons, listener);

		bAfter.addActionListener(this);
		bBefore.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e)
	{
		int gap = 0;

		if(e.getSource() == bAfter)
		{
			gap = 1;
		}
		else if(e.getSource() == bBefore)
		{
			gap = -1;
		}

		cF.allInit(gap);
		cF.setButtonsListener(buttons, listener);
		lDate.setText(cF.getCalText());
	}

	public LocalDate getDate()
	{
		return clickedDate;
	}
}


