package com.turnieransicht.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.turniermanager.sql.DBConnector;

@Controller
public class TournamentViewController {
	@RequestMapping("/auth")
	public ModelAndView tournamentViewForm(HttpServletRequest request){
		//DBConnector dbc= new DBConnector();
		String accesscode=request.getParameter("accesscode");
		return new ModelAndView("tournamentView","view",accesscode);
	}
	
	@RequestMapping("/view/{code}")
	public ModelAndView tournamentViewUrl(@PathVariable("objectId") String accesscode){
		
		return new ModelAndView("tournamentView","view",accesscode);
	}
}
