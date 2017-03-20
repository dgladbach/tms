package com.turniermanager.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.turniermanager.objekte.Leader;
import com.turniermanager.objekte.Team;
import com.turniermanager.objekte.Tournament;

public class TournamentQueries {

	/**
	 * Loads a Tournament without teamList from the db
	 * 
	 * @param uuid
	 * @return Tournament
	 */
	public Tournament getTournament(String uuid) {
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		String sql = "SELECT * FROM tournament t JOIN leader l ON t.owner=l.uuid WHERE uuid=? ";
		Tournament tournament = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Leader leader = new Leader(rs.getString("l.uuid"), rs.getString("l.name"), rs.getString("l.loginname"));
				tournament = new Tournament(uuid, rs.getString("t.name"), leader, rs.getString("t.comment"),
						rs.getString("t.accesscode"), rs.getInt("t.status"), rs.getTimestamp("t.cdate"));

			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tournament;

	}

	/**
	 * Loads a tournament with teamList from the db
	 * 
	 * @param uuid
	 * @return Tournament
	 */
	public Tournament getTournamentWithTeamList(String uuid) {
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		String sql2 = "SELECT * FROM tournament t JOIN leader l ON t.owner=l.uuid WHERE t.uuid=?";
		String sql1 = "SELECT * FROM participants p JOIN team t ON p.team=t.uuid WHERE p.tournament=?";
		Tournament tournament = null;
		try {
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setString(1,uuid);
			ResultSet rs1=ps1.executeQuery();
			ArrayList<Team> teamList = new ArrayList<Team>();
			while(rs1.next()){
				teamList.add(new Team(rs1.getString("t.uuid"), rs1.getString("t.name"), rs1.getString("t.picture"),
						rs1.getString("t.description"), rs1.getInt("status")));
			}
			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			Leader leader = new Leader(rs.getString("l.uuid"), rs.getString("l.name"), rs.getString("l.loginname"));
			tournament = new Tournament(uuid, rs.getString("t.name"), leader, rs.getString("t.comment"),
					rs.getString("t.accesscode"), rs.getInt("t.status"), rs.getTimestamp("t.cdate"), teamList);

			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tournament;
	}



}
