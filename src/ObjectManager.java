import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ObjectManager(Rocketship s){
		rocket = s;
	}
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	Random r = new Random();

	void addAlien(Alien a) {
		aliens.add(new Alien(r.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		for(Alien a : aliens) {
			a.update();
			if(a.y>LeagueInvaders.HEIGHT) {
				a.isActive=false;
			}
		}
		for(Projectile p: projectiles) {
			p.update();
			if(p.y>LeagueInvaders.HEIGHT) {
				p.isActive=false;
			}
		}
	}
	
	void draw(Graphics g) {
		rocket.draw(g);
		for(Alien a : aliens) {
			a.draw(g);
		}
		for(Projectile p: projectiles) {
			p.draw(g);
		}
	}
	
	void purgeObjects(){
		for(int i = 0; i<aliens.size();i++) {
			if(aliens.get(i).isActive==false) {
				aliens.remove(i);
			}
		}
		for(int i = 0; i<projectiles.size();i++) {
			if(projectiles.get(i).isActive==false) {
				projectiles.remove(i);
			}
		}
	}
}
