package com.login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.turniermanager.sql.DBConnector;

@Controller
public class LoginController {
	@RequestMapping("/*")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse resp) {
		String username = request.getParameter("username");

		if ((username != null && loginUser(request)) || request.getSession().getAttribute("username") != null) {
			try {
				resp.sendRedirect(request.getContextPath() + "/l/dashboard");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ModelAndView("leaderDashboard", "username", request.getSession().getAttribute("username"));

		} else {
			return new ModelAndView("login");
		}
		/*
		 * DBConnector dbc = new DBConnector(); Connection
		 * conn=dbc.getConnection(); if(conn!=null){ try { PreparedStatement ps
		 * = conn.prepareStatement("SELECT * FROM test"); ResultSet
		 * rs=ps.executeQuery(); if(rs.next()){ text=rs.getString("text"); }
		 * rs.close(); ps.close();
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }finally { try { conn.close(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } }
		 */

	}

	private boolean loginUser(HttpServletRequest request) {
		DBConnector dbc = new DBConnector();
		Connection conn = dbc.getConnection();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean access = false;
		if (conn != null) {
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT password FROM leader WHERE loginname=?");
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next() && BCrypt.checkpw(password, rs.getString("password"))) {
					// TODO Nutzer in der Session einloggen
					request.getSession().setAttribute("username", username);
					access = true;
				}
				rs.close();
				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return access;
	}
}
