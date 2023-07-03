package com.aniketsenvasy.sessionerppos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aniketsenvasy.sessionerppos.model.Employee;
import com.aniketsenvasy.sessionerppos.repository.EmployeeRepository;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class EmployeeJspController {
	@Autowired
	private EmployeeRepository employeeRepo;
  // just see previous commit for changes
	@GetMapping("/add")
	public String showAddEmployeeForm(HttpSession httpSession) {
		Object usernameObj = httpSession.getAttribute("username");
		Object passwordObj = httpSession.getAttribute("password");
		if (usernameObj != null && passwordObj != null
				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {

			return "addEmployee";
		} else
			return "redirect:/not-authorized";
	}

	@PostMapping("/add")
	public String addEmployee(@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("mobileNumber") double mobileNumber, @RequestParam("gender") String gender,
			@RequestParam("dateOfBirth") String dateOfBirth, HttpSession httpSession) {
		// Perform logic to add the employee to the database
		Object usernameObj = httpSession.getAttribute("username");
		Object passwordObj = httpSession.getAttribute("password");
		if (usernameObj != null && passwordObj != null
				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
			Employee employeeToAdd = new Employee();
			employeeToAdd.setFullName(fullName);
			employeeToAdd.setEmail(email);
			employeeToAdd.setMobileNumber(mobileNumber);
			employeeToAdd.setGender(gender);
			employeeToAdd.setDateOfBirth(dateOfBirth);
			employeeRepo.save(employeeToAdd);

			return "redirect:/ems";// Redirect to the employee profile page
		} else {
			return "redirect:/not-authorized";
		}
	}

	@GetMapping("/profile")
	public String showEmployeeProfile(Model model, HttpSession httpSession) {
		// Fetch the employee details from the database
		// You can retrieve the employee details and add them to the model
		Object usernameObj = httpSession.getAttribute("username");
		Object passwordObj = httpSession.getAttribute("password");
		if (usernameObj != null && passwordObj != null
				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {

			return "employeeProfile";
		} else {
			return "redirect:/not-authorized";
		}
	}

	private boolean authenticateUser(String username, String password) {
		return username.equals("admin") && password.equals("password");
	}
}
