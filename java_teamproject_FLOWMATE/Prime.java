import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.geom.*;

public class Prime extends JPanel{
	JPanel toiletinfo, textinfo, textinfo_f, textinfo_p, textinfo_t;
	ImageIcon img;
	JLabel image, t1, fb1, fb1p, f1, f1p;
	Font title = new Font("SanSerif", Font.BOLD, 25);
	Font position = new Font("SanSerif", Font.BOLD, 20);

	public Prime(){
		toiletinfo = new JPanel();
		toiletinfo.setLayout(new BoxLayout(toiletinfo, BoxLayout.X_AXIS));
		toiletinfo.setBackground(Color.WHITE);

		img = new ImageIcon("./toilet/2_prime.png");
		image = new JLabel(img);

		textinfo= new JPanel();
		textinfo.setLayout(new BoxLayout(textinfo, BoxLayout.Y_AXIS));
		textinfo.setBackground(Color.WHITE);

		t1 = new JLabel("   프라임관  ");
		t1.setFont(title);
		t1.setBackground(new Color(185, 107, 198));
		t1.setForeground(Color.WHITE);
		t1.setOpaque(true); 
		
		textinfo_f= new JPanel(new GridLayout(2, 1));
		textinfo_f.setBackground(Color.WHITE);

		fb1 = new JLabel("B1층");
		fb1.setFont(position);
		fb1.setForeground(Color.RED);
		
		f1 = new JLabel("1-3층");
		f1.setFont(position);
		
		textinfo_f.add(fb1);
		textinfo_f.add(f1);

		textinfo_p = new JPanel(new GridLayout(2, 1));
		textinfo_p.setBackground(Color.WHITE);

		fb1p = new JLabel("E.V 앞");
		fb1p.setFont(position);
		fb1p.setForeground(Color.RED);
		
		f1p = new JLabel("E.V 바로 앞 복도 오른편");
		f1p.setFont(position);
		
		textinfo_p.add(fb1p);
		textinfo_p.add(f1p);

		textinfo_t = new JPanel();
		textinfo_t.setLayout(new BoxLayout(textinfo_t, BoxLayout.X_AXIS));
		textinfo_t.setBackground(Color.WHITE);
		
		textinfo_t.add(Box.createHorizontalStrut(30));
		textinfo_t.add(textinfo_f);
		textinfo_t.add(Box.createHorizontalStrut(20));
		textinfo_t.add(textinfo_p);
		textinfo_t.add(Box.createHorizontalStrut(30));
		textinfo_t.setBorder(new LineBorder(new Color(185, 107, 198)));

		textinfo.add(t1);
		textinfo.add(textinfo_t);
		t1.setAlignmentX(Component.CENTER_ALIGNMENT);
		textinfo_t.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		toiletinfo.add(image);
		toiletinfo.add(Box.createHorizontalStrut(50));
		toiletinfo.add(textinfo);

		add(toiletinfo);

		setBackground(Color.WHITE);
	}

	public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
		g2d.fillOval(153, 350, 15, 15);

		g2d.setColor(Color.BLUE);
		g2d.fillOval(184, 190, 15, 15);

		g2d.setColor(Color.BLACK);
		g2d.fillOval(230, 280, 10, 10);

		g2d.setColor(Color.BLUE);
		g2d.fillOval(230, 305, 10, 10);

		String[] p = {"현위치", "화장실위치"};

        int textX = 250;
        int textY = 290; 

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SanSerif", Font.BOLD, 13));

       for (int i = 0 ; i < p.length; i++){
		   g2d.drawString(p[i], textX, textY + (i * 25));
       }

	}
}
