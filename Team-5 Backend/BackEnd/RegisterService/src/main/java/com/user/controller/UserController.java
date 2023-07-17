package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.exception.USERALREADYEXISTSEXCEPTION;
import com.user.exception.USERNOTFOUNDEXCEPTION;
import com.user.model.User;
import com.user.service.IUserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/users/v1")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUserHandler(@RequestBody User uobj) throws USERALREADYEXISTSEXCEPTION
	{
		try
		{
		String newUser = this.userService.saveUser(uobj);
		responseEntity = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		}catch (USERALREADYEXISTSEXCEPTION e) {
			responseEntity = new ResponseEntity<>("User Already Exist", HttpStatus.CONFLICT);
					e.printStackTrace();	
		}
		return responseEntity;
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> GetUserHandler()
	{
		List<User> allUsers = this.userService.getAllUsers();
		responseEntity = new ResponseEntity<>(allUsers,HttpStatus.OK);
			return responseEntity;
	}
	
	@PutMapping("/updateuser/{uid}")
	public ResponseEntity<?> updateUserHandler(@RequestBody User uobj, @PathVariable int uid) throws USERNOTFOUNDEXCEPTION 
	{		
		try {
		User updateUser = this.userService.updateUser(uobj,uid);
		responseEntity = new ResponseEntity<>(updateUser, HttpStatus.CREATED);
		}catch(USERNOTFOUNDEXCEPTION e) {
			responseEntity = new ResponseEntity("User Not found",HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	
	@GetMapping("/getuserbyid/{uid}")
	public ResponseEntity<?> getUserByIdHandler(@PathVariable int uid) throws USERNOTFOUNDEXCEPTION
	{
		try {
		User uObj = this.userService.getUserById(uid);
		responseEntity = new ResponseEntity<>(uObj, HttpStatus.OK);
		}catch(USERNOTFOUNDEXCEPTION e) {
			responseEntity = new ResponseEntity("User Not found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
	
	@DeleteMapping("/deleteUser/{uid}")
	public ResponseEntity<?> DeleteUserByIdHandler(@PathVariable int uid) throws USERNOTFOUNDEXCEPTION
	{
		try {
		boolean status= this.userService.delUser(uid);
		responseEntity = new ResponseEntity<>(status, HttpStatus.OK);
		}catch(USERNOTFOUNDEXCEPTION e) {
			responseEntity = new ResponseEntity<>("User not exist",HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	
	@GetMapping("/getuserbyuserEmail/{userEmail}")
	public ResponseEntity<?> getuserByUserEmailHandler(@PathVariable String userEmail) throws USERNOTFOUNDEXCEPTION
	{
		User uObj = this.userService.getuserByUserEmail(userEmail);
		responseEntity = new ResponseEntity<>(uObj, HttpStatus.OK);
		return responseEntity; 
	}

}
