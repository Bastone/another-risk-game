package com.randomj.helpers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.randomj.gameobjects.GameUpdater;

public class MapInputHandler extends GestureHandler implements InputProcessor { 
	//gestisce l'input della mappa
	//grazie a GestureHandler prende anche i gesti

	private boolean holdMouse;
	private int startX, startY;
	private CameraHandler camHandler;
	private GameUpdater updater;

	public MapInputHandler(CameraHandler camHandler, GameUpdater updater) {
		this.camHandler = camHandler;
		this.updater = updater;
		holdMouse = false;
	}

	@Override
	public boolean keyDown(int keycode) {

		if (keycode == Keys.Z) {
			camHandler.zoomCamera();
			return true;
		}
		
		if (keycode == Keys.X) {
			camHandler.unZoomCamera();
			return true;
		}
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

	//ho dovuto fare dei casini per il trascinamento, ma fidatevi, funziona
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (!holdMouse) {
			holdMouse = true;
			updater.pickCountry(camHandler.pick(screenX, screenY));
			startX = screenX;
			startY = screenY;
			return true;
		}	
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (holdMouse) {
			holdMouse = false;
		}	
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if (holdMouse) {
			camHandler.translateCamera(startX - screenX, screenY - startY);
			startX = screenX;
			startY = screenY;
			return true;
		}		
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

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		
		camHandler.translateCamera(deltaX,deltaY);	
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
