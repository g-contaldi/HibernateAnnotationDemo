package it.dstech.main;

import java.util.List;
import java.util.Scanner;

import it.dstech.config.HibernateUtil;
import it.dstech.dao.HibernateDao;
import it.dstech.model.Student;
import it.dstech.service.StudentService;
import it.dstech.service.StudentServiceImpl;

public class HibernateMain {

	private static Scanner in;

	private static StudentService studentService;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		studentService = new StudentServiceImpl();
		HibernateDao.getSession();

		boolean exit = false;

		do {
			System.out.println("------");
			System.out.println("1 - Crea studente");
			System.out.println("2 - Lista studenti");
			System.out.println("3 - Cerca studente per nome");
			System.out.println("4 - Update studente");
			System.out.println("5 - Delete studente");
			System.out.println("6 - Termina programma");

			int scelta = in.nextInt();
			in.nextLine();

			switch (scelta) {
			case 1:

				createStudent();
				break;
			case 2:

				getAllStudents();
				break;
			case 3:

				findByName();
				break;
			case 4:

				updateStudent();
				break;
			case 5:

				deleteStudent();
				break;
			case 6:

				HibernateDao.closeSession();
				HibernateUtil.shutdown();
				exit = true;
			}
		} while (!exit);
		System.exit(0);

	}

	private static void createStudent() {

		Student student = new Student();
		System.out.println("Inserisci nome");
		student.setFirstName(in.nextLine());
		System.out.println("Inserisci cognome");
		student.setLastName(in.nextLine());
		System.out.println("Inserisci sezione");
		student.setSection(in.nextLine());

		System.out.println("Studente creato: " + studentService.saveStudent(student));
	}

	private static List<Student> getAllStudents() {

		List<Student> listStudents = studentService.getListStudents("FROM Student s ORDER BY s.firstName ASC");

		// ArrayList<Student> listStudents = studentService.getByCriteria();

		// ArrayList<Student> listStudents =
		// studentService.getAllStudentsByNamedQuery();

		int id = 1;
		for (Student student : listStudents) {
			System.out.println(id + " - " + student);
			id++;
		}
		return listStudents;
	}

	private static void findByName() {
		System.out.println("Inserisci il nome dello studente da ricercare");
		String firstName = in.nextLine();
		System.out.println(studentService.findByName(firstName));

	}

	private static void updateStudent() {

		List<Student> allStudents = getAllStudents();

		System.out.println("Scegli lo studente da aggiornare");

		int scelta = in.nextInt();
		in.nextLine();

		Student student = allStudents.get(scelta - 1);

		System.out.println("Modificare il nome? y/n");
		if (in.nextLine().equals("y")) {
			System.out.println("Inserisci il nome?");
			student.setFirstName(in.nextLine());
		}
		System.out.println("Modificare il cognome? y/n");
		if (in.nextLine().equals("y")) {
			System.out.println("Inserisci il cognome?");
			student.setLastName(in.nextLine());
		}
		System.out.println("Modificare la sezione? y/n");
		if (in.nextLine().equals("y")) {
			System.out.println("Inserisci la sezione?");
			student.setSection(in.nextLine());
		}

		System.out.println("Utente aggiornato: " + studentService.updateStudent(student));

	}

	private static void deleteStudent() {

		List<Student> allStudents = getAllStudents();

		System.out.println("Scegli lo studente da eliminare");

		int scelta = in.nextInt();
		in.nextLine();

		System.out.println("Utente eliminato: " + studentService.deleteStudent(allStudents.get(scelta - 1)));

	}

}
