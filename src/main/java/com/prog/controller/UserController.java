package com.prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bp;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserDtls u, RedirectAttributes redirectAttributes) {
		u.setPassword(bp.encode(u.getPassword()));
		u.setRole("ROLE_USER");
		userRepository.save(u);
		redirectAttributes.addFlashAttribute("msg", "Registration Successful");
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
