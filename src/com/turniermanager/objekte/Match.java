package com.turniermanager.objekte;

import java.sql.Timestamp;

public class Match {

	private String uuid;
	private int scoreTeam1;
	private int scoreTeam2;
	private Team team1;
	private Team team2;
	private Team winner;
	private Tournament tournament;
	private Timestamp enddate;
	private int round;

	/**
	 * Create a match object with values from db
	 * 
	 * @param uuid
	 * @param scoreTeam1
	 * @param scoreTeam2
	 * @param team1
	 * @param team2
	 * @param winner
	 * @param tournament
	 * @param enddate
	 * @param round
	 */
	public Match(String uuid, int scoreTeam1, int scoreTeam2, Team team1, Team team2, Team winner,
			Tournament tournament, Timestamp enddate, int round) {
		this.uuid = uuid;
		this.scoreTeam1 = scoreTeam1;
		this.scoreTeam2 = scoreTeam2;
		this.team1 = team1;
		this.team2 = team2;
		this.winner = winner;
		this.tournament = tournament;
		this.enddate = enddate;
		this.round = round;
	}

	/**
	 * Create a new match object
	 * 
	 * @param uuid
	 * @param team1
	 * @param team2
	 * @param tournament
	 * @param round
	 */
	public Match(String uuid, Team team1, Team team2, Tournament tournament, int round) {
		this.uuid = uuid;
		this.team1 = team1;
		this.team2 = team2;
		this.tournament = tournament;
		this.round = round;
	}

	/**
	 * Set the score of this match and the winner
	 * 
	 * @param scoreTeam1
	 * @param scoreTeam2
	 */
	public void setScore(int scoreTeam1, int scoreTeam2) {
		this.scoreTeam1 = scoreTeam1;
		this.scoreTeam2 = scoreTeam2;
		if (scoreTeam1 > scoreTeam2) {
			this.winner = this.team1;
		} else if (scoreTeam2 > scoreTeam1) {
			this.winner = this.team2;
		}
	}

	public String getUuid() {
		return uuid;
	}

	public int getScoreTeam1() {
		return scoreTeam1;
	}

	public int getScoreTeam2() {
		return scoreTeam2;
	}

	public Team getWinner() {
		return winner;
	}

	public Timestamp getEnddate() {
		return enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public int getRound() {
		return round;
	}

}
