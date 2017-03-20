package com.turniermanager.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.turniermanager.objekte.Team;

public class TeamQueries {
	public Team getTeam(String uuid) {
		String sql = "SELECT * FROM team WHERE uuid=?";
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		Team team = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				team = new Team(rs.getString("uuid"), rs.getString("name"), rs.getString("picture"),
						rs.getString("description"), rs.getInt("status"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return team;
	}

	public boolean writeTeamToDB(Team team) {
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		String sql = "INSERT INTO team(uuid,name,picture,description,status) VALUES(?,?,?,?,?);";
		boolean done = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, team.getUUID());
			ps.setString(2, team.getName());
			ps.setString(3, team.getPicture());
			ps.setString(4, team.getDescription());
			ps.setInt(5, team.getStatus());
			ps.executeUpdate();
			ps.close();
			done = true;
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
		return done;
	}

	public boolean updateTeamInDB(Team team) {
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		String sql = "UPDATE team SET name=?,picture=?,description=?,status=?);";
		boolean done = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, team.getName());
			ps.setString(2, team.getPicture());
			ps.setString(3, team.getDescription());
			ps.setInt(4, team.getStatus());
			ps.executeUpdate();
			ps.close();
			done = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return done;
	}
}
