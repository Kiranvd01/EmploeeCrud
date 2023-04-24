package com.kiran.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.build.AllowSysOut;

import com.kiran.emploeeDao.EmploeeDao;
import com.kiran.emploeeDao.EmploeeDaoFactory;
import com.kiran.model.Emploee;
@WebServlet("/DeleteEmploee")
public class DeleteEmploee extends HttpServlet {
	EmploeeDao dao;
	@Override
	public void init() throws ServletException {
		dao=new EmploeeDaoFactory().getInstance();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Emploee e=new Emploee();
		e.seteNo(id);
		int i=dao.deleteEmloee(e);
		if(i==1)
		{
			response.sendRedirect("jsp/DisplayAll.jsp");
		}
		else {
			out.print("<h3>Error</h3>");
		}
	}

}
