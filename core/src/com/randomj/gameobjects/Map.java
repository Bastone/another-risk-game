package com.randomj.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.randomj.helpers.AssetLoader;

public class Map {

	private ArrayList<Country> countries;
	private ArrayList<Continent> continents;
	private Pixmap mapColors;
	private Sprite mapSprite;
	private int width, height;

	public Map() {		
		Texture mapTexture = AssetLoader.map;
		width = mapTexture.getWidth();
		height = mapTexture.getHeight();
		
		mapSprite = new Sprite(mapTexture);
		mapColors = AssetLoader.mapColors;
		
		init();
	}
	
	public void init() {

		countries = new ArrayList<Country>();
		continents = new ArrayList<Continent>();
		
		//NORTH AMERICA
		countries.add(new Country("Alaska", 78, 555, 0x808014ff, countries.size()));
		countries.add(new Country("Alberta", 0xffff00ff, countries.size()));
		countries.add(new Country("Central America",0xffff64ff, countries.size()));
		countries.add(new Country("Eastern United States", 0x808000ff, countries.size()));
		countries.add(new Country("Greenland", 0xffff14ff, countries.size()));
		countries.add(new Country("Northwest Territory", 0x50642dff, countries.size()));
		countries.add(new Country("Ontario", 0x949449ff, countries.size()));
		countries.add(new Country("Quebec", 0xffff80ff, countries.size()));		
		countries.add(new Country("Western United States", 0x50502dff, countries.size()));
		
		//AFRICA
		countries.add(new Country("Argentina", 0xff0000ff, countries.size()));
		countries.add(new Country("Brazil", 0x804040ff, countries.size()));
		countries.add(new Country("Peru", 0x800000ff, countries.size()));
		countries.add(new Country("Venezuela", 0xff8080ff, countries.size()));
		
		//EUROPE
		countries.add(new Country("Great Britain", 0x4080ff, countries.size()));
		countries.add(new Country("Iceland", 0x14ffff, countries.size()));
		countries.add(new Country("Northern Europe", 0xffff, countries.size()));
		countries.add(new Country("Scandinavia", 0x1480ffff, countries.size()));
		countries.add(new Country("Southern Europe", 0x144080ff, countries.size()));
		countries.add(new Country("Ukraine", 0x80ff, countries.size()));
		countries.add(new Country("Western Europe", 0x80ffff, countries.size()));
		
		//AFRICA
		countries.add(new Country("Congo", 0xae5714ff, countries.size()));
		countries.add(new Country("East Africa", 0xff8000ff, countries.size()));
		countries.add(new Country("Egypt", 0x804014ff, countries.size()));
		countries.add(new Country("Madagascar", 0xae5700ff, countries.size()));
		countries.add(new Country("North Africa", 0xff915bff, countries.size()));
		countries.add(new Country("South Africa", 0x804000ff, countries.size()));
		
		//ASIA
		countries.add(new Country("Afghanistan", 0x80ff64ff, countries.size()));
		countries.add(new Country("China", 0x148040ff, countries.size()));
		countries.add(new Country("India", 0x8080ff, countries.size()));
		countries.add(new Country("Irkutsk", 0x80ff14ff, countries.size()));
		countries.add(new Country("Japan", 0x80ff00ff, countries.size()));
		countries.add(new Country("Kamchatka", 0x8040ff, countries.size()));
		countries.add(new Country("Middle East", 0x148000ff, countries.size()));
		countries.add(new Country("Mongolia", 0x4014ff, countries.size()));
		countries.add(new Country("Siam", 0x80ff80ff, countries.size()));
		countries.add(new Country("Siberia", 0x8000ff, countries.size()));
		countries.add(new Country("Ural", 0x4000ff, countries.size()));
		countries.add(new Country("Yakutsk", 0x148080ff, countries.size()));
		
		//AUSTRALIA
		countries.add(new Country("Eastern Australia", 0x400040ff, countries.size()));
		countries.add(new Country("Indonesia", 0x8000ffff, countries.size()));
		countries.add(new Country("New Guinea", 0xff00ffff, countries.size()));
		countries.add(new Country("Western Australia", 0x800040ff, countries.size()));
		
		//CONTINENTS
		long pattern = 0;
		int i = 0;
		for (;i < 9; i++) {
			pattern = pattern | countries.get(i).getPattern();
		}
		continents.add(new Continent("North America", 5, pattern));
		
		pattern = 0;
		for (;i < 13; i++)
			pattern = pattern | countries.get(i).getPattern();
		continents.add(new Continent("South America", 2, pattern));
		
		pattern = 0;
		for (; i < 20; i++)
			pattern = pattern | countries.get(i).getPattern();
		continents.add(new Continent("Africa", 3, pattern));
		
		pattern = 0;
		for (; i < 26; i++)
			pattern = pattern | countries.get(i).getPattern();
		continents.add(new Continent("Europe", 5, pattern));
		
		pattern = 0;
		for (; i < 38; i++)
			pattern = pattern | countries.get(i).getPattern();
		continents.add(new Continent("Asia", 7, pattern));
		
		pattern = 0;
		for (; i < 42; i++)
			pattern = pattern | countries.get(i).getPattern();
		continents.add(new Continent("Australia", 2, pattern));
		
	}
	
	public void reset() {
		for (Country country: countries)
			country.reset();		
	}

	public Country pickCountry(float x, float y) {		
		
		int color = mapColors.getPixel((int)x, (int)y);		
		if (color != 0xffffffff) {
			for (Country country: countries) {
				if (country.getColor() == color) {
					return country;
				}				
			}	
		}
		return null;
	}

	public void draw (SpriteBatch batch) {
		mapSprite.draw(batch);	
	}
	
	public void drawCircle (ShapeRenderer shape) {
//		Country alaska = countries.get(0);
//		shape.setColor(alaska.getOwner().getColor());
//		shape.circle(alaska.getX(), alaska.getY(), 15);	
	}
	
	public void drawNoUnits(SpriteBatch batch, BitmapFont font) {
		Country alaska = countries.get(0);
		font.draw(batch, alaska.getUnits() + "", alaska.getX() - font.getSpaceWidth() / 2,
				alaska.getY() + font.getCapHeight() / 2);
	}

	public	ArrayList<Continent> getContinents() {
		return continents;
	}
	
	public ArrayList<Country> getCountries() {
		return countries;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
