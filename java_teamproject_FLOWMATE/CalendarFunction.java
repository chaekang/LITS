import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.time.*;	

public class CalendarFunction
{
	JButton[] buttons = new JButton[49];
	Calendar  calendar = Calendar.getInstance();
	int       year, month;
	int       firstDay;

	public CalendarFunction()
	{
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}

	public void setButtons(JButton[] buttons)
	{
		this.buttons = buttons;
	}

	public void setButtonsListener(JButton[] b, ActionListener listener)
	{
		firstDay = calendar.get(Calendar.DAY_OF_WEEK);

		firstDay--;

		for(int i=1;i<=calendar.getActualMaximum(calendar.DATE);i++)
		{
			b[6 + firstDay + i].addActionListener(listener);
		}
	}

	public String getCalText()
	{
		return year + "³â" + month + "¿ù";
	}

	public LocalDate getClickedDate(int day)
	{
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}

	public void calSet()
	{
		calendar.set(year, month-1, 1);

		firstDay = calendar.get(Calendar.DAY_OF_WEEK);

		firstDay--;

		for(int i=1;i<=calendar.getActualMaximum(calendar.DATE);i++)
		{
			buttons[6 + firstDay + i].setText(String.valueOf(i));
		}
	}

	public void calSet(int u_year, int u_month)
	{
		year = u_year;
		month = u_month;

		calSet();
	}

	public void allInit(int gap)
	{
		for(int i=7;i<buttons.length;i++)
		{
			buttons[i].setText("");
		}

		month += gap;

		if(month <= 0)
		{
			year--;
			month = 12;
		}
		else if(month >=13)
		{
			year++;
			month = 1;
		}
		calSet();
	}

	public int getFirstDay()
	{
		firstDay = calendar.get(Calendar.DAY_OF_WEEK);
		return firstDay;
	}

	public Calendar getCalendar()
	{
		return calendar;
	}


}