package com.user.service;

import java.util.List;

import com.user.exception.USERALREADYEXISTSEXCEPTION;
import com.user.exception.USERNOTFOUNDEXCEPTION;
import com.user.model.User;

public interface IUserService {

	public String saveUser(User uobj) throws USERALREADYEXISTSEXCEPTION;
	public User updateUser(User uobj, int uid) throws USERNOTFOUNDEXCEPTION;
	public User getUserById(int uid) throws USERNOTFOUNDEXCEPTION;
	public List<User> getAllUsers();
	public boolean delUser(int uid) throws USERNOTFOUNDEXCEPTION;
	public User getuserByUserEmail(String userEmail) throws USERNOTFOUNDEXCEPTION;

}
