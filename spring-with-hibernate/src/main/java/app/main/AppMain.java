package app.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.model.Student;
import app.service.StudentService;

// Link: https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#criteria
public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		StudentService studentService = (StudentService) context.getBean("studentService");
//		Student st = studentService.findById(4);
//		System.out.println("Id: " + st.getId());
		
//		Student stNew = new Student("van1", "van1@gmail.com", 1);
//
//		System.out.println(studentService.createStudent(stNew));

//		Student stUpdate = new Student(4, "update Name", "update@gmail.com", 0);
//		System.out.println(studentService.updateStudent(stUpdate));
		
//		Student stDelete = new Student(2, "update Name", "update@gmail.com", 0);
//		System.out.println(studentService.deleteStudent(stDelete));
		
		// practice HQL query
//		Student stByEmail = studentService.findByEmail("update@gmail.com");
//		stByEmail.display();
		
		List<Student> listSt = studentService.searchSt("v", 1);
		
		System.out.println("size: " + listSt.size());
		for (Student student : listSt) {
			student.display();
		}
	}

}
