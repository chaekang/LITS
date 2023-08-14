import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;	

class CalPanel extends JPanel
{
	
	JLabel  lInputEnd = new JLabel("������ ���� ������ �Է�", JLabel.CENTER);
	JLabel  lOutput = new JLabel("2023-06-14", JLabel.CENTER);
	JLabel  lInputPer = new JLabel("�ֱ� �Է�", JLabel.CENTER);

	JButton bCalendar = new JButton();
	JButton bCalendar2 = new JButton();
	JButton bCheck = new JButton("������ ����ϱ�");

	JLabel  lPeriod = new JLabel("�ֱ� �Է��ϱ�", JLabel.CENTER);
	JLabel  lInputPeriod = new JLabel("28��", JLabel.CENTER);
	JButton bPeriod = new JButton();

	JLabel  lDueDate = new JLabel("���� ���� ������", JLabel.CENTER);
	JLabel  lChild = new JLabel("���ӱ�", JLabel.CENTER);
	JLabel  lOvul = new JLabel("�����", JLabel.CENTER);

	JLabel  lMsg = new JLabel("����� �޷°� �����̴� �������� Ŭ���Ͽ� ���� �Է��ϼ���", JLabel.CENTER);
	JFrame  jf;
	JLabel  lTitle = new JLabel("���� ������ ����", JLabel.CENTER);
	JPanel  tPanel, nPanel, bPanel, cPanel, rPanel, sPanel;
	
	int cyper = 28;
    DateCalculator dateCalculator;
	
	public CalPanel()
	{
		setPanel();
		setComponent();
		setComponentFont();
		addListener();
		dateCalculator = new DateCalculator();
	}

	void setPanel()
	{
		setLayout(new GridLayout(6, 1));

		tPanel = new JPanel();
		tPanel.add(lTitle);

		nPanel = new JPanel();
		nPanel.add(lInputEnd);
		nPanel.add(lOutput);
		nPanel.add(bCalendar);

		bPanel = new JPanel();
		bPanel.add(lPeriod);
		bPanel.add(lInputPeriod);
		bPanel.add(bPeriod);

		cPanel = new JPanel();
		cPanel.add(bCheck);

		rPanel = new JPanel();
		rPanel.add(lMsg);

		sPanel = new JPanel(new GridLayout(1, 4));
		sPanel.add(bCalendar2);
		sPanel.add(lDueDate);
		sPanel.add(lChild);
		sPanel.add(lOvul);

		setLayout(new GridLayout(6, 1));
		setSize(1000,500);
		add(tPanel);
		add(nPanel);
		add(bPanel);
		add(cPanel);
		add(rPanel);
		add(sPanel);

		setVisible(true);
	}
	void setComponent()
	{
		tPanel.setOpaque(true);
		nPanel.setOpaque(true);
		bPanel.setOpaque(true);
		cPanel.setOpaque(true);
		rPanel.setOpaque(true);
		sPanel.setOpaque(true);
		setOpaque(true);

		tPanel.setBackground(Color.WHITE);
		nPanel.setBackground(Color.WHITE);
		bPanel.setBackground(Color.WHITE);
		cPanel.setBackground(Color.WHITE);
		rPanel.setBackground(Color.WHITE);
		sPanel.setBackground(Color.WHITE);
		setBackground(Color.WHITE);

		lInputEnd.setOpaque(true);
		lInputEnd.setBackground(Color.BLACK);
		lInputEnd.setForeground(Color.WHITE);

		lInputEnd.setPreferredSize(new Dimension(200, 50));
		lOutput.setPreferredSize(new Dimension(200, 50));
		bCalendar.setPreferredSize(new Dimension(70, 50));
		bCalendar2.setPreferredSize(new Dimension(50, 50));

		lPeriod.setPreferredSize(new Dimension(200, 50));
		lInputPeriod.setPreferredSize(new Dimension(200, 50));
		bPeriod.setPreferredSize(new Dimension(70, 50));

		ImageIcon calIcon = new ImageIcon("./Images/calendarIcon2.png");
		bCalendar.setIcon(calIcon);
		ImageIcon calIcon2 = new ImageIcon("./Images/calendarIcon.png");
		bCalendar2.setIcon(calIcon2);

		ImageIcon perIcon = new ImageIcon("./Images/periodIcon.png");
		bPeriod.setIcon(perIcon);

		lDueDate.setOpaque(true);
		lChild.setOpaque(true);
		lOvul.setOpaque(true);
		lPeriod.setOpaque(true);
		lMsg.setOpaque(true);

		bCalendar.setBackground(Color.WHITE);
		bPeriod.setBackground(Color.WHITE);
		bCheck.setBackground(Color.WHITE);
		bCalendar2.setBackground(Color.WHITE);

		lPeriod.setBackground(Color.BLACK);
		lPeriod.setForeground(Color.WHITE);

		lInputPeriod.setBackground(Color.WHITE);
		lMsg.setBackground(Color.WHITE);

		lDueDate.setBackground(Color.WHITE);
		lChild.setBackground(Color.WHITE);
		lOvul.setBackground(Color.WHITE);

		lOutput.setBorder(new LineBorder(Color.BLACK));
		lInputPeriod.setBorder(new LineBorder(Color.BLACK));
		lDueDate.setBorder(new LineBorder(Color.BLACK));
		lChild.setBorder(new LineBorder(Color.BLACK));
		lOvul.setBorder(new LineBorder(Color.BLACK));
	}

