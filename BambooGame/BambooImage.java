import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class BambooImage{

	BambooImage(){
	}
	
	public void BambooDraw(Double bb_sc, Graphics2D g2) {

		GeneralPath bb1_path = new GeneralPath();
		GeneralPath bb2_path = new GeneralPath();
		GeneralPath bb3_path = new GeneralPath();
		GeneralPath bb4_path = new GeneralPath();

		//Bamboo detail
		g2.setColor(Color.green);
		g2.fillRoundRect((int)(17*bb_sc), (int)(1*bb_sc), (int)(22*bb_sc), (int)(5*bb_sc), (int)(5*bb_sc), (int)(5*bb_sc));
		g2.fillRect((int)(21*bb_sc), (int)(6*bb_sc), (int)(15*bb_sc), (int)(20*bb_sc)); 
		g2.fillRoundRect((int)(17*bb_sc), (int)(26*bb_sc),(int)( 22*bb_sc), (int)(5*bb_sc), (int)(5*bb_sc), (int)(5*bb_sc));
		g2.fillRect((int)(21*bb_sc), (int)(32*bb_sc), (int)(15*bb_sc), (int)(20*bb_sc)); 
		g2.fillRoundRect((int)(17*bb_sc), (int)(52*bb_sc), (int)(22*bb_sc), (int)(5*bb_sc), (int)(5*bb_sc), (int)(5*bb_sc));
		g2.fillRect((int)(21*bb_sc), (int)(58*bb_sc), (int)(15*bb_sc), (int)(20*bb_sc)); 
		g2.fillRoundRect((int)(17*bb_sc), (int)(78*bb_sc), (int)(22*bb_sc), (int)(5*bb_sc), (int)(5*bb_sc), (int)(5*bb_sc));

		g2.setColor(new Color(0, 128,0));
		bb1_path.moveTo(36*bb_sc, 52*bb_sc); 
		bb1_path.quadTo(48*bb_sc, 46*bb_sc, 48*bb_sc, 28*bb_sc); 
		bb1_path.quadTo(36*bb_sc, 35*bb_sc, 36*bb_sc, 52*bb_sc); 
		g2.fill(bb1_path);
		bb2_path.moveTo(36*bb_sc, 52*bb_sc); 
		bb2_path.quadTo(49*bb_sc, 55*bb_sc, 56*bb_sc, 48*bb_sc);
		bb2_path.quadTo(41*bb_sc, 41*bb_sc, 36*bb_sc, 52*bb_sc); 
		g2.fill(bb2_path);

		bb3_path.moveTo(20*bb_sc, 24*bb_sc); 
		bb3_path.quadTo(8*bb_sc, 18*bb_sc, 8*bb_sc, 0); 
		bb3_path.quadTo(20*bb_sc, 7*bb_sc, 20*bb_sc, 24*bb_sc); 
		g2.fill(bb3_path);
		bb4_path.moveTo(20*bb_sc, 24*bb_sc); 
		bb4_path.quadTo(7*bb_sc, 27*bb_sc, 0, 16*bb_sc); 
		bb4_path.quadTo(15*bb_sc, 13*bb_sc, 20*bb_sc, 24*bb_sc); 
		g2.fill(bb4_path);
	
	}
}
