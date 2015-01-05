package com.randomj.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.randomj.gameobjects.Enums.AIType;
import com.randomj.gameobjects.Enums.PlayerNo;

public class AI extends Player {

	private AIType ai;
	
	public AI(PlayerNo playerNo, AIType ai, String name, Color color, int pattern) {
		this.playerNo = playerNo;
		this.ai = ai;
		this.name = name;
		this.color = color;
		reset();		
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHuman() {
		return false;
	}

}
