
package com.sample15;

import java.util.ArrayList;

public class CharacterState {
	private Character state;
	private ArrayList<Character> playerStateList = new ArrayList<>();

	public ArrayList<Character> getPlayerStateList() {
		return playerStateList;
	}

	public void setState(Character state) {
		this.state = state;
		switch (state) {
		case WEREWOLF:
			playerStateList.add(this.state);
			break;
		case PROPHET:
			playerStateList.add(this.state);
			break;
		case WITCH:
			playerStateList.add(this.state);
			break;
		case HUNTER:
			playerStateList.add(this.state);
			break;
		case PEOPLE:
			playerStateList.add(this.state);
			break;
		}
	} // public void setState

	public void clearPlayerStateList() {
		playerStateList.clear();
	}
} // public class CharacterState
