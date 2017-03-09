package com.turnieransicht.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.turniermanager.sql.DBConnector;

@Controller
public class TournamentViewController {
	@RequestMapping("/auth")
	public ModelAndView tournamentViewForm(HttpServletRequest request) {
		String accesscode = request.getParameter("code");
		return checkCode(accesscode, request);
		
	}

	@RequestMapping("/view/{code}")
	public ModelAndView tournamentViewUrl(HttpServletRequest request, @PathVariable("objectId") String accesscode) {
		return checkCode(accesscode, request);
	}

	private ModelAndView checkCode(String code, HttpServletRequest request) {
		DBConnector dbc = new DBConnector();
		Connection conn = dbc.getConnection();
		String tournamentId = null;
		if (conn != null) {
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT uuid FROM tournament WHERE accesscode=? LIMIT 1");
				ps.setString(1, code);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					tournamentId = rs.getString("uuid");
				}
				rs.close();
				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (tournamentId != null) {
			return prepareData(tournamentId);
		} else {
			return new ModelAndView("login", "view", "Der Code wurde nicht gefunden");
		}
	}
	
	private ModelAndView prepareData(String tournamentId){
		DBConnector dbc = new DBConnector();
		Connection conn = dbc.getConnection();
		
		if (conn != null) {
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM match WHERE tournament=?");
				ps.setString(1, tournamentId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					tournamentId = rs.getString("uuid");
				}
				rs.close();
				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return new ModelAndView("tournamentView", "view", tournamentId);
	}
}
