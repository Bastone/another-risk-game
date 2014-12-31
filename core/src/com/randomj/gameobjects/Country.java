package com.randomj.gameobjects;

import com.badlogic.gdx.utils.Array;

public class Country {
	
	private String name;
	private Player owner;
	private Array<Country> borders;
	private int units;
	private long pattern;
	private int color;
	
	public Country(String name, int color, int n) {
		this.name = name;
		this.color = color;
		
		pattern = (long) Math.pow(2, n);
		units = 0;
		owner = null;
	}
	
	public void addUnits(int n) {
		units += n;
	}
	
	public boolean isFree() {
		return (owner == null);
	}
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public int getUnits() {
		return units;
	}
	
	public long getPattern() {
		return pattern;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setBorders(Array<Country> borders) {
		this.borders = borders;
	}

	public Array<Country> getBorders() {
		return borders;
	}
	
	public String toString() {
		return String.format("%-30s\t%-8s\t%42s", name, Integer.toHexString(color), Long.toBinaryString(pattern) );
	}

}
