package com.randomj.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Bulga {
	
	private Texture texture;
	private ArrayList<Sprite> bulgas;
	private float width, height;
	private float screenHeight, screenWidth;
	
	public Bulga(Texture texture, float screenHeight, float screenWidth) {
		bulgas = new ArrayList<Sprite>();
		
		this.texture= texture;		
		width = 50;
		height = 80;
		
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
	}
	
	public void spawn() {
		Sprite bulga = new Sprite(texture);
		bulga.setSize(width, height);
		bulga.setPosition(MathUtils.random(width, screenWidth - width), screenHeight);
		bulgas.add(bulga);
	}
	
	public void drop() {
		for (int i = 0; i < bulgas.size(); i++) {
			bulgas.get(i).translateY(-1);
			if (bulgas.get(i).getY() < - height) {
				bulgas.remove(i);
			}
		}
	}
	
	public void draw(SpriteBatch batch) {
		for (Sprite bulga: bulgas) {
			bulga.draw(batch);
		}
	}

}
