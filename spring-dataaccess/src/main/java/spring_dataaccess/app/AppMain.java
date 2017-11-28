package spring_dataaccess.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_dataaccess.app.model.Student;
import spring_dataaccess.app.service.StudentService;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		Student st = new Student(3, "student", "student1@gmail.com", 1);

		StudentService stService = (StudentService) ctx.getBean("studentServiceImpl");

		System.out.println(stService.createStudent(st));
	}

}
