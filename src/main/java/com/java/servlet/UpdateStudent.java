package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.Student;
import com.java.dao.StudentDao;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet{
	
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
	
		int id=Integer.parseInt(httpServletRequest.getParameter("id"));
		String name=httpServletRequest.getParameter("name");
		String email=httpServletRequest.getParameter("email");
		String phoneNo=httpServletRequest.getParameter("phone_no");		
		String education=httpServletRequest.getParameter("education");
		String dobString=httpServletRequest.getParameter("dob");

		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setPhoneNumber(phoneNo);
		student.setEducation(education);
		student.setDateOfBirth(dobString);
		
		int status=StudentDao.updateStudent(student);
		System.out.println(status);
		if(status==1){
			String msg="Successfully Updated";
			httpServletRequest.setAttribute("msg",msg);
			httpServletRequest.getRequestDispatcher("success.jsp").forward(httpServletRequest, httpServletResponse);
		}
		else{
			httpServletResponse.sendRedirect("error.jsp");
		}
	}
}
