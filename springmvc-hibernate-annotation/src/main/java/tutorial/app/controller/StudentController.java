package tutorial.app.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tutorial.app.model.Student;
import tutorial.app.service.StudentService;

@Controller
public class StudentController {
	private static final Logger logger = Logger.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String init(Model model) {
		logger.info("home page");
		model.addAttribute("student", new Student());
		model.addAttribute("students", studentService.getListStudent());
		return "/students/listSt";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showStudent(@PathVariable("id") int id, Model model) {
		logger.info("detail student");
		Student student = studentService.findById(id);
		if (student == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Student not found");
		}
		model.addAttribute("student", student);

		return "/students/student";

	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		logger.info("delete student");
		if (studentService.deleteStudent(id)) {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Student is deleted!");
		} else {
			redirectAttributes.addFlashAttribute("css", "error");
			redirectAttributes.addFlashAttribute("msg", "Delete student fails!!!!");
		}

		return "redirect:/";

	}

	@RequestMapping(value = "/students/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		logger.debug("showAddUserForm()");

		Student student = new Student();

		// set default value
		student.setGender(0);

		model.addAttribute("studentForm", student);
		model.addAttribute("status", "add");

		return "students/studentform";

	}

	// show update form
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

		Student student = studentService.findById(id);
		model.addAttribute("studentForm", student);
		model.addAttribute("status", "edit");

		return "students/studentform";

	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("studentForm") @Valid Student studentForm, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		logger.info("create or update");
		if (result.hasErrors()) {
			if (studentForm.getId() == null) 
				model.addAttribute("status", "add");
			else
				model.addAttribute("status", "edit");
			return "/students/studentform";
		} else {

			if (studentForm.getId() == null) {
				// new
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				// update
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			studentService.saveOrUpdate(studentForm);
			return "redirect:/";

		}

	}

}
