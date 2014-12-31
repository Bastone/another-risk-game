package com.randomj.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button {
	
	private Sprite sprite;
	private BitmapFont font;
	private float textBorder;
	
	public Button(Texture texture, BitmapFont font, float x, float y, float width, float height) {
		this.font = font;
		sprite = new Sprite(texture);
		sprite.setBounds(x, y, width, height);
		
		textBorder = 10;
	}
	
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
		if (font != null)
			font.draw(batch, "Bottone", sprite.getX() + textBorder, sprite.getY() + textBorder);	
	}

	public boolean isTouchDown(float x, float y) {
		return sprite.getBoundingRectangle().contains(x, y);
	}
	
	public float getX() {
		return sprite.getX();
	}
	
	public float getY() {
		return sprite.getY();
	}

}
