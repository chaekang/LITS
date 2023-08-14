import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.time.*;	

class  CalendarPanel extends JPanel
{
	Calendar  calendar = Calendar.getInstance();

	JPanel nPanel = new JPanel();
	JPanel cPanel = new JPanel();

	JLabel lDate = new JLabel("00³â 0¿ù");

	JButton[] buttons = new JButton[49];
	String[] dayNames = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};

	int year, month;

	CalendarFunction cF = new CalendarFunction();

	public CalendarPanel(int u_year, int u_month)
	{
		year = u_year;
		month = u_month;
		calendar = cF.getCalendar();
		setSize(500, 400);
		init();
	}

	private void init()
	{
		setLayout(new BorderLayout());
		add("North", nPanel);
		add("Center", cPanel);

		setBackground(Color.WHITE);

		nPanel.setLayout(new FlowLayout());
		nPanel.add(lDate);

		nPanel.setOpaque(true);
		nPanel.setBackground(Color.WHITE);

		Font f1 = new Font("¸¼Àº °íµñ", Font.PLAIN, 15);
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
		cF.calSet(year, month);
		lDate.setText(cF.getCalText());
	}

	public void setBackColor(int startDate, int endDate, Color color)
	{
		int firstDay = cF.getFirstDay();
		firstDay--;

		try
		{
			for (int i=startDate;i<=endDate ;i++ )
			{
				buttons[6 + firstDay + i].setBackground(color);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
	}

	public int getEndOfMonth()
	{
		return calendar.getActualMaximum(calendar.DATE);
	}



}
