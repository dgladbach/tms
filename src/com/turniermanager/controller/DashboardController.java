package com.turniermanager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard")
	public static ModelAndView dashboard(HttpServletRequest request){
		return new ModelAndView("leaderDashboard","username",request.getSession().getAttribute("username"));
	}
}
