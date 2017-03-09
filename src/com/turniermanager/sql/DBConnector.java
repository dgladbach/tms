package com.turniermanager.sql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector {
	public DBConnector() {

	}

	public Connection getConnection() {
		try {
			InitialContext ic = new InitialContext();
			Context context = (Context) ic.lookup("java:comp/env");
			DataSource ds = (DataSource) context.lookup("jdbc/MySQLDB");
			Connection conn = ds.getConnection();
			return conn;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}
}
