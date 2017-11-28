package tutorial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tutorial.app.model.Student;
import tutorial.app.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String userForm(Model model) {

		model.addAttribute("student", new Student());
		model.addAttribute("students", studentService.getListStudent());
		return "studentInit";
	}
}
