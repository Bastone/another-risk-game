package com.randomj.turn;

import java.util.ArrayList;

import com.randomj.gameobjects.Country;
import com.randomj.gameobjects.Player;

public class Distribution extends Turn {
	
	private ArrayList<Player> players;

	public Distribution(ArrayList<Player> players) {
		this.players = players;
		int unitsPerPlayer = 50 - 5 * players.size();
		
		for (Player player: players)
			player.addUnits(unitsPerPlayer);
	}

	@Override
	public void onPick(Country picked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ended() {
		// TODO Auto-generated method stub
		
	}

}
