package com.example.restJersey;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentRepository {
	
	Connection con=null;
	
	public StudentRepository() {
		String url="jdbc:mysql://localhost:3306/new_schema";
		String username="root";
		String password="pass123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
					
			con=DriverManager.getConnection(url,username,password);
				System.out.println("Connection established...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		String sql="select * from test_table";
		
		try {
			Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			Student s=new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			System.out.println("Data fetched...");
			students.add(s);
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return students;
		//return null;
		
		
	}
	
	public Student getStudent(int id){
String sql="select * from test_table where id=" +id;
Student s=new Student();

		try {
			Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()) {
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			
			System.out.println("Record found...");
			
		}
		
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return s;
		
		
		
	}

	public void create(Student s1) {
		// TODO Auto-generated method stub
		String sql="insert into test_table values(?,?)";
		
		try {
			PreparedStatement st=con.prepareStatement(sql);
	st.setInt(1,s1.getId());
	st.setString(2,s1.getName());
	st.executeUpdate();
	
		System.out.println("Record inserted...");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}
	
	public void update(Student s1) {
		// TODO Auto-generated method stub
		String sql="update test_table set name=? where id=?";
		
		try {
			PreparedStatement st=con.prepareStatement(sql);
	
	st.setString(1,s1.getName());
	st.setInt(2,s1.getId());
	st.executeUpdate();
	System.out.println("Record updated...");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
	String sql="delete from test_table where id=?";
		
		try {
			PreparedStatement st=con.prepareStatement(sql);
	
	st.setInt(1,id);
	st.executeUpdate();
	System.out.println("Record deleted...");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}

class St extends StudentRepository{
	
}
