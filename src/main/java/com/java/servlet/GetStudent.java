package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.Student;
import com.java.dao.StudentDao;

@WebServlet("/GetStudent")
public class GetStudent extends HttpServlet{
	
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
	  
		int id=Integer.parseInt(httpServletRequest.getParameter("id"));
		Student student=StudentDao.getStudent(id);
		httpServletRequest.setAttribute("student",student);
		httpServletRequest.getRequestDispatcher("edit.jsp").forward(httpServletRequest, httpServletResponse);
	    
	}
}
