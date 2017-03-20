package com.turniermanager.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.turniermanager.objekte.Leader;
import com.turniermanager.objekte.Team;
import com.turniermanager.objekte.Tournament;
import com.turniermanager.sql.LeaderQueries;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard")
	public static ModelAndView dashboard(HttpServletRequest request) {
		Leader leader = (Leader) request.getSession().getAttribute("leader");
		LeaderQueries lq = new LeaderQueries();
		ArrayList<Tournament> tournaments = lq.getTournamentsForLeader(leader.getUUID());
		ArrayList<Team> teams = lq.getTeamsForLeader(leader.getUUID());

		return new ModelAndView("leaderDashboard", "view", new DashboardView(tournaments, teams));
	}
}
