import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class PandaMain {

	static int endframe_Message = 0;
	boolean t_panda_run=true;
	boolean t_rockbam_run=true;

	JFrame pf = new JFrame("Panda Game");
	EndFrame ef = new EndFrame();
	PandaPanel pp=new PandaPanel();
	PandaScore pc=new PandaScore();

	Thread t_panda = new Thread(new ThreadPanda());
	Thread t_rockbam = new Thread(new ThreadRockBam());
	Random pm_rand = new Random();
	boolean key_rel=true;

	PandaMain(){
		pf.setBackground(new Color(0,0,0));
		pf.setSize(1020, 840);
		pf.setLayout(null);
		pf.setLocationRelativeTo(null);
		ef.setVisible(false);
		ef.setLocationRelativeTo(null);

		
		pf.add(pp);
		pp.setBounds(0, 0, 800,800);
		pp.setBorder(BorderFactory.createLineBorder(Color.blue));
		pf.add(pc);
		pc.setBounds(801, 0, 200, 800);
		pc.setBorder(BorderFactory.createLineBorder(Color.red));
		

		//Center of Screen
		//pf.setLocationRelativeTo(null);
		
		pf.setVisible(true);
		pf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e_k) {
				if(key_rel==true){

					switch (e_k.getKeyCode()) {
						case KeyEvent.VK_DOWN:
							if(pp.panda_y<(780-85))pp.panda_y=(pp.panda_y+20);
							break;
						case KeyEvent.VK_UP:
							if(pp.panda_y>20)pp.panda_y=(pp.panda_y-20);
							break;
						case KeyEvent.VK_LEFT:
							if(pp.panda_x>20)pp.panda_x=(pp.panda_x-20);
							break;
						case KeyEvent.VK_RIGHT:
							if(pp.panda_x<(780-56))pp.panda_x=(pp.panda_x+20);
							break;
						default:
							break;
					}
					key_rel=false;
				}
			}
			public void keyReleased(KeyEvent e_k) {  
				key_rel=true;
			}
		});
		t_panda.start();
		t_rockbam.start();
	}
	class ThreadPanda implements Runnable {
		public void run() {
			try {
				while(true){
					if(endframe_Message!=0){
						if(endframe_Message==1){
							pp.PandaInit();
							t_panda_run=true;
						}else break;
					}
					while(t_panda_run){
						Thread.sleep(100);
						pp.BufferDrawPanel();
						pp.repaint();
	
						if(pp.bamboo_eat<0){
							ef.setTitle("Game Over");
							ef.titleLabel.setText("Game Over");
							ef.scoreLabel.setText("Time : " +pp.game_time);
							ef.setVisible(true);
							endframe_Message=0;
							t_panda_run=false;
						}
						if(pp.bamboo_eat>=20){
							ef.setTitle("Game Complete");
							ef.titleLabel.setText("Game Complete");
							ef.scoreLabel.setText("Time : " +pp.game_time);
							ef.setVisible(true);
							endframe_Message=0;
							t_panda_run=false;
						}
					}
					Thread.sleep(100);
				}
				t_rockbam_run=false;
				Thread.sleep(2000);
				System.exit(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	class ThreadRockBam implements Runnable {
		public void run() {
			try {
				while(t_rockbam_run){
					Thread.sleep(1000);
					pp.game_time++;
					pp.thread_rock_time=true;
					if(pm_rand.nextInt(7)==0) pp.thread_bamboo_time=true;
					pc.updateScore(pp.bamboo_eat);
					pc.updateTime(pp.game_time);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]){
		new PandaMain();
	}
}
