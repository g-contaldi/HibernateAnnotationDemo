package it.dstech.service;

import java.util.ArrayList;

import it.dstech.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	ArrayList<Student> getListStudents(String queryHQL);
	
	ArrayList<Student> getAllStudentsByNamedQuery();
	
	ArrayList<Student> getByCriteria();
	
	Student findByName(String firstName);

	Student updateStudent(Student student);

	Student deleteStudent(Student student);

}
