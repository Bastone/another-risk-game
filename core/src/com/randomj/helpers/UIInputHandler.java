package com.randomj.helpers;

import com.badlogic.gdx.InputProcessor;
import com.randomj.screens.GameScreen;
import com.randomj.ui.Button;

public class UIInputHandler implements InputProcessor { 
	//gestisce l'input dell'interfaccia utente, che per ora è solo... bulga
	
	private GameScreen game;
	private Button dropBulga;
	
	public UIInputHandler(GameScreen game, Button dropBulga) {
		this.game = game;
		this.dropBulga = dropBulga;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (dropBulga.isTouchDown(screenX, game.getScreenHeight() - screenY)) {	
			game.dropTheBulgarang();
			return true;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
