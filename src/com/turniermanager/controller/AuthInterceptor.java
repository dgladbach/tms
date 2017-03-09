package com.turniermanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("leader") != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
	}
}
