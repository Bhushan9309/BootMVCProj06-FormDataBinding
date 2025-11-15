package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {
       
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("StudentOperationsController.showHomePage()");
		// return  LVN
		return "welcome";   
	}
	
	@GetMapping("/register")//for launching the form page
	public String showStudentRegistrationPage(@ModelAttribute("stud") Student st) {
		System.out.println("StudentOperationsController.showStudentRegistrationPage()");
		//  return LVN
		return "student_register_form";   
	}
	
	@PostMapping("/register") //for submitting  the form page
	public String processStudentRegistration(
			@ModelAttribute("stud") Student st,
			Map<String, Object> map) {

		System.out.println("StudentOperationsController.processStudentRegistration() : ==> " + st);

		// Business logic
		String result = null;

		if (st.getAvg() >= 75)
			result = "First Class With Distinction";
		else if (st.getAvg() >= 60)
			result = "First Class";
		else if (st.getAvg() >= 50)
			result = "Second Class";
		else if (st.getAvg() >= 35)
			result = "Third Class";
		else
			result = "Fail";

		// Add result to model
		map.put("resultMsg", result);

		//return  LVN
		return "display";
	}
}
