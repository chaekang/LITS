import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.geom.*;

public class Music extends JPanel{
	JPanel toiletinfo, textinfo, textinfo_f, textinfo_p, textinfo_t;
	ImageIcon img;
	JLabel image, t1, fb1, fb1p, f7, f7p;
	Font title = new Font("SanSerif", Font.BOLD, 25);
	Font position = new Font("SanSerif", Font.BOLD, 20);

	public Music(){
		toiletinfo = new JPanel();
		toiletinfo.setLayout(new BoxLayout(toiletinfo, BoxLayout.X_AXIS));
		toiletinfo.setBackground(Color.WHITE);

		img = new ImageIcon("./toilet/2_music.png");
		image = new JLabel(img);

		textinfo= new JPanel();
		textinfo.setLayout(new BoxLayout(textinfo, BoxLayout.Y_AXIS));
		textinfo.setBackground(Color.WHITE);

		t1 = new JLabel("   음악대학   ");
		t1.setFont(title);
		t1.setBackground(new Color(185, 107, 198));
		t1.setForeground(Color.WHITE);
		t1.setOpaque(true); 
		
		textinfo_f= new JPanel(new GridLayout(2, 1));
		textinfo_f.setBackground(Color.WHITE);

		fb1 = new JLabel("B1-6층");
		fb1.setFont(position);
		fb1.setForeground(Color.RED);

		f7 = new JLabel("7층");
		f7.setFont(position);
		
		textinfo_f.add(fb1);
		textinfo_f.add(f7);

		textinfo_p = new JPanel(new GridLayout(2, 1));
		textinfo_p.setBackground(Color.WHITE);

		fb1p = new JLabel("E.V 뒤");
		fb1p.setFont(position);
		fb1p.setForeground(Color.RED);

		f7p = new JLabel("없음");
		f7p.setFont(position);
		
		textinfo_p.add(fb1p);
		textinfo_p.add(f7p);

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
		toiletinfo.add(Box.createHorizontalStrut(80));
		toiletinfo.add(textinfo);

		add(toiletinfo);

		setBackground(Color.WHITE);
	}

	public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
		g2d.fillOval(272, 310, 15, 15);

		g2d.setColor(Color.BLUE);
		g2d.fillOval(157, 440, 15, 15);

		g2d.setColor(Color.BLUE);
		g2d.fillOval(144, 315, 15, 15);

		g2d.setColor(Color.BLACK);
		g2d.fillOval(60, 60, 10, 10);

		g2d.setColor(Color.BLUE);
		g2d.fillOval(60, 85, 10, 10);

		String[] p = {"현위치", "화장실위치"};

        int textX = 80;
        int textY = 70; 

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SanSerif", Font.BOLD, 13));

       for (int i = 0 ; i < p.length; i++){
		   g2d.drawString(p[i], textX, textY + (i * 25));
       }

	}
}
