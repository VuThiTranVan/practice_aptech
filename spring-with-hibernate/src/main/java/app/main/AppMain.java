package app.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.AppConfiguration;
import app.model.Student;
import app.service.StudentService;

public class AppMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		StudentService studentService = context.getBean(StudentService.class);

		Student stNew = new Student("van3v", "van3101@gmail.com", 1);
		System.out.println(studentService.createStudent(stNew));

	}

}
