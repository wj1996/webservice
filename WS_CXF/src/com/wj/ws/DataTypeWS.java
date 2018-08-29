package com.wj.ws;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.wj.domain.Student;

@WebService
public interface DataTypeWS {

	@WebMethod
	public boolean addStudent(Student s);
	@WebMethod
	public Student getStudentById(int id);
	@WebMethod
	public List<Student> getStudentsByPrice(float price);
	@WebMethod
	public Map<Integer,Student> getAllStudentsMap();
}
