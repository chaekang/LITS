import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.time.*;	

public class  CalendarFrame extends JFrame
{
	CalendarPanel p1, p2;
	CalendarFunction cF = new CalendarFunction();

	int nextPeriodStartYear, nextPeriodStartMonth, nextPeriodStartDay;
	int nextPeriodEndYear, nextPeriodEndMonth, nextPeriodEndDay;
	int fertileStartYear, fertileStartMonth, fertileStartDay;
	int fertileEndYear, fertileEndMonth, fertileEndDay;
	int ovulDay;

	Month tempMonth;

	LocalDate m_nextPeriodStart;
	LocalDate m_nextPeriodEnd;
	LocalDate m_fertileStart;
	LocalDate m_fertileEnd;
	LocalDate m_ovulDate;

	Color nextColor = new Color(248, 204, 206);
	Color fertColor = new Color(248, 238, 204);
	Color ovulColor = new Color(211, 248, 204);

	public CalendarFrame(LocalDate nextPeriodStart, LocalDate nextPeriodEnd, LocalDate fertileStart, LocalDate fertileEnd, LocalDate ovulDate)
	{
		m_nextPeriodStart = nextPeriodStart;
		m_nextPeriodEnd = nextPeriodEnd;
		m_fertileStart = fertileStart;
		m_fertileEnd = fertileEnd;
		m_ovulDate = ovulDate;

		init();
	}

	public void setFields(LocalDate nextPeriodStart, LocalDate nextPeriodEnd, LocalDate fertileStart, LocalDate fertileEnd, LocalDate ovulDate)
	{
		m_nextPeriodStart = nextPeriodStart;
		m_nextPeriodEnd = nextPeriodEnd;
		m_fertileStart = fertileStart;
		m_fertileEnd = fertileEnd;
		m_ovulDate = ovulDate;
	}

	public void init()
	{
		nextPeriodStartYear = m_nextPeriodStart.getYear();
		Month tempMonth = m_nextPeriodStart.getMonth();
		nextPeriodStartMonth = tempMonth.getValue();
		nextPeriodStartDay = m_nextPeriodStart.getDayOfMonth();

		nextPeriodEndYear = m_nextPeriodEnd.getYear();
		tempMonth = m_nextPeriodEnd.getMonth();
		nextPeriodEndMonth = tempMonth.getValue();
		nextPeriodEndDay = m_nextPeriodEnd.getDayOfMonth();

		fertileStartYear = m_fertileStart.getYear();
		tempMonth = m_fertileStart.getMonth();
		fertileStartMonth = tempMonth.getValue();
		fertileStartDay = m_fertileStart.getDayOfMonth();

		fertileEndYear = m_fertileEnd.getYear();
		tempMonth = m_fertileEnd.getMonth();
		fertileEndMonth = tempMonth.getValue();
		fertileEndDay = m_fertileEnd.getDayOfMonth();

		ovulDay = m_ovulDate.getDayOfMonth();

		p1 = new CalendarPanel(nextPeriodStartYear, nextPeriodStartMonth);

		setSize(500, 400);
		setLocation(500, 400);
		setVisible(true);

		setPanel();
	}

	private void setPanel()
	{
		if(nextPeriodEndMonth != nextPeriodStartMonth)
		{
			p1.setBackColor(nextPeriodStartDay, p1.getEndOfMonth(), nextColor);
			p1.setBackColor(fertileStartDay, fertileEndDay, fertColor);
			p1.setBackColor(ovulDay, ovulDay, ovulColor);

			p2 = new CalendarPanel(nextPeriodEndYear, nextPeriodEndMonth);
			p2.setBackColor(1, nextPeriodEndDay, nextColor);

			setLayout(new GridLayout(1, 2));
			setSize(1000, 400);
			add(p1);
			add(p2);
		}
		else if(fertileStartMonth != nextPeriodStartMonth)
		{
			p2 = new CalendarPanel(fertileStartYear, fertileStartMonth);

			if(fertileStartMonth != fertileEndMonth)
			{
				p2.setBackColor(fertileStartDay, p2.getEndOfMonth(), fertColor);
				p1.setBackColor(1, fertileEndDay, fertColor);
			}
			else
			{
				p2.setBackColor(fertileStartDay, fertileEndDay, fertColor);
			}

			if(ovulDay < fertileStartDay && ovulDay < fertileEndDay)
			{
				p1.setBackColor(ovulDay, ovulDay, ovulColor);
			}
			else 
			{
				p2.setBackColor(ovulDay, ovulDay, ovulColor);
			}

			p1.setBackColor(nextPeriodStartDay, nextPeriodEndDay, nextColor);
			setLayout(new GridLayout(1, 2));
			setSize(1000, 400);
			add(p2);
			add(p1);
		}
		else
		{
			p1.setBackColor(nextPeriodStartDay, nextPeriodEndDay, nextColor);
			p1.setBackColor(fertileStartDay, fertileEndDay, fertColor);
			p1.setBackColor(ovulDay, ovulDay, ovulColor);
			add(p1);
		}
	}

}
