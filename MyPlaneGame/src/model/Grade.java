package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Grade {

	public void draw(Graphics g,int hh){
		
		String s="成绩:"+hh;
		Font f=new Font("宋体",Font.PLAIN,25);
		Color c=Color.BLACK;
		g.setColor(c);
		g.setFont(f);
		g.drawString(s, 20,60);
	}
}
