package com.randomj.risk;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.randomj.gameobjects.Enums.PlayerNo;
import com.randomj.gameobjects.Human;
import com.randomj.gameobjects.Player;
import com.randomj.helpers.AssetLoader;
import com.randomj.screens.GameScreen;

public class Risk extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Human(PlayerNo.PLAYER_1, "Catalbertolasio", Color.GREEN));
		players.add(new Human(PlayerNo.PLAYER_2, "Gertrudelio", Color.RED));
		setScreen(new GameScreen(players));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}
