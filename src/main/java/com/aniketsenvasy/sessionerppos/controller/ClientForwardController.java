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

	@GetMapping(value = "/ems/**")
	public ModelAndView forward(HttpSession httpSession) {
		System.err.println("ems");

		Object usernameObj = httpSession.getAttribute("username");
		Object passwordObj = httpSession.getAttribute("password");
		if (usernameObj != null && passwordObj != null
				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
			return new ModelAndView("forward:/index.html");
		} else {
			return new ModelAndView("redirect:/not-authorized"); // Redirect to the login page
		}

	}

	@PostMapping("/login")
	public String login(HttpSession httpSession, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		if (authenticateUser(username, password)) {
			httpSession.setAttribute("username", "admin");
			httpSession.setAttribute("password", "password");
			return "redirect:/ems"; // Redirect to the POS page
		} else {
			// Authentication failed, handle the error
			return "redirect:/not-authorized"; // Replace "error" with the appropriate error view name
		}
	}

	private boolean authenticateUser(String username, String password) {
		return username.equals("admin") && password.equals("password");
	}

	@GetMapping("/not-authorized")
	public String handleError() {
		return "notauthorized"; // Return the error view page name
	}
}
