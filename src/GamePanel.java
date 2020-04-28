import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	@Override
	
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	Timer frameDraw;
	GamePanel(){
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
	}
	
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    public static final Color NIGHT_SKY = new Color(30,10,90);
    public static final Color STAR = new Color(210,250,230);
    Font titleFont = new Font("Arial", Font.PLAIN,48);
    Font enter_spaceFont = new Font("Arial", Font.PLAIN,24);
    Rocketship r = new Rocketship(225,700,50,50);
    ObjectManager oj = new ObjectManager(r);
    
    
	
    void updateMenuState() {
		
	}
	
	void updateGameState() {
		oj.update();
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {  
		g.setColor(NIGHT_SKY);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(STAR);
		g.drawString("LEAGUE INVADERS", 27, 100);
		g.setFont(enter_spaceFont);
		g.setColor(STAR);
		g.drawString("Press ENTER to start", 125, 350);
		g.setFont(enter_spaceFont);
		g.setColor(STAR);
		g.drawString("Press SPACE for instructions", 90, 550);
	}
	
	void drawGameState(Graphics g) {  
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		oj.draw(g);
	}
	
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(STAR);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(enter_spaceFont);
		g.setColor(STAR);
		g.drawString("You killed enemies", 145, 350);
		g.setFont(enter_spaceFont);
		g.setColor(STAR);
		g.drawString("Press ENTER to restart", 120, 550);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if(currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
				System.out.println("UP");
				if(r.y>0) {
					r.up();
				}
			}
		
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
				if(r.y<725) {
					r.down();
				}
			}	
		
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				if(r.x<450) {
					r.right();
				}
			}
		
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				if(r.x>0) {
					r.left();
				}
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
