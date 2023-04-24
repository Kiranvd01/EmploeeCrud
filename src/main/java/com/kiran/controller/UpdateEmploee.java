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
import com.kiran.emploeeDao.EmploeeDaoImpl;
import com.kiran.model.Emploee;
@WebServlet("/UpdateEmploee")
public class UpdateEmploee extends HttpServlet {
	EmploeeDao dao;
	@Override
	public void init() throws ServletException {
		dao=new EmploeeDaoFactory().getInstance();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		Emploee e=new Emploee();
		e.seteName(name);
		e.seteNo(id);
		e.seteSalary(salary);
		
		int i=dao.updateEmploee(e);
		if(i==1)
		{
			response.sendRedirect("jsp/DisplayAll.jsp");
		}
		else {
			out.print("<h3>Id Not Found</h3>");
		}
	}

}
