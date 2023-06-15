package com.java.servlet;

import javax.servlet.http.HttpServlet;

import com.java.bean.Student;
import com.java.dao.StudentDao;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/addStudent")
public class AddStudent extends HttpServlet{

	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
	    
		String name=httpServletRequest.getParameter("name");
		String email=httpServletRequest.getParameter("email");
		String phoneNo=httpServletRequest.getParameter("phone_no");
		String dobString=httpServletRequest.getParameter("dob");
		String education=httpServletRequest.getParameter("education");
		
		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPhone_no(phoneNo);
		student.setDob(dobString);
		student.setEducation(education);
		
		int status=StudentDao.insert(student);
		
		if(status==1){
			String msg="Successfully Added";
			httpServletRequest.setAttribute("msg",msg);
			httpServletRequest.getRequestDispatcher("success.jsp").forward(httpServletRequest, httpServletResponse);
			httpServletResponse.sendRedirect("success.jsp");
		}
		else{
			httpServletResponse.sendRedirect("error.jsp");
		}
	}
}
