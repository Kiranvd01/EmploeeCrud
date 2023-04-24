package com.kiran.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kiran.emploeeDao.EmploeeDao;
import com.kiran.emploeeDao.EmploeeDaoFactory;
import com.kiran.model.Emploee;
@WebServlet("/UpdateRecordFetch")
public class UpdateRecordFetch extends HttpServlet {
	EmploeeDao dao;
	@Override
	public void init() throws ServletException {
		dao=EmploeeDaoFactory.getInstance();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		Emploee r= dao.readEmploee(id);
		request.setAttribute("emploee", r);
		request.getRequestDispatcher("jsp/Update.jsp").forward(request, response);
	}

}
