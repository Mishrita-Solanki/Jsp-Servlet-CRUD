package com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.Student;
import com.java.dao.StudentDao;

@WebServlet("/viewStudents")
public class ViewStudents extends HttpServlet{
	
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException,IOException {
		
		List<Student> students=StudentDao.viewStudents();
		System.out.println(students);
		httpServletRequest.setAttribute("studentList", students);
		httpServletRequest.getRequestDispatcher("view-students.jsp").forward(httpServletRequest, httpServletResponse); 
	}
}
