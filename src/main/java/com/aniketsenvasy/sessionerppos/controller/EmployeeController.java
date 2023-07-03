package com.aniketsenvasy.sessionerppos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aniketsenvasy.sessionerppos.config.ApiResponse;
import com.aniketsenvasy.sessionerppos.exception.DataNotFound;
import com.aniketsenvasy.sessionerppos.model.Employee;
import com.aniketsenvasy.sessionerppos.repository.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepo;

//---------------------------------------||   Create Employee - Start   ||-------------------------------------------------------
	@PostMapping(value = { "/employee" })
	@ResponseBody
	public ApiResponse postEmployee(HttpSession httpSession, @RequestBody Employee recievedEmployee) {


//
		Object usernameObj = httpSession.getAttribute("username");
		Object passwordObj = httpSession.getAttribute("password");
		if (usernameObj != null && passwordObj != null
				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
		employeeRepo.save(recievedEmployee);
		return new ApiResponse(true, "Success", recievedEmployee);
		}
		return new ApiResponse(false, "Failed", "Not Authorized");
	}
//---------------------------------------||   Create Employee - End   ||----------------------------------------------------------

// ---------------------------------------|| Get Employee by Id - Start||---------------------------------------------------------
	@GetMapping(value = { "/employee/{recievedEmployeeId}" })
	@ResponseBody
	public ApiResponse getEmployeeById(HttpSession httpSession, @PathVariable long recievedEmployeeId)
			throws DataNotFound {

		Object usernameObj = httpSession.getAttribute("username");
		Object passwordObj = httpSession.getAttribute("password");
		if (usernameObj != null && passwordObj != null
				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
		Employee fetchedEmployee = employeeRepo.findById(recievedEmployeeId)
				.orElseThrow(() -> new DataNotFound("Employe not found for thid id :: " + recievedEmployeeId));
		return new ApiResponse(true, "Success", fetchedEmployee);
		}
		return new ApiResponse(false, "Failed", "Not Authorized");
	}
// ---------------------------------------|| Get Employee by Id - End ||----------------------------------------------------------

// ---------------------------------------|| Get All Employee - Start||---------------------------------------------------------
	@GetMapping(value = { "/employee" })
	@ResponseBody
	public ApiResponse getAllEmployee(HttpSession httpSession) throws DataNotFound {

			Object usernameObj = httpSession.getAttribute("username");
			Object passwordObj = httpSession.getAttribute("password");
			if (usernameObj != null && passwordObj != null
					&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
		List<Employee> fetchedEmployee = employeeRepo.findAll();
		return new ApiResponse(true, "Successfully Fetched", fetchedEmployee);
			}
			return new ApiResponse(false, "Failed", "Not Authorized");
	}
// ---------------------------------------|| Get All Employee - End ||----------------------------------------------------------

// ---------------------------------------|| Update Employee - Start ||-------------------------------------------------------
	@PutMapping(value = { "/employee/{recievedEmployeeId}" })
	@ResponseBody
	public ApiResponse putEmployee(HttpSession httpSession, @PathVariable long recievedEmployeeId,
			@RequestBody Employee recievedEmployee) throws DataNotFound {

			Object usernameObj = httpSession.getAttribute("username");
			Object passwordObj = httpSession.getAttribute("password");
			if (usernameObj != null && passwordObj != null
					&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
		Employee fetchedEmployeeToUpdate = employeeRepo.findById(recievedEmployeeId)
				.orElseThrow(() -> new DataNotFound("Employe not found for thid id :: " + recievedEmployeeId));
		employeeRepo.save(recievedEmployee);
		fetchedEmployeeToUpdate.setFullName(recievedEmployee.getFullName());
		fetchedEmployeeToUpdate.setEmail(recievedEmployee.getEmail());
		fetchedEmployeeToUpdate.setMobileNumber(recievedEmployee.getMobileNumber());
		fetchedEmployeeToUpdate.setGender(recievedEmployee.getGender());
		fetchedEmployeeToUpdate.setDateOfBirth(recievedEmployee.getDateOfBirth());
		employeeRepo.save(fetchedEmployeeToUpdate);
		return new ApiResponse(true, "Successfully updated", fetchedEmployeeToUpdate);
			}
			return new ApiResponse(false, "Failed", "Not Authorized");
	}
// ---------------------------------------|| Update Employee - End ||----------------------------------------------------------

// ---------------------------------------|| Delete Employee - Start ||------------------------------------------------------

	@DeleteMapping(value = { "/employee/{recievedEmployeeId}" })
	@ResponseBody
	public ApiResponse deleteEmployeeById(HttpSession httpSession, @PathVariable long recievedEmployeeId) {

		Object usernameObj = httpSession.getAttribute("username");
		Object passwordObj = httpSession.getAttribute("password");
		if (usernameObj != null && passwordObj != null
				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
		employeeRepo.deleteById((long) recievedEmployeeId);
		return new ApiResponse(true, "Successfully deleted", 0);
		}
		return new ApiResponse(false, "Failed", "Not Authorized");
	}

// ---------------------------------------|| Delete Employee - End ||--------------------------------------------------------

	private boolean authenticateUser(String username, String password) {
		return username.equals("admin") && password.equals("password");
	}

}
