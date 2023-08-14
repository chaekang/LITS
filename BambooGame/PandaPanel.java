
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.Random;
 
class PandaPanel extends JPanel{
	static int rock_wa[]={40, 50, 60, 70, 80};
	static int bamboo_wha[][]={{45, 65}, {56, 83}, {68, 100}};
	// Generating an angle 0 ~ 11 =>-75 ~ 75
	// Enter the speed of the xy axis, depending on the angle.(x=cos(angle), y=sin(angle))
	// Multiply this by the speed (pixels/thread time(0.1second))
	// Move that much in the corresponding angular direction for 0.1 seconds.
	double rand_ang[][]={{0.259, 0.965}, {0.5, 0.866}, {0.707, 0.707}, {0.866, 0.5}, {0.965, 0.259}, {1.0, 0.0}, 
		{0.866, -0.259}, {0.866,-0.5}, {0.707,-0.707}, {0.5,-0.866}, {0.259,-0.965}};
	int rock_no=0, bamboo_no=0;
	int rock_no_max=15, bamboo_no_max=10;
	int bamboo_eat=0, game_time=0;
	boolean gamedraw_on;
	boolean thread_rock_time=false, thread_bamboo_time=false;
	
	int[][] inter_square=new int[5][2];//Internal rectangular coordinate arrangement according to the size of the stone

	RockCodi[] p_rock = new RockCodi[rock_no_max];
	BambooCodi[] p_bam = new BambooCodi[bamboo_no_max];
	int panda_x=0, panda_y=0;
	Random pp_rand = new Random();
	PandaImage panda = new PandaImage();
	Image img_panda;
	Image[][] img_rock=new Image[3][5];

	BambooImage bamboo = new BambooImage();
	Image[] img_bamboo=new Image[3];

