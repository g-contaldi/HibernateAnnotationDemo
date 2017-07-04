package it.dstech.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import it.dstech.model.Student;

public class StudentDaoImpl extends HibernateDao implements StudentDao {

	public Student saveStudent(Student student) {
		return (Student) persist(student);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Student> getListStudents(String queryHQL) {
		return (ArrayList<Student>) getAll(queryHQL);
	}

	public Student updateStudent(Student student) {
		return (Student) update(student);
	}

	public Student deleteStudent(Student student) {
		return (Student) delete(student);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Student> getByCriteria() {
		return (ArrayList<Student>) getSession().createCriteria(Student.class).list();
	}

	public Student getByIdByCriteria(int id) {
		Criteria criteria = getSession().createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", id));
		return (Student) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Student> getAllStudentsByNamedQuery() {
		return (ArrayList<Student>) getSession().getNamedQuery("findAllStudents").list();
	}

	public Student findByName() {
		Query namedQuery = getSession().getNamedQuery("findByName");
		namedQuery.setParameter("firstName", "rgdv");
		namedQuery.setParameter("lastName", "dfgcv");
		Student uniqueResult = (Student) namedQuery.uniqueResult();
		return uniqueResult;
	}

}
