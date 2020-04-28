import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g){
		 g.setColor(Color.MAGENTA);
	     g.fillRect(x, y, width, height);
	}
	
	void update(){
		y+=speed;
	}

}
