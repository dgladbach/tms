package com.turnieransicht.view;

import com.turniermanager.objekte.Team;

public class TeamPunkteView extends Team {
	
	private int matchesWon = 0;
	private int matchesLost = 0;
	private int score = 0;
	private int position = 0;
	

	public TeamPunkteView(String uuid, String name, String picture, String description) {
		super(uuid, name, picture, description);
	}
	
	public TeamPunkteView(String uuid, String name, String picture, String description, int status) {
		super(uuid, name, picture, description, status);
	}

	public int getMatchesWon() {
		return matchesWon;
	}

	public void setMatchesWon(int matchesWon) {
		this.matchesWon = matchesWon;
	}

	public int getMatchesLost() {
		return matchesLost;
	}

	public void setMatchesLost(int matchesLost) {
		this.matchesLost = matchesLost;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}

	public void addMatchesWon(int matchesWon) {
		this.matchesWon += matchesWon;
	}
	

	public void addMatchesLost(int matchesLost) {
		this.matchesLost += matchesLost;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
