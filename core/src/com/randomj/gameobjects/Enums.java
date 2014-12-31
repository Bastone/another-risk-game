package com.randomj.gameobjects;

public class Enums {

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
		CARD_TRADING, ARMIES_PLACING, ATTACK_PHASE, BATTLE_PHASE, FORTIFYING
	}

}
