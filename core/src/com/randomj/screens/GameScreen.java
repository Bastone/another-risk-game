package com.randomj.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.randomj.gameobjects.Bulga;
import com.randomj.gameobjects.Console;
import com.randomj.gameobjects.Country;
import com.randomj.gameobjects.GameUpdater;
import com.randomj.gameobjects.Map;
import com.randomj.helpers.AssetLoader;
import com.randomj.helpers.MapInputHandler;
import com.randomj.helpers.UIInputHandler;
import com.randomj.ui.Button;

public class GameScreen implements Screen {

	private float gameWidth, gameHeight, screenWidth, screenHeight;
	private OrthographicCamera mapCamera, HUDCamera;
	private Map map;
	private Button button;
	private GameUpdater updater;
	private Console console;
	private SpriteBatch mapBatch, HUDBatch;
	private BitmapFont font;
	
	//--------------
	private Bulga bulga;
	private Button dropBulga;
	private float timelapse = 0;
	private boolean dropTheBulgarang;
	//------------
	
	public GameScreen() {
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();	
		
		font = new BitmapFont();
		
		map = new Map();
		gameWidth = map.getWidth();
		gameHeight = map.getHeight();
		
		mapCamera = new OrthographicCamera();
		mapCamera.setToOrtho(false, gameWidth, gameHeight);
		
		HUDCamera = new OrthographicCamera();
		HUDCamera.setToOrtho(false, screenWidth, screenHeight);
		
		mapBatch = new SpriteBatch();		
		HUDBatch = new SpriteBatch();
		HUDBatch.setProjectionMatrix(HUDCamera.combined);
		
		updater = new GameUpdater(map);
		
		console = new Console(AssetLoader.console, font, screenWidth);
		button = new Button(AssetLoader.button, font, console.getX() + console.getWidth() + 20, 20,
				screenWidth - (console.getX() + console.getWidth()) - 40, console.getHeight() - 40);
		
		//-------------------------------------------------------------------------------------------
		bulga = new Bulga(AssetLoader.bulga, screenHeight, screenWidth);
		dropBulga = new Button(AssetLoader.bulga, null, screenWidth - 50, screenHeight - 80, 50, 80);
		dropTheBulgarang = false;
		//-------------------------------------------------------------------------------------------
		
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(new UIInputHandler(this, dropBulga));
		multiplexer.addProcessor(new MapInputHandler(this));
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void render(float delta) {
		
		mapBatch.setProjectionMatrix(mapCamera.combined);
		
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
	    mapBatch.begin();    
	    map.draw(mapBatch);	    
	    mapBatch.end();
	    
	    HUDBatch.begin();

	    // It's raining Bulga, halleluja ------------------------------------------------------------   
	    dropBulga.draw(HUDBatch);
	    if (dropTheBulgarang) {
	    	beginApocalypse(delta);
	    }
	    //-------------------------------------------------------------------------------------------
	    
	    
	    console.draw(HUDBatch);
	    button.draw(HUDBatch);
	    
	    HUDBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	    
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		
	}
	
	public void checkCameraBorders() {
		mapCamera.zoom = MathUtils.clamp(mapCamera.zoom, 0.5f, gameWidth / mapCamera.viewportWidth);
		
		float effectiveViewportWidth = mapCamera.viewportWidth * mapCamera.zoom;
		float effectiveViewportHeight = mapCamera.viewportHeight * mapCamera.zoom;

		mapCamera.position.x = MathUtils.clamp(mapCamera.position.x, effectiveViewportWidth / 2f, gameWidth - effectiveViewportWidth / 2f);
		mapCamera.position.y = MathUtils.clamp(mapCamera.position.y, effectiveViewportHeight / 2f, gameHeight - effectiveViewportHeight / 2f);
	}
	
	public void pickCountry(float x, float y) {
		Vector3 pick = mapCamera.getPickRay(x, y).origin;
		console.log(pick.x + " " + pick.y);
		Country picked = map.pickCountry(pick.x, gameHeight - pick.y);
		if (picked != null)
			console.log(picked.getName());
	}
	
	public void translateCamera(float deltaX, float deltaY) {
		mapCamera.translate(deltaX, deltaY);
		checkCameraBorders();
		mapCamera.update();
	}

	public void zoomCamera() {
		mapCamera.zoom -= 0.1f;
		checkCameraBorders();
		mapCamera.update();
	}
	
	public void unZoomCamera() {
		mapCamera.zoom += 0.1f;
		checkCameraBorders();
		mapCamera.update();
	}
	
	public void beginApocalypse(float delta) {
    	timelapse += delta;
    	if (timelapse > 1) {
    		timelapse = 0;
    		bulga.spawn();
    		String str;
    		switch (MathUtils.random(0, 3)) {
    		case 0:
    			str = "SWAG";
    			break;
    		case 1:
    			str = "WUB WUB WUB";
    			break;
    		case 2:
    			str = "WEED";
    			break;
    		default:
    			str = "BULGARANG";
    			break;
    		}
    		console.log(str);
    	}
    	bulga.drop();
    	bulga.draw(HUDBatch);
	}
	
	public void dropTheBulgarang() {
		if (dropTheBulgarang)
			dropTheBulgarang = false;
		else {
			dropTheBulgarang = true;
			console.log("HE'S COMING");
		}
	}
	
	public Map getMap() {
		return map;
	}

	public Console getConsole() {
		return console;
	}
	
	public float getScreenWidth() {
		return screenWidth;
	}

	public float getScreenHeight() {
		return screenHeight;
	}
}
