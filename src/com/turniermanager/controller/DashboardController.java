package com.turniermanager.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.turniermanager.objekte.Leader;
import com.turniermanager.objekte.Tournament;
import com.turniermanager.sql.DBConnector;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard")
	public static ModelAndView dashboard(HttpServletRequest request) {
		Leader leader = (Leader) request.getSession().getAttribute("leader");
		DBConnector dbc = new DBConnector();
		Connection conn = dbc.getConnection();
		List<Tournament> tournamentList = new ArrayList<Tournament>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tournament WHERE owner=?");
			ps.setString(1, leader.getUUID());
			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("leaderDashboard", "username", leader.getName());
	}
}
