package com.javapratik.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javapratik.sms.entity.Student;
import com.javapratik.sms.service.StudentService;

@Controller
public class Studentcontroller {

	
	private StudentService studentService;
	
	public Studentcontroller(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	//now create handler method to handle list students and return model and view
	
	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
			
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_Student";
		
		}
	
	@PostMapping("/students/{id}")
	public String updateString(@PathVariable Long id , @ModelAttribute("student") Student student,Model model){
		 //get stu form db by id
		
Student existingStudent = studentService.getStudentById(id);
existingStudent.setFirstName(student.getFirstName());
existingStudent.setLastName(student.getLastName());
existingStudent.setEmail(student.getEmail());


//save update student obj

studentService.updateStudent(existingStudent);
return "redirect:/students";

		
		
	}
	
	
	//handeller method to delete stu req
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		
		studentService.deleteStudentById(id);
		return "redirect:/students";

	}
	
	
	
	
	
	
}

