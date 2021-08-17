package com.project.jwt.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.jwt.Entities.AuthRequest;
import com.project.jwt.Entities.PersonalDetails;
import com.project.jwt.jwtutil.JwtUtil;
import com.project.jwt.serviceInterface.PersonalDetService;

@RestController
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	
	@Autowired
	private PersonalDetService personaldetservice;

	@PostMapping("/login")
	public String login(@RequestBody AuthRequest authRequset) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequset.getUsername(), authRequset.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid Username/Password");
		}
		return "Welcome   " + authRequset.getUsername() + "  " + dtf.format(now) + " " + "Jwt Token   "
				+ jwtUtil.generateToken(authRequset.getUsername());

	}

	@PostMapping("/form/save-details")
	public String saveDetails(@RequestBody PersonalDetails personaldetails) throws Exception {
		personaldetservice.savedetails(personaldetails);
		return "Saved";
	}
	
	@DeleteMapping("/form/delete-details/{id}")
	public String deleteDetails(@PathVariable int id) throws Exception {
		personaldetservice.deleteDetails(id);
		return "All the Data related to id no. "+id+" is deleted";
	}

}
