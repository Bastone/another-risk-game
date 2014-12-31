package com.randomj.risk;

import com.badlogic.gdx.Game;
import com.randomj.helpers.AssetLoader;
import com.randomj.screens.GameScreen;
import com.randomj.screens.Prova;

public class Risk extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}
