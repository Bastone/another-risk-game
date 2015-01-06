package com.randomj.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader { // Questa classe contiene tutte le risorse del gioco (immagini e audio)

	public static Texture map, button, console, bulga; 
	public static Pixmap mapColors; // questa serve per prendere il colore dalla mappa
	
	public static void load() {
		map = new Texture(Gdx.files.internal("map.png"));
		
		map.getTextureData().prepare(); //fidatevi
		mapColors = map.getTextureData().consumePixmap();
		
		button = new Texture(Gdx.files.internal("button.png"));
		console = new Texture(Gdx.files.internal("console.png"));
		bulga = new Texture(Gdx.files.internal("bulga.png"));
	}
	
	public static void dispose() { //butta via la roba
		map.dispose();	
		button.dispose();
		console.dispose();
		bulga.dispose();
	}

}
