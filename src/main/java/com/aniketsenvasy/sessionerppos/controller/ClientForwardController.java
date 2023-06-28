package com.aniketsenvasy.sessionerppos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class ClientForwardController {

	@GetMapping(value = { "/", "" })
	public String home() {
		System.err.println("root");
		return "index";
	}

	@GetMapping(value = "/pos/**")
	public ModelAndView forward(HttpSession httpSession) {
		System.err.println("pos");
//		if (authenticateUser(httpSession.getAttribute("username").toString(),
//				httpSession.getAttribute("password").toString())) {
//			return new ModelAndView("forward:/index.html");
//		}
//		else {
//			return new ModelAndView("redirect:/");
//		}
		Object usernameObj = httpSession.getAttribute("username");
		Object passwordObj = httpSession.getAttribute("password");
		if (usernameObj != null && passwordObj != null
				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
			return new ModelAndView("forward:/index.html");
		} else {
			return new ModelAndView("redirect:/"); // Redirect to the login page
		}

	}

	@PostMapping("/login")
	public String login(HttpSession httpSession, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		// Perform authentication logic here (e.g., check username and password against
		// a database)
		// If the authentication is successful, create a session for the user

		if (authenticateUser(username, password)) {
			httpSession.setAttribute("username", "admin");
			httpSession.setAttribute("password", "password");
			return "redirect:/pos"; // Redirect to the POS page
		} else {
			// Authentication failed, handle the error
			return "redirect:/error"; // Replace "error" with the appropriate error view name
		}
	}

	private boolean authenticateUser(String username, String password) {
		// Perform authentication logic here (e.g., check username and password against
		// a database)
		// Return true if authentication is successful, false otherwise
		// You can replace this with your own authentication mechanism
		return username.equals("admin") && password.equals("password");
	}

	@GetMapping("/error")
	public String handleError() {
		return "error"; // Return the error view page name
	}
}
