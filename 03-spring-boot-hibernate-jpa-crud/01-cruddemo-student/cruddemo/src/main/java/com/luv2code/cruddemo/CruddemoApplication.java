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
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Delete all Students");
		int numRowsDeleted =studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;
		System.out.println("Delete student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with Id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student ");
		myStudent.setFirstName("tota");
		studentDAO.update(myStudent);

		studentDAO.update(myStudent);

		System.out.println("Update student: "+myStudent);

	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("ahmed");

		for (Student temp : theStudents){
			System.out.println(temp);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student temp : theStudents){
			System.out.println(temp);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object ");
		Student tempStudent = new Student("rana" , "ahmed" ,"rana@gmail.com");

		//save the student object
		System.out.println("Saving the student ");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: "+myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 student object ");
		Student tempStudent1 = new Student("rana" , "ahmed" ,"rana@gmail.com");
		Student tempStudent2 = new Student("hana" , "ali" ,"hana@gmail.com");
		Student tempStudent3 = new Student("ali" , "ahmed" ,"ali@gmail.com");

		System.out.println("Saving the students ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object ");
		Student tempStudent = new Student("toqa" , "ali" ,"toqa@gmail.com");

		//save the student object
		System.out.println("Saving the student ");
		studentDAO.save(tempStudent);

		//display id of saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
