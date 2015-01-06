package com.randomj.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.randomj.gameobjects.Bulga;
import com.randomj.gameobjects.Country;
import com.randomj.gameobjects.GameUpdater;
import com.randomj.gameobjects.Map;
import com.randomj.gameobjects.Player;
import com.randomj.helpers.AssetLoader;
import com.randomj.helpers.CameraHandler;
import com.randomj.helpers.MapInputHandler;
import com.randomj.helpers.UIInputHandler;
import com.randomj.risk.Risk;
import com.randomj.ui.Button;
import com.randomj.ui.Console;

public class GameScreen implements Screen { // da libgdx, rappresenta una schermata

	private float gameWidth, gameHeight, screenWidth, screenHeight;
	private Risk risk;
	private OrthographicCamera mapCamera, HUDCamera;
	private Map map;
	private Button button;
	private GameUpdater updater;
	private CameraHandler camHandler;
	private Console console;
	private SpriteBatch mapBatch, HUDBatch;
	private ShapeRenderer shape;
	private BitmapFont font;
	private ArrayList<Player> players;
	
	//--------------
	private Bulga bulga;
	private Button dropBulga;
	private float timelapse = 0;
	private boolean dropTheBulgarang;
	//------------
	
	public GameScreen(Risk risk, ArrayList<Player> players) {
		
		this.risk = risk; // se vorrò cambiare schermata, mi servirà risk.setScreen()
		this.players = players;
		
		screenWidth = Gdx.graphics.getWidth();  // dimensioni dello schermo (reali)
		screenHeight = Gdx.graphics.getHeight();	
		
		map = new Map(); // vedi Map.java
		gameWidth = map.getWidth();  // dimensioni dello schermo (virtuali), le imposto come le dimensioni dell'immagine della mappa
		gameHeight = map.getHeight();
		
		font = new BitmapFont(); // per scrivere
		
		mapCamera = new OrthographicCamera(); // da libgdx, non è altro che una 'telecamera' o 'visuale'
		mapCamera.setToOrtho(false, gameWidth, gameHeight); // questa 'telecamera' ora ragiona con le coordinate virtuali, non quelle reali (e con la y verso l'alto - origine in basso a sinistra)
		camHandler = new CameraHandler(mapCamera, gameWidth, gameHeight); // vedi CameraHandler.java
		
		HUDCamera = new OrthographicCamera(); // questa servirà per disegnare l'interfaccia utente, che è 'fissa' (y sempre in alto)
		HUDCamera.setToOrtho(false, screenWidth, screenHeight); // vanno bene le coordinate dello schermo reale
		
		mapBatch = new SpriteBatch();	// da libgdx, servono per disegnare gli sprite (o texture - le immagini)
		HUDBatch = new SpriteBatch();	
		mapBatch.setProjectionMatrix(mapCamera.combined); //Ognuno disegna seguendo la propria 'telecamera'
		HUDBatch.setProjectionMatrix(HUDCamera.combined);
		
		shape = new ShapeRenderer();	// da libgdx, per disegnare delle forme geometriche
		shape.setProjectionMatrix(mapCamera.combined);
		
		console = new Console(AssetLoader.console, font, screenWidth); // vedi Console.java
		updater = new GameUpdater(map, players, console); // vedi GameUpdater.java
			
		button = new Button(AssetLoader.button, font, console.getX() + console.getWidth() + 20, 20,
				screenWidth - (console.getX() + console.getWidth()) - 40, console.getHeight() - 40);
		// vedi Button.java
		
		//-------------------------------------------------------------------------------------------
		bulga = new Bulga(AssetLoader.bulga, screenHeight, screenWidth);
		dropBulga = new Button(AssetLoader.bulga, null, screenWidth - 50, screenHeight - 80, 50, 80);
		dropTheBulgarang = false;
		//-------------------------------------------------------------------------------------------
		
		InputMultiplexer multiplexer = new InputMultiplexer(); // da libgdx, serve a dividere e dare priorità all'input:
		multiplexer.addProcessor(new UIInputHandler(this, dropBulga)); // prima l'interfaccia utente (vedi UIInputHandler.java)
		multiplexer.addProcessor(new MapInputHandler(camHandler, updater)); // poi la mappa (vedi MapInputHandler.java)
		Gdx.input.setInputProcessor(multiplexer); 
	}

	//questa funzione si attiva ad ogni fotogramma, e delta sono i secondi passati dall'ultimo fotogramma: infatti  1/delta = FPS! magimagia!	
	//notare che ho fatto in modo che ogni oggetto si 'disegni da solo' passandogli il batch
	@Override
	public void render(float delta) {
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //pulisce lo schermo
		
		mapBatch.setProjectionMatrix(mapCamera.combined); //la telecamera della mappa potrebbe cambiare, quindi aggiorno il batch
	    
		//disegno la mappa
	    mapBatch.begin(); 
	    map.draw(mapBatch);	    
	    mapBatch.end();
	    
//	    shape.setProjectionMatrix(mapCamera.combined);
//	    shape.begin(ShapeType.Filled);
//	    map.drawCircle(shape);
//	    shape.end(); 
//	    
//	    mapBatch.begin();
//	    map.drawNoUnits(mapBatch, font);	    
//	    mapBatch.end();
	    
	    
	    //disegno l' HUD a schermo
	    HUDBatch.begin();

	    // Bulga button ----------------------------------------------------------------------------- 
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
	
	//----------------------------------------------
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
	
	//-----------------------------------------------
	
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
