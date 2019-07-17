package com.example.restJersey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/students")
public class StudentResource {

	//StudentRepository repo;
	
@GET
//@Path("/students")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Student> getStudents() {
		System.out.println("studRes");
		Student s1=new Student();
		s1.setId(10);
		s1.setName("Sonu");
		
		Student s2=new Student();
		s2.setId(11);
		s2.setName("Monu");
		
		List<Student> stud=Arrays.asList(s1,s2);
		
		return stud;
}

/*@POST
@Consumes(MediaType.APPLICATION_JSON)
public Student setStudent(Student s) {
	int roll=s.getId();
	String name=s.getName();
//	System.out.println("Roll no:" + roll);
//	System.out.println("Name:" +name);
s.toString();

	return s;
	
}
*/
}