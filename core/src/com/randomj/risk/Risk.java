package com.randomj.risk;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.randomj.gameobjects.Enums.PlayerNo;
import com.randomj.gameobjects.Human;
import com.randomj.gameobjects.Player;
import com.randomj.helpers.AssetLoader;
import com.randomj.screens.GameScreen;

public class Risk extends Game { // superclasse Game di libgdx, si può vedere come il "main"

	@Override
	public void create() {
		AssetLoader.load(); // carica le risorse (vedi AssetLoader.java)
		
		ArrayList<Player> players = new ArrayList<Player>(); // Lista di giocatori, ne faccio 2 di prova
		players.add(new Human(PlayerNo.PLAYER_1, "Catalbertolasio", Color.GREEN));
		players.add(new Human(PlayerNo.PLAYER_2, "Gertrudelio", Color.RED));
		
		setScreen(new GameScreen(this, players)); // gli passo anche "this", ovvero questa classe (Risk)
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose(); // pulisce da tutte le risorse
	}

}
