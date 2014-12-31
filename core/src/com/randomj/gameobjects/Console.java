package com.randomj.gameobjects;

import java.util.LinkedList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Console {
	
	private Sprite sprite;
	private LinkedList<String> log;
	private float textPositionX, textPositionY, span;
	private BitmapFont font;
	
	public Console(Texture texture, BitmapFont font, float screenWidth) {
		this.font = font;
		log = new LinkedList<String>();
		
		sprite = new Sprite(texture);
		sprite.setPosition(screenWidth / 2 - sprite.getWidth() / 2, 0);
		
		textPositionX = (int) (screenWidth / 2 - sprite.getWidth() / 2 + 50);
		textPositionY = 20;
		span = 20;
	}
	
	public void log(String string) {
		if (log.size() == 3) {
			log.removeLast();
		}
		log.addFirst(string);
	}
	
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
			if (!log.isEmpty()) {
				for (int i = 0; i < log.size(); i++) 
					font.draw(batch, log.get(i), textPositionX, textPositionY + span * i); 
			}		

	}

	public float getX() {
		return sprite.getX();
	}
	
	public float getY() {
		return sprite.getY();
	}

	public float getWidth() {
		return sprite.getWidth();
	}
	
	public float getHeight() {
		return sprite.getHeight();
	}

}
