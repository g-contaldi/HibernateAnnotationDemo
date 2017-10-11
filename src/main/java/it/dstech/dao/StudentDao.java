package it.dstech.dao;

import java.util.ArrayList;

import it.dstech.model.Student;

public interface StudentDao {

	Student saveStudent(Student student);

	ArrayList<Student> getListStudents(String queryHQL);

	ArrayList<Student> getByCriteria();
	
	ArrayList<Student> getAllStudentsByNamedQuery();
	
	Student findByName(String firstName);
	
	Student getByIdByCriteria(int id);

	Student updateStudent(Student student);

	Student deleteStudent(Student student);

}
