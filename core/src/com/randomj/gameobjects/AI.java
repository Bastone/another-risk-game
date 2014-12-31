package com.randomj.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.randomj.gameobjects.Enums.AIType;
import com.randomj.gameobjects.Enums.PlayerNo;

public class AI extends Player {

	public AI(PlayerNo playerNo, AIType ai, String name, Color color,
			int pattern) {
		super(playerNo, ai, name, color, pattern);
	}

	@Override
	public boolean isHuman() {
		return false;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

}
