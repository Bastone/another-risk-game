package com.randomj.gameobjects;

import java.util.ArrayList;

import com.randomj.gameobjects.Enums.CardType;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck(ArrayList<Country> countries) {
		cards = new ArrayList<Card>();
		cards.add(new Card(countries.get(9), CardType.INFANTRY, null));
		//esempio con l'argentina, l'ultimo metti null finchè non abbiamo le immagini...
	}

}
