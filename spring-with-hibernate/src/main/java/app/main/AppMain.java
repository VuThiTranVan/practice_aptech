package app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.model.Student;
import app.service.StudentService;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		StudentService studentService = (StudentService) context.getBean("studentService");

		Student stNew = new Student("vanv", "van101@gmail.com", 1);

		System.out.println(studentService.createStudent(stNew));
	}

}
