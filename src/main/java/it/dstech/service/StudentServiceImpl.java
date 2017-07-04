package it.dstech.service;

import java.util.ArrayList;

import it.dstech.dao.StudentDao;
import it.dstech.dao.StudentDaoImpl;
import it.dstech.model.Student;

public class StudentServiceImpl implements StudentService {
	
	StudentDao dao = new StudentDaoImpl();

	public Student saveStudent(Student student) {
		return dao.saveStudent(student);
	}

	public ArrayList<Student> getListStudents(String queryHQL) {
		return dao.getListStudents(queryHQL);
	}

	public Student updateStudent(Student student) {
		return dao.updateStudent(student);
	}

	public Student deleteStudent(Student student) {
		return dao.deleteStudent(student);
	}

	public ArrayList<Student> getByCriteria() {
		return dao.getByCriteria();
	}

	public ArrayList<Student> getAllStudentsByNamedQuery() {
		return dao.getAllStudentsByNamedQuery();
	}

	public Student findByName() {
		return dao.findByName();
	}

}
