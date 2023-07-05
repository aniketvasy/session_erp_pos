package com.aniketsenvasy.sessionerppos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/")

public class ClientForwardController {

	@GetMapping(value = { "/", "" })
	public String home() {
		System.err.println("root");
		return "login";
	}

	@GetMapping(value = "/ems/**")
	public ModelAndView forward() {
		System.err.println("ems");

//		Object usernameObj = httpSession.getAttribute("username");
//		Object passwordObj = httpSession.getAttribute("password");
//		if (usernameObj != null && passwordObj != null
//				&& authenticateUser(usernameObj.toString(), passwordObj.toString())) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/index.html");		
		mv.addObject("myname","aniket");
		return mv;
//		} else {
//			return new ModelAndView("redirect:/not-authorized"); // Redirect to the login page
//		}

	}

//	@PostMapping("/login")
//	public String login(HttpSession httpSession, @RequestParam("username") String username,
//			@RequestParam("password") String password) {
//		System.err.println("login post");
//		if (authenticateUser(username, password)) {
//			httpSession.setAttribute("username", "admin");
//			httpSession.setAttribute("password", "password");
//			return "redirect:/ems"; // Redirect to the POS page
//		} else {
//			// Authentication failed, handle the error
//			return "redirect:/not-authorized"; // Replace "error" with the appropriate error view name
//		}
//	}

	private boolean authenticateUser(String username, String password) {
		return username.equals("admin") && password.equals("password");
	}

	@GetMapping("/not-authorized")
	public String handleError() {
		return "notauthorized"; // Return the error view page name
	}
}
