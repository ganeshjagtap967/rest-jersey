package com.example.restJersey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;

public class StudentRepository {

	List<Student> students;
	
	Connection con=null;
	
	public StudentRepository() throws SQLException, ClassNotFoundException {
		
		String url="jdbc:mysql://localhost:3306/new_schema";
		String username="root";
		String password="pass123";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection(url,username,password);
		
		
		students =new ArrayList<>();
		
				
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
			
			students.add(s);
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return students;
		
	}
	public Student getStudent(int id) {
		String sql="select * from test_table where id=" +id;
		Student s=new Student();
		
		try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			
			
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return s;
		
	}

	public void create(Student s1) {
		// TODO Auto-generated method stub
		String sql="insert into test_table(?,?)";
		try {
			PreparedStatement st=con.prepareStatement(sql);
				st.setInt(1,s1.getId());
				st.setString(2,s1.getName());
				
				st.executeUpdate();
				
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
		students.add(s1);
		
	}
}
