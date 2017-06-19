package game;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import frame.MyFrame;
import model.BackGround;
import model.Bullet;
import model.EnemyPlane;
import model.Explode;
import model.Plane;
import util.Constants;

public class MyGameFrame extends MyFrame {
	/**
	 * 
	 */
	int hh=0;
	private static final long serialVersionUID = 1L;
	Plane p = new Plane("images/MyPlane.png", Constants.PLANE_X, Constants.PLANE_Y, Constants.PLANE_SIZE,
			Constants.PLANE_SIZE);
	EnemyPlane ep;
	Explode explode;
	// 实例化敌机集合
	List<EnemyPlane> ep_list = new ArrayList<EnemyPlane>();
	//成绩
	Grade grade=new Grade();
	// 产生敌机
	public void createEnemyPlane() {
		// int x = (new Random()).nextInt(550);
		ep = new EnemyPlane("images/EnemyPlane.png", 100, 100, Constants.PLANE_SIZE, Constants.PLANE_SIZE);
		ep_list.add(ep);
		ep = new EnemyPlane("images/EnemyPlane.png", 300, 100, Constants.PLANE_SIZE, Constants.PLANE_SIZE);
		ep_list.add(ep);
	}

	public void paint(Graphics g) {
		createEnemyPlane();
		/* 绘制背景 */
		BackGround.drawMe(g);
		/* 绘制我方飞机 */
		p.draw(g);
		/* 绘制成绩 */
		grade.draw(g,hh);
		/* 绘制敌机 */
		for (int i = 0; i < ep_list.size(); i++) {
			EnemyPlane enplane = ep_list.get(i);
			boolean b = false;
			for (int j = 0; j < p.getBulletlist().size(); j++) {
				b=enplane.isIntersected(p.getBulletlist().get(j));
				if(b)break;
			}
			if(b==true){
				ep_list.remove(enplane);
			}else{
				enplane.draw(g);
			}

		}	
		}
				

	public static void main(String[] args) {
		new MyGameFrame().launchFrame();
	}

	public void launchFrame() {
		super.LaunchFrame();
		// 增加键盘的监听
		addKeyListener(new KeyMonitor());
	}

	// 定义为内部类，可以方便的使用外部类的普通属性
	class KeyMonitor extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// System.out.println("按下："+e.getKeyCode());
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
	}

}
