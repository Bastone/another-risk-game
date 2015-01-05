package com.randomj.turn;

import com.randomj.gameobjects.Country;
import com.randomj.gameobjects.Player;

public abstract class Turn {

	protected Player player;
	
	public abstract void onPick(Country picked);
	public abstract void buttonPressed();
	public abstract void ended();
	

}
