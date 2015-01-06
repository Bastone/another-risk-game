package com.randomj.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.randomj.gameobjects.Enums.CardType;

public class Card {
	
	private Country country;
	private CardType type; // Vedi Enum.java
	private Sprite sprite;
	
	public Card(Country country, CardType type, Texture texture) {
		this.country = country;
		this.type = type;
		//sprite = new Sprite(texture);
	}
	
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

}
