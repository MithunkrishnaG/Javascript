package com.project.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.college.entity.Student;
import com.project.college.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@GetMapping("/add-student")
	public String showAddStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "create";
	}

	@GetMapping("")
	public String showProfile(Model model) {
		List<Student> students = repository.findAll();
		model.addAttribute("students", students);
		return "view";
	}

	@PostMapping("/students")
	public String addStudent(Student student) {
		repository.save(student);
		return "redirect:/";
	}

	@GetMapping("/update")
	public String updateStudentForm(Model model) {
		Student student = repository.findById(1L).orElse(null);
		model.addAttribute("student", student);
		return "update";
	}

	@PostMapping("/update-student")
	public String updateStudent(@ModelAttribute("student") Student updatedStudent) {
		repository.save(updatedStudent);
		return "redirect:/";
	}

	@PostMapping("/delete-student")
	public String deleteAllStudents() {
		repository.deleteAll();
		return "redirect:/";
	}
}
