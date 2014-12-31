package com.randomj.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.randomj.gameobjects.Enums.AIType;
import com.randomj.gameobjects.Enums.PlayerNo;

public abstract class Player {
	
	protected PlayerNo playerNo;
	protected AIType ai;
	protected String name;
	protected Color color;
	protected int pattern;
	
	public Player(PlayerNo playerNo, AIType ai, String name, Color color,
			int pattern) {
		this.playerNo = playerNo;
		this.ai = ai;
		this.name = name;
		this.color = color;
		this.pattern = pattern;
	}

	public abstract boolean isHuman();
	public abstract void act();
	
	public PlayerNo getPlayerNo() {
		return playerNo;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public int getPattern() {
		return pattern;
	}
}
