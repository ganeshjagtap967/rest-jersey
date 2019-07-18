package com.example.restJersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/students")
public class StudentResource {

	StudentRepository repo=new StudentRepository();
	
@GET
//@Path("/students")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})


	public List<Student> getStudents() {
		
		return repo.getStudents();
}

@GET
@Path("student/{id}")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public Student getStudent(@PathParam("id") int id) {
	System.out.println(repo.getStudent(id));
	return repo.getStudent(id);
	
}

@POST
@Path("student")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public Student createStudent(Student s1) {
	repo.create(s1);
	System.out.println(s1);
	return s1;
	
}

@PUT
@Path("/student")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public Student updateStudent(Student s1) {
	if(repo.getStudent(s1.getId()).getId()==0) {
		repo.create(s1);
	}
	else {
		repo.update(s1);
	}
	return s1;
	
}

@DELETE
@Path("/student/{id}")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public Student deleteStudent(@PathParam("id") int id) {
	Student s=repo.getStudent(id);
	if(s.getId()!=0) {
		repo.delete(id);
		}
	else {
		System.out.println("Record not present");
	}
	return s;
	
}
}