package com.mydeenAbdul.league.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydeenAbdul.league.dao.Repository;
import com.mydeenAbdul.league.dto.Driver;
import com.mydeenAbdul.league.dto.Season;

@WebServlet("/team")
public class TeamServlet extends HttpServlet{

	private Repository repository = Repository.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Season season = new Driver().getSeason(repository.getByYear(2008));
		req.setAttribute("sesson", season);
		req.getRequestDispatcher("Team.jsp").forward(req, resp);
	}
}
