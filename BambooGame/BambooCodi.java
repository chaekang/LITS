import java.awt.*;

class BambooCodi{
	double bam_x, bam_y, bam_dx, bam_dy;
	int bam_i, bam_hit;
	BambooCodi(){

	}
	public void BambooCodiCreate(double bam_x, double bam_y, int bam_i, double bam_dx, double bam_dy){
		this.bam_x = bam_x;
		this.bam_y = bam_y;
		this.bam_i = bam_i;
		this.bam_dx = bam_dx;
		this.bam_dy = bam_dy;
		this.bam_hit=0;
	}
	public void BambooCodiMove(){
		bam_x =bam_x+bam_dx;
		bam_y =bam_y+bam_dy;
		if(bam_x >= (800.0-PandaPanel.bamboo_wha[bam_i][0]) || bam_x < 0.0){
			bam_dx = -bam_dx;
			bam_hit++;
		}
		if(bam_y >= (800.0-PandaPanel.bamboo_wha[bam_i][1]) || bam_y < 0.0){
			bam_dy = -bam_dy;
			bam_hit++;
		}
		if(bam_hit>1){
			bam_hit=0;
			bam_i=-1;
		}

	}
}

