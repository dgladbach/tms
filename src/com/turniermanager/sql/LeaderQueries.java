package com.turniermanager.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.turniermanager.objekte.Leader;
import com.turniermanager.objekte.Team;
import com.turniermanager.objekte.Tournament;

public class LeaderQueries {
	public Leader getLeader(String uuid) {
		String sql = "SELECT * FROM leader WHERE uuid=?";
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		Leader leader = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				leader = new Leader(uuid, rs.getString("name"), rs.getString("loginname"));
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
		return leader;
	}

	public boolean writeNewLeaderToDB(Leader leader, String password) {
		String sql = "INSERT INTO Leader(uuid,name,loginname,password) VALUES(?,?,?,?)";
		DBConnector dbc = new DBConnector();
		boolean done = false;
		if (dbc != null) {
			Connection con = dbc.getConnection();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, leader.getUUID());
				ps.setString(2, leader.getName());
				ps.setString(3, leader.getLoginname());
				ps.setString(4, password);
				ps.executeUpdate();
				done = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return done;
	}

	public ArrayList<Tournament> getTournamentsForLeader(String uuid) {
		DBConnector dbc = new DBConnector();
		ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
		if (dbc != null) {
			Connection con = dbc.getConnection();
			String sql = "SELECT * FROM tournament t JOIN leader l ON t.owner=l.uuid WHERE t.owner=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, uuid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					tournaments.add(new Tournament(rs.getString("t.uuid"), rs.getString("t.name"),
							new Leader(uuid, rs.getString("l.name"), rs.getString("loginname")),
							rs.getString("t.comment"), rs.getString("t.accesscode"), rs.getInt("t.status"),
							rs.getTimestamp("t.cdate")));
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
		}
		return tournaments;
	}

	public ArrayList<Team> getTeamsForLeader(String uuid) {
		DBConnector dbc = new DBConnector();
		ArrayList<Team> teams = new ArrayList<Team>();
		if (dbc != null) {
			Connection con = dbc.getConnection();
			String sql = "SELECT * FROM team t WHERE t.owner=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, uuid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					teams.add(new Team(uuid, rs.getString("t.name"), rs.getString("t.picture"),
							rs.getString("t.description")));
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
		}
		return teams;
	}
}
