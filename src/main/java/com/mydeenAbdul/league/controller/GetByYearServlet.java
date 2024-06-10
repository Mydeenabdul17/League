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

@WebServlet("/getByYear")
public class GetByYearServlet extends HttpServlet{

	private Repository repository = Repository.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String year = req.getParameter("year");
		Season sesson = new Driver().getSeason(repository.getByYear(Integer.parseInt(year)));
		req.setAttribute("sesson", sesson);
		req.getRequestDispatcher("Team.jsp").forward(req, resp);
	}

	
}
