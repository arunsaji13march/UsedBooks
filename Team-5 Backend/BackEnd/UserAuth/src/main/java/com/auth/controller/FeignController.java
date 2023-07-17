package com.auth.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.auth.feignconfig.RegisterRestConsumer;
import com.auth.model.User;
import com.auth.service.IAuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/path")
public class FeignController {
	
	@Autowired
	private IAuthService authService;
	
	@Autowired
	private RegisterRestConsumer rconsumer;
	
	
	private ResponseEntity<?> responseEntity;
	
	String roleOfUser;
	
	
//	@PostMapping("/login")
//	public ResponseEntity<?> check(@RequestBody User uObj){
//		boolean status= this.authService.validateUser(uObj);
//		responseEntity = new ResponseEntity<>(status, HttpStatus.OK);
//		return responseEntity;
//	}
	
	
	
	private Map<String, String> map = new HashMap<>();
	@GetMapping("/")
	public String serverStarted() {
		return "Authentication Server Started";
	}
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody User user) {
		
		User registeredDetails = this.rconsumer.getuserByUserEmailHandler(user.getUserEmail());
		int userId = registeredDetails.getUserId();
		try {
			String jwtToken = generateToken(user);
			map.put("roleOfUser", roleOfUser);
			map.put("userId", "userId"+userId);
			map.put("token", jwtToken);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			map.put("token", null);
			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	private String generateToken(User user) throws ServletException {
		String jwtToken = "";
		if (user.getUserEmail() == null || user.getUserPassword() == null) {
			throw new ServletException("Please send valid username and password");
		}
		
		String flag = authService.validateUser(user);
		System.out.println(flag);
		if (flag=="False" )
			throw new ServletException("Invalid Credentials...");
		else if(flag=="aTrue"){
			roleOfUser="admin";
			jwtToken = Jwts.builder().setSubject(user.getUserEmail()).setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 3000000))
					.signWith(SignatureAlgorithm.HS256, "secret key").compact();
		}
		else if(flag=="uTrue") {
			roleOfUser = "user";
			jwtToken = Jwts.builder().setSubject(user.getUserEmail()).setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 3000000))
					.signWith(SignatureAlgorithm.HS256, "secret key").compact();
			
		}
		return jwtToken;
	}
	
	
	
	
}