package model;

import java.awt.Graphics;

import util.Constants;

public class Bullet extends FlyObject{
	
	boolean isLife;


	public Bullet(String path, int x, int y, int width, int height) {
		super(path, x, y, width, height);
		this.x = x;
		this.y = y;

	}
	
	public void drawBullet(Graphics g) {
			g.drawImage(img, x, y,null);
			Move();
	}
	
	public void Move(){
		y -=Constants.BULLET_SPEED;
		if(y<0){
			isLife=false;
		}
	}	
	
	
	
}
