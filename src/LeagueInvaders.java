import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	public static void main(String[] args) {
		LeagueInvaders ship = new LeagueInvaders();
		ship.setup();
	}
	GamePanel game = new GamePanel();
	void setup() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.setSize(500, 800);
		frame.add(game);
		frame.addKeyListener(game);
	}
}