	void setComponentFont()
	{
		lTitle.setFont(new Font("���� ���", Font.BOLD, 35));

		Font font1 = new Font("���� ���", Font.BOLD, 15);
		lInputEnd.setFont(font1);
		lOutput.setFont(font1);
		lInputPer.setFont(font1);
		lPeriod.setFont(font1);
		lInputPeriod.setFont(font1);
		bCalendar.setFont(font1);
		bPeriod.setFont(font1);
		bCheck.setFont(font1);
		bCalendar2.setFont(font1);
		lMsg.setFont(font1);
		lDueDate.setFont(font1);
		lChild.setFont(font1);
		lOvul.setFont(font1);
	}
	private void addListener()
	{
		bCalendar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CalendarDialog calenderDialog = new CalendarDialog(new JFrame());
				calenderDialog.setVisible(true);
				LocalDate date = calenderDialog.getDate();
				if(date != null)
				{
					lOutput.setText(date.toString());
				}
				else
				{
					lOutput.setText("��¥�� ������ �ּ���");
				}
			}
		});

		bPeriod.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				 CyperInputFrame frame = new CyperInputFrame();
				 frame.setVisible(true);
				 frame.addWindowListener(new WindowAdapter()
				 {
					@Override
					public void windowClosed(WindowEvent e)
					{
						cyper = frame.getCyper();
						if(cyper == 0)
						{
							cyper = 28;
						}
						lInputPeriod.setText(Integer.toString(cyper)+"��");
					}

				});
			}
		});
			
		bCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
				try
				{
					LocalDate lastPeriodEndDate = LocalDate.parse(lOutput.getText());
                    String nextMenstrualPeriod = dateCalculator.calculateNextMenstrualPeriod(lastPeriodEndDate, cyper);
                    String fertileWindow = dateCalculator.calculateFertileWindow(lastPeriodEndDate);
                    String ovulationDate = dateCalculator.calculateOvulationDate(lastPeriodEndDate);
					
					lMsg.setForeground(Color.BLACK);
					lMsg.setText("�ϴ��� �޷� ��ư�� ���� �Ѵ��� Ȯ���� ������");
                    lDueDate.setText("<html><body style='text-align:center;'>���� ���� ������<br>" + nextMenstrualPeriod + "</html>");
                    lChild.setText("<html><body style='text-align:center;'>���ӱ�<br>" + fertileWindow + "</html>");
                    lOvul.setText("<html><body style='text-align:center;'>�����<br>" + ovulationDate + "</html>");

					LocalDateTime nextPeriodStart = dateCalculator.getNextPeriodStart().atStartOfDay();
					LocalDateTime nowDate = LocalDate.now().atStartOfDay();

					lDueDate.setBackground(new Color(248, 204, 206));
					lChild.setBackground(new Color(248, 238, 204));
					lOvul.setBackground(new Color(211, 248, 204));

					LocalDate nowDate2 = LocalDate.now();

					if(lastPeriodEndDate.isAfter(nowDate2))
					{
						lMsg.setForeground(Color.BLACK);
						lMsg.setText("���� ������ ��¥�� �����ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
					}
					else if(nextPeriodStart.compareTo(nowDate) == -1)
					{
						int betweenDays = (int) Duration.between(nextPeriodStart, nowDate).toDays();
						if(betweenDays>14)
						{
							lMsg.setForeground(Color.RED);
							lMsg.setText("���� ������ �������� �����̳���? ����� ������ ���� ������ �޾� ������");
						}
					}
					else if(nextPeriodStart.compareTo(nowDate) == 0)
					{
						lMsg.setForeground(Color.BLACK);
						lMsg.setText("���� ������ ������ �� �����ϴ�.");
					}
					

				}
				catch (NullPointerException ex) {} 

             }
        });

		bCalendar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

				try
				{
					LocalDate nextPeriodStart = dateCalculator.getNextPeriodStart();
					LocalDate nextPeriodEnd = dateCalculator.getNextPeriodEnd();
					LocalDate fertileStart = dateCalculator.getFertileStart();
					LocalDate fertileEnd = dateCalculator.getFertileEnd();
					LocalDate ovulDate = dateCalculator.getOvulation();

                    new CalendarFrame(nextPeriodStart, nextPeriodEnd, fertileStart, fertileEnd, ovulDate);
				}
				catch (NullPointerException ex) {}
			}
        });
	}
}