	Image img_panel;
	Graphics2D g_panel;
	BufferedImage buf_panel = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);;
	Color color_trans=new Color(255, 0, 0, 0);

	public PandaPanel() {
		for(int i=0; i<rock_no_max; i++) p_rock[i] = new RockCodi();
		for(int i=0; i<bamboo_no_max; i++) p_bam[i] = new BambooCodi();
		for(int i=0; i<5; i++){
			inter_square[i][0]=(int)(rock_wa[i]*0.146); //x1=y1: Reference: 0.146=(1-sin((45))/2
			inter_square[i][1]=(int)(rock_wa[i]*0.854); //x2=y2
		}		
		setBackground(new Color(255, 255, 219));

		//Creates a buffer image of a panda
		BufferedImage buf_panda = new BufferedImage(56, 83,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g_pan = buf_panda.createGraphics();
		img_panda=buf_panda;
		panda.PandaImageDraw(g_pan);

		RockImage();//Creates a buffer image of a rock

		//Creates a buffer image of a bomboo
		for(int i=0; i<3; i++){
			BufferedImage buf_bamboo = new BufferedImage(bamboo_wha[i][0],bamboo_wha[i][1],BufferedImage.TYPE_INT_ARGB);
			Graphics2D g_bam = buf_bamboo.createGraphics();
			img_bamboo[i]=buf_bamboo;
			bamboo.BambooDraw(0.8+i*0.2, g_bam);
		}
		PandaInit();
	}
	public void PandaInit(){
		panda_x=372; 
		panda_y=358;
		rock_no=0;
		bamboo_no=0;
		game_time=0;
		bamboo_eat=0;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gppanda=(Graphics2D) g;
		gppanda.drawImage(img_panel,0,0, this);
	}
	public void BufferDrawPanel(){
		g_panel = buf_panel.createGraphics();
		img_panel=buf_panel;
		g_panel.setBackground(color_trans);
		g_panel.clearRect(0,0, 800, 800);
		RockDeleteSearch();
		BambooDeleteSearch();
		BambooEat();
		RockHit();
		g_panel.drawImage(img_panda, panda_x, panda_y, this);
		for(int i=0; i<rock_no; i++){
			g_panel.drawImage(img_rock[p_rock[i].rock_hit][p_rock[i].rock_i], (int) p_rock[i].rock_x, (int) p_rock[i].rock_y, this);
			p_rock[i].RockCodiMove();
		}
		for(int i=0; i<bamboo_no; i++){
			g_panel.drawImage(img_bamboo[p_bam[i].bam_i], (int) p_bam[i].bam_x, (int) p_bam[i].bam_y, this);
			p_bam[i].BambooCodiMove();
		}
		if(thread_rock_time==true && rock_no < rock_no_max) RockCreate();
		thread_rock_time=false;
		if(thread_bamboo_time==true && bamboo_no < bamboo_no_max) BambooCreate();
		thread_bamboo_time=false;
	}
	
	public void RockHit(){
		int pan_x1=panda_x+8, pan_x2=pan_x1+40,  pan_y1=panda_y+4, pan_y2=pan_y1+75;
		int rock_x1, rock_y1, rock_x2, rock_y2;
		for(int i=0; i<rock_no; i++){
			rock_x1=(int)(p_rock[i].rock_x+inter_square[p_rock[i].rock_i][0]);
			rock_y1=(int)(p_rock[i].rock_y+inter_square[p_rock[i].rock_i][0]);
			rock_x2=(int)(p_rock[i].rock_x+inter_square[p_rock[i].rock_i][1]);
			rock_y2=(int)(p_rock[i].rock_y+inter_square[p_rock[i].rock_i][1]);
			if(((rock_x1>pan_x1&&rock_x1<pan_x2)||(rock_x2>pan_x1&&rock_x2<pan_x2)||(rock_x1<pan_x1&&rock_x2>pan_x2))
			&&((rock_y1>pan_y1&&rock_y1<pan_y2)||(rock_y2>pan_y1&&rock_y2<pan_y2)||(rock_y1<pan_y1&&rock_y2>pan_y2))){
				bamboo_eat=bamboo_eat-(3-(int)((p_rock[i].rock_i+1)/2));//rock_dx wight : 4, 3=> 1, 2, 1=>2, 1=>3
				RockDelete(i);
				i--;
			}
		}
	}
	public void BambooEat(){
		int pan_x1=panda_x+8, pan_x2=pan_x1+40,  pan_y1=panda_y+4, pan_y2=pan_y1+75;
		int bam_x1, bam_y1, bam_x2, bam_y2;
		for(int i=0; i<bamboo_no; i++){
			bam_x1=(int)p_bam[i].bam_x;
			bam_y1=(int)p_bam[i].bam_y;
			bam_x2=(int)(bam_x1+bamboo_wha[p_bam[i].bam_i][0]);
			bam_y2=(int)(bam_y1+bamboo_wha[p_bam[i].bam_i][1]);
			if(((bam_x1>pan_x1&&bam_x1<pan_x2)||(bam_x2>pan_x1&&bam_x2<pan_x2)||(bam_x1<pan_x1&&bam_x2>pan_x2))
			&&((bam_y1>pan_y1&&bam_y1<pan_y2)||(bam_y2>pan_y1&&bam_y2<pan_y2)||(bam_y1<pan_y1&&bam_y2>pan_y2))){
				bamboo_eat=bamboo_eat+(3-p_bam[i].bam_i);
				BambooDelete(i);
				i--;
			}
		}
	}

	public void RockCreate(){
		int ra_i=pp_rand.nextInt(11);
		double vel=10.0;
		int rand_wi=pp_rand.nextInt(5);
		double rand_y=pp_rand.nextInt(4)*200.0+100.0; // 100, 300, 500, 700
		pp_rand.nextInt();
		p_rock[rock_no].RockCodiCreate(0.0, rand_y-0.5*rock_wa[rand_wi], rand_wi, vel*rand_ang[ra_i][0], vel*rand_ang[ra_i][1]);
		rock_no++;
	}
	public void RockDeleteSearch(){
		for(int i=0; i<rock_no; i++){
			if(p_rock[i].rock_i < 0){
				RockDelete(i);
				i--;
			}
		}
	}
	public void RockDelete(int rd_ind){
		for(int i=rd_ind; i<rock_no-1; i++){
			p_rock[i].rock_x=p_rock[i+1].rock_x;
			p_rock[i].rock_y=p_rock[i+1].rock_y;
			p_rock[i].rock_i=p_rock[i+1].rock_i;
			p_rock[i].rock_dx=p_rock[i+1].rock_dx;
			p_rock[i].rock_dy=p_rock[i+1].rock_dy;
			p_rock[i].rock_hit=p_rock[i+1].rock_hit;
		}
		rock_no--;
	}

	public void BambooCreate(){
		int ra_i=pp_rand.nextInt(11);
		double vel=8.0;		

		int rand_whi=pp_rand.nextInt(3);
		vel=vel+(2-rand_whi)*4.0; //The smaller the bamboo, the faster the speed

		double rand_y=pp_rand.nextInt(4)*200.0+100.0; // 100, 300, 500, 700
		p_bam[bamboo_no].BambooCodiCreate(800.0-bamboo_wha[rand_whi][0], rand_y-0.5*bamboo_wha[rand_whi][1], rand_whi, -vel*rand_ang[ra_i][0], vel*rand_ang[ra_i][1]);
		bamboo_no++;
	}
	public void BambooDeleteSearch(){
		for(int i=0; i<bamboo_no; i++){
			if(p_bam[i].bam_i < 0){
				BambooDelete(i);
				i--;
			}
		}
	}
	public void BambooDelete(int bd_ind){
		for(int i=bd_ind; i<bamboo_no-1; i++){
			p_bam[i].bam_x=p_bam[i+1].bam_x;
			p_bam[i].bam_y=p_bam[i+1].bam_y;
			p_bam[i].bam_i=p_bam[i+1].bam_i;
			p_bam[i].bam_dx=p_bam[i+1].bam_dx;
			p_bam[i].bam_dy=p_bam[i+1].bam_dy;
			p_bam[i].bam_hit=p_bam[i+1].bam_hit;
		}
		bamboo_no--;
	}
	public void RockImage(){
		GradientPaint grad_rock;
		Color ri_color[]={Color.black, Color.blue, Color.red};
		for(int i=0; i<3; i++){
			for(int j=0; j<5; j++){
				grad_rock = new GradientPaint(0, 0, Color.white, rock_wa[j], rock_wa[j], ri_color[i]);
				BufferedImage buf_rock = new BufferedImage(rock_wa[j], rock_wa[j],BufferedImage.TYPE_INT_ARGB);
				Graphics2D g_rock = buf_rock.createGraphics();
				img_rock[i][j]=buf_rock;
				g_rock.setPaint(grad_rock);
				g_rock.fill(RockGPath((double)rock_wa[j]/50));
				//g_rock.fillOval(0, 0, rock_wa[i][j], rock_wa[i][j]);
				//RockImage((double)rock_wa[i][j]/50.0, g_rock);
			}
		}
	}


	public GeneralPath RockGPath(double ri_sc){
		GeneralPath rock_path = new GeneralPath();
		rock_path.moveTo(4*ri_sc,26*ri_sc);
	 	rock_path.quadTo(0*ri_sc, 8*ri_sc, 14*ri_sc, 8*ri_sc);
	 	rock_path.quadTo(27.5*ri_sc, -6*ri_sc, 40*ri_sc, 8*ri_sc);
	 	rock_path.quadTo(47.5*ri_sc, 12.5*ri_sc, 47*ri_sc, 23*ri_sc);
	 	rock_path.quadTo(52*ri_sc, 48.5*ri_sc, 32*ri_sc, 45*ri_sc);
	 	rock_path.quadTo(23.5*ri_sc, 53*ri_sc, 14*ri_sc, 40*ri_sc);
	 	rock_path.quadTo(-5*ri_sc, 36*ri_sc, 4*ri_sc, 27*ri_sc);
	 	rock_path.closePath();
		return rock_path;
	}		
		
}
	
