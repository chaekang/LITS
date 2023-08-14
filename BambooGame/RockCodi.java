import java.awt.*;

class RockCodi{
	double rock_x, rock_y, rock_dx, rock_dy;
	int  rock_i, rock_hit=0;
	RockCodi(){

	}
	public void RockCodiCreate(double rock_x, double rock_y, int rock_i, double rock_dx, double rock_dy){
		this.rock_x = rock_x;
		this.rock_y = rock_y;
		this.rock_i = rock_i;
		this.rock_dx = rock_dx;
		this.rock_dy = rock_dy;
		this.rock_hit=0;
	}
	public void RockCodiMove(){
		rock_x =rock_x+rock_dx;
		rock_y =rock_y+rock_dy;
		if(rock_x >= (800.0-PandaPanel.rock_wa[rock_i]) || rock_x < 0.0){
			rock_dx = -rock_dx;
			rock_hit++;
		}
		if(rock_y >= (800.0-PandaPanel.rock_wa[rock_i]) || rock_y < 0.0){
			rock_dy = -rock_dy;
			rock_hit++;
		}
		if(rock_hit>2){
			rock_hit=0;
			rock_i--;
		}
	}
}

