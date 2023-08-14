import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Maindisplay extends JPanel{
	JPanel main, text;
	ImageIcon img;
	JLabel proname, image, t1, t2, t3, t4;
	Font zero = new Font("Sanserif", Font.BOLD, 60);
	Font one = new Font("Sanserif", Font.BOLD, 30);
	Font two = new Font("Sanserif", Font.BOLD, 20);

	public Maindisplay(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		proname = new JLabel("     FlowMate     ");
		proname.setFont(zero);
		proname.setBackground(new Color(185, 107, 198));
		proname.setForeground(Color.WHITE);
		proname.setOpaque(true); 

		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
		main.setBackground(Color.WHITE);

		img = new ImageIcon("./Images/snowsong.png");
		image = new JLabel(img);

		text = new JPanel();
		text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
		text.setBackground(Color.WHITE);
		
		t1 = new JLabel("���ϴ� �޴��� �������ּ���");
		t1.setFont(one);
		t2 = new JLabel("������/ȭ��� ��ġ�� �˰� �����ø� -> '������/ȭ��� ��ġ'");
		t2.setFont(two);
		t3 = new JLabel("���� �������� �˰� �����ø� -> '���� ����������'");
		t3.setFont(two);
		t4 = new JLabel("�����ؼ� �п��� �����ϰ� �����ø� -> 'Ŀ�´�Ƽ'");
		t4.setFont(two);
		
		text.add(t1);
		text.add(Box.createVerticalStrut(30));
		text.add(t2);
		text.add(Box.createVerticalStrut(20));
		text.add(t3);
		text.add(Box.createVerticalStrut(20));
		text.add(t4);
		
		main.add(image);
		main.add(text);
		
		proname.setAlignmentX(Component.CENTER_ALIGNMENT);
		main.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(Box.createVerticalStrut(100));
		add(proname);
		add(Box.createVerticalStrut(50));
		add(main);

		setBackground(Color.WHITE);
	}
}