package com.randomj.gameobjects;

public class Enums {  
	//Enumerabili: in poche parole, servono a dire FASE_1, FASE_2 ecc invece che usare dei numeri: 1, 2...
	//diventa tutto più leggibile, e sono utili per gli 'stati' di un gioco, o per indicare un 'tipo'
	//li ho fatti un po alla cazzo, molti nemmeno li uso, specialmente playerno che è un po' inutile

	public enum PlayerNo {
		PLAYER_1, PLAYER_2, PLAYER_3, PLAYER_4, PLAYER_5, PLAYER_6
	}
	
	public enum AIType {
		NOOB, NORMAL, EXPERT, NONE
	}
	
	public enum GameState {
		READY, RUNNING, PAUSE
	}
	
	public enum TurnPhase {
		DISTRIBUTION, REINFORCEMENT, ATTACK_PHASE, BATTLE_PHASE, FORTIFYING
	}
	
	public enum CardType {
		INFANTRY, CAVALRY, ARTILLERY, WILD_CARD 
	}

}
