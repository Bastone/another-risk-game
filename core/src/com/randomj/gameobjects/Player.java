package com.randomj.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.randomj.gameobjects.Enums.PlayerNo;

public abstract class Player {
	
	protected PlayerNo playerNo;
	protected String name;
	protected Color color;
	protected long pattern;
	protected int units;

	public abstract void act();
	public abstract boolean isHuman();
	
	public void reset() {
		pattern = 0;
		units = 0;
	}
	
	public PlayerNo getPlayerNo() {
		return playerNo;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public long getPattern() {
		return pattern;
	}
	
	public void addUnits(int amount) {
		units += amount;
	}
	
	public void conquer(Country country, int units) {
		pattern = pattern | country.getPattern();
		country.setOwner(this);
		country.addUnits(units);
	}
}
