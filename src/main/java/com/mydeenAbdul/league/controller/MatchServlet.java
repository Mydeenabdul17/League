package com.mydeenAbdul.league.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydeenAbdul.league.dao.Repository;
import com.mydeenAbdul.league.dto.Driver;
import com.mydeenAbdul.league.dto.Match;

@WebServlet("/match")
public class MatchServlet extends HttpServlet{

	private Repository repository = Repository.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Match> matches = new Driver().getMatches(repository.getDeliveriesLast());
		req.setAttribute("matches", matches);
//		req.getRequestDispatcher("App.jsp").forward(req, resp);
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}

	
}
