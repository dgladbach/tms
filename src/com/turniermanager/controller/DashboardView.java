package com.turniermanager.controller;

import java.util.ArrayList;

import com.turniermanager.objekte.Team;
import com.turniermanager.objekte.Tournament;

public class DashboardView {
	private ArrayList<Tournament> tournaments;
	private ArrayList<Team> teams;

	public DashboardView(ArrayList<Tournament> tournaments, ArrayList<Team> teams) {
		this.setTournaments(tournaments);
		this.setTeams(teams);
	}

	public ArrayList<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(ArrayList<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
}
