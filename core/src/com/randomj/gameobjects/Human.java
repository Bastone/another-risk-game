package com.randomj.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.randomj.gameobjects.Enums.AIType;
import com.randomj.gameobjects.Enums.PlayerNo;

public class Human extends Player {

	public Human(PlayerNo playerNo, AIType ai, String name, Color color,
			int pattern) {
		super(playerNo, ai, name, color, pattern);
	}

	@Override
	public boolean isHuman() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

}
