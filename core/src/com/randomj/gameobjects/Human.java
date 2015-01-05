package com.randomj.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.randomj.gameobjects.Enums.PlayerNo;

public class Human extends Player {

	public Human(PlayerNo playerNo, String name, Color color) {
		this.playerNo = playerNo;
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
		return true;
	}

}
