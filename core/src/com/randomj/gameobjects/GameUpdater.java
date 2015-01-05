package com.randomj.gameobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.randomj.gameobjects.Enums.GameState;
import com.randomj.gameobjects.Enums.TurnPhase;
import com.randomj.turn.Distribution;
import com.randomj.turn.Turn;

public class GameUpdater {

	private Map map;
	private GameState state;
	private Turn turn;
	private ArrayList<Player> players;
	private Player currentPlayer;
	private Iterator<Player> iterator;
	private Console console;
	
	public GameUpdater(Map map, ArrayList<Player> players, Console console) {
		this.map = map;
		this.players = players;
		this.console = console;
		state = GameState.RUNNING;	
		
//		iterator = players.iterator();
//		nextPlayer();
		turn = new Distribution(players);
	}
	
	private void distribution() {
		
//		//automatic
//		ArrayList<Country> countries = new ArrayList<Country>(map.getCountries());
//		Collections.shuffle(countries);
//		Iterator<Country> countryIterator = countries.iterator();
//		int n = 42 / players.size();
//		for (Player player: players) {
//			for (int i = 0; i < n; i++)
//				player.conquer(countryIterator.next(), 1);
//		}	
//		if (countryIterator.hasNext())
//			for (Player player: players)
//				player.conquer(countryIterator.next(), 1);
		
		
			
	}

	private void nextPlayer() {
		if (!iterator.hasNext())
			iterator = players.iterator();
		currentPlayer = iterator.next();
	}
	
	public void pickCountry(Vector3 pick) {
		Country picked = map.pickCountry(pick.x, pick.y);
		if (picked != null) {
			Gdx.app.log("Picked", picked.getName() + "(" + pick.x + "," + pick.y + ") with " +
					picked.getUnits() + " units");
			console.log(picked.getName() + "(" + pick.x + "," + pick.y + ") with " +
					picked.getUnits() + " units");
			turn.onPick(picked);
			
//			switch (phase) {
//			case DISTRIBUTION:
//				distribution();
//				break;					
//			case REINFORCEMENT:
//				break;
//			case ATTACK_PHASE:
//				break;
//			case BATTLE_PHASE:
//				break;
//			case FORTIFYING:
//				break;
//			}
		}
		
		
	}

	public Map getMap() {
		return map;
	}

}
