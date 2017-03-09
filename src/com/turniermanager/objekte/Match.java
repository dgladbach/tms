package com.turniermanager.objekte;

import java.sql.Timestamp;

public class Match {

	private String uuid;
	private int scoreTeam1;
	private int scoreTeam2;
	private String team1;
	private String team2;
	private String winner;
	private String tournament;
	private Timestamp enddate;
	private int round;

	public Match(String uuid, int scoreTeam1, int scoreTeam2, String team1, String team2, String winner,
			String tournament, Timestamp enddate, int round) {
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
}
