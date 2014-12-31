package com.randomj.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {

	public static Texture map, button, console, bulga;
	public static Pixmap mapColors;
	
	public static void load() {
		map = new Texture(Gdx.files.internal("map.png"));
		map.getTextureData().prepare();
		mapColors = map.getTextureData().consumePixmap();
		
		button = new Texture(Gdx.files.internal("button.png"));
		console = new Texture(Gdx.files.internal("console.png"));
		bulga = new Texture(Gdx.files.internal("bulga.png"));
	}
	
	public static void dispose() {
		map.dispose();	
		button.dispose();
		console.dispose();
		bulga.dispose();
	}

}
