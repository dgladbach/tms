package com.turnieransicht.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.turnieransicht.view.TeamPunkteView;
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
		Map<String, TeamPunkteView> teams = new HashMap<String, TeamPunkteView>();
		
		if (conn != null) {
			try {
				PreparedStatement ps1 = conn.prepareStatement("SELECT t.uuid, t.name, t.picture, t.description, t.status "
						+ "FROM participants p "
						+ "LEFT JOIN team t ON p.team = t.uuid "
						+ "WHERE p.tournament=?");
				ps1.setString(1, tournamentId);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					teams.put(rs1.getString("uuid"), 
							new TeamPunkteView(rs1.getString("uuid"), 
									rs1.getString("name"), 
									rs1.getString("picture"), 
									rs1.getString("description"), 
									rs1.getInt("status")
							)
					);
				}
				rs1.close();
				ps1.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM `match` WHERE tournament=?");
				ps.setString(1, tournamentId);
				ResultSet rs = ps.executeQuery();
				TeamPunkteView t1;
				TeamPunkteView t2;
				while(rs.next()) {
					t1 = teams.get(rs.getString("team1"));
					t2 = teams.get(rs.getString("team2"));
					if(rs.getString("winner").equals(rs.getString("team1"))){
						t1.addMatchesWon(1);
						t2.addMatchesLost(1);
					}else{
						t2.addMatchesWon(1);
						t1.addMatchesLost(1);
					}
					t1.addScore(rs.getInt("scoreteam1"));
					t2.addScore(rs.getInt("scoreteam2"));

				}
				rs.close();
				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Hashmap teams wird zur sortierten LinkedList list
		List<TeamPunkteView> list = new LinkedList<TeamPunkteView>(teams.values());
	    Collections.sort( list, new Comparator<TeamPunkteView>()
	    {
	        @Override
	        public int compare( TeamPunkteView o1, TeamPunkteView o2 )
	        {
	            return Integer.compare(o1.getScore(), o2.getScore())*(-1);
	        }
	    } );
	    
	    // Platzierung ausrechnen
	    int position = 0;
	    int lastScore = Integer.MAX_VALUE;
	    for(TeamPunkteView t:list){
	    	if(t.getScore() != lastScore){
	    		position++;
	    	}
	    	t.setPosition(position);
	    	lastScore = t.getScore();
	    }
	    

		
		return new ModelAndView("tournamentView", "teams", list);
	}
}
