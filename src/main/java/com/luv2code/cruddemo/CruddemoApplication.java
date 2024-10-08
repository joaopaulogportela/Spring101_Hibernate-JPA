package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);

			//queryForStudents(studentDAO);
			//queryForStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		System.out.println("Number of deleted rows: " + studentDAO.deleteAllStudents());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting stundent with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId =1;
		System.out.println("Getting the student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		myStudent.setFirstName("John");

		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Duck");
		for(Student s : theStudents){
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStundents = studentDAO.findAll();

		for (Student s: theStundents) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creatiing a new stundent objects...");
		Student tempStudent1 = new Student("Daffy", "Duck", "daffy@luv2code.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);

		int theId = tempStudent1.getId();
		System.out.println("Saved student. Generated id: "+ tempStudent1.getId());
		Student myStudent = studentDAO.findById(theId);

		System.out.println(myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creatiing 3 new stundent objects...");
		Student tempStudent1 = new Student("Julia", "Monroe", "juliamonroe@luv2code.com");
		Student tempStudent3 = new Student("Robert", "Masokism", "robertmasokism@luv2code.com");
		Student tempStudent2 = new Student("Ighor", "Kriskovnosk", "ighorkiskovnosk@luv2code.com");

		System.out.println("Saving students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Student saved. Id: " + tempStudent1.getId());
		System.out.println("Student saved. Id: " + tempStudent2.getId());
		System.out.println("Student saved. Id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creatiing a new stundet object...");
		Student tempStudent = new Student("Paulo", "Doe", "paulodoe@luv2code.com");

		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		System.out.println("Student saved. Id: " + tempStudent.getId());
	}

}
