package com.java.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.Student;

public class StudentDao {
	
	//get connection
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.cj.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");  
	    }
	    catch(Exception e){System.out.println(e);}  
	    return con;  
	}
	
	//insert
	public static int insert(Student s)
	{
		int status=0;
		try
		{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("insert into student(name,email,phone_number,birthdate,education) values(?,?,?,?,?)");		
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getPhone_no());
			String dateString=s.getDob();
			java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);
			pst.setDate(4, sqlDate);
			pst.setString(5, s.getEducation());
			
			status=pst.executeUpdate();
			if(status==1)
			{
				System.out.println("Inserted");
			}
			pst.close();
			con.close();
			return status;
			
		}
		catch (Exception e) {System.out.println(e);}
		return 0;
	}

	//delete
	public static int delete(int id)
	{
		int status=0;
		try
		{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("delete from student where id=?");
			pst.setInt(1,id);
			
			status=pst.executeUpdate();
			if(status==1)
			{
				System.out.println("Deleted");
			}
			return status;	
		}
		catch (Exception e) {System.out.println(e);}
		return 0;	
	}
	
	//view
	public static List<Student> viewStudents()
	{
		 List<Student> students = new ArrayList<>();
		 try
		 {
			 Connection con=getConnection();
			 PreparedStatement pst=con.prepareStatement("select*from student");
			 ResultSet rs=pst.executeQuery();
			 
			 while(rs.next())
			 {
				 Student s=new Student();
				 s.setId(rs.getInt("id"));
				 s.setEmail(rs.getString("email"));
				 s.setName(rs.getString("name"));
				 s.setPhone_no(rs.getString("phone_number"));
				 java.sql.Date dob = rs.getDate("birthdate");
				 String dateString = (dob != null) ? dob.toString() : null;
				 s.setDob(dateString);
				 s.setEducation(rs.getString("education"));
				 students.add(s);
				 
			 }
			 rs.close();
				pst.close();
				con.close();
			 return students;
		 }
		 catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	//getstudent
	public static Student getStudent(int id)
	{
		Student s=new Student();
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select*from student where id=?");
			
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone_no(rs.getString("phone_number"));
				s.setEducation(rs.getString("education"));
				s.setEmail(rs.getString("email"));
				java.sql.Date dob = rs.getDate("birthdate");
				String dateString = (dob != null) ? dob.toString() : null;
				s.setDob(dateString);
			}
			return s;
			
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	//update
	public static int updateStudent(Student s)
	{
		int status=0;
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("update student set name=?,email=?,phone_number=?,education=?,birthdate=? where id=?");
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getPhone_no());
			pst.setString(4, s.getEducation());
			//date
			String dateString=s.getDob();
			java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);
			pst.setDate(5, sqlDate);
			pst.setInt(6, s.getId());
			status=pst.executeUpdate();
			return status;
		}
		catch (Exception e) {System.out.println(e);}
		return 0;
	}
}
