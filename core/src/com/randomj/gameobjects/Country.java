package com.randomj.gameobjects;

import java.util.ArrayList;

public class Country {
	
	private String name;
	private Player owner;
	private ArrayList<Country> borders;
	private int units;
	private long pattern;
	private int color;
	private float x, y;

	public Country(String name, int color, int n) {
		this.name = name;
		this.color = color;	
		pattern = (long) Math.pow(2, n);
		
		reset();
	}
	
	public Country(String name, float x, float y, int color, int n) {
		this.name = name;
		this.color = color;	
		pattern = (long) Math.pow(2, n);
		this.x = x;
		this.y = y;
		
		reset();
	}
	
	public void reset() {
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
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public void setBorders(ArrayList<Country> borders) {
		this.borders = borders;
	}

	public ArrayList<Country> getBorders() {
		return borders;
	}
	
	public String toString() {
		return String.format("%-30s\t%-8s\t%42s", name, Integer.toHexString(color), Long.toBinaryString(pattern) );
	}

}
