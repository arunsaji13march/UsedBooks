package com.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.exception.USERALREADYEXISTSEXCEPTION;
import com.user.exception.USERNOTFOUNDEXCEPTION;
import com.user.model.Role;
import com.user.model.User;
import com.user.repository.IUserRepository;

@Service
public class UserServiceImplementation implements IUserService {

	@Autowired
	private IUserRepository userRepository;


	@Override
	public String saveUser(User uobj) throws USERALREADYEXISTSEXCEPTION{
		User adduobj = null;
		
		User storedDetails = this.userRepository.findByUserEmail(uobj.getUserEmail());
		
		if(storedDetails!=null)
			{
			throw new USERALREADYEXISTSEXCEPTION();
			}
		else
		{
		   adduobj = this.userRepository.save(uobj);
		   return "true";
		}

	}

	@Override
	public User updateUser(User uobj, int uid) throws USERNOTFOUNDEXCEPTION
	{
		Optional <User> userOptional = this.userRepository.findById(uid);
		User uObj = null;
		User updatedData = null;
		if(userOptional.isPresent())
		{
			uObj = userOptional.get();
			uObj.setUserDob(uobj.getUserDob());
			uObj.setUserGender(uobj.getUserGender());
			uObj.setUserEmail(uobj.getUserEmail());
			uObj.setUserMobile(uobj.getUserMobile());
			uObj.setUserFirstName(uobj.getUserFirstName());
			uobj.setUserLastName(uobj.getUserLastName());
			uObj.setUserAddress(uobj.getUserAddress());
			uObj.setUserPassword(uobj.getUserPassword());
			updatedData=this.userRepository.save(uObj);	
		}
		else {
			throw new  USERNOTFOUNDEXCEPTION();
		}
		return updatedData;
	}

	@Override
	public User getUserById(int uid) throws USERNOTFOUNDEXCEPTION {
		Optional <User> userOptional = this.userRepository.findById(uid);
		User uObj = null;
		
		if(userOptional.isPresent())
		{
			uObj = userOptional.get();
		}
		else
		{
			throw new  USERNOTFOUNDEXCEPTION();
		}
		
		return uObj;
	}

	@Override
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}

	@Override
	public boolean delUser(int uid) throws USERNOTFOUNDEXCEPTION{
		Optional <User> userOptional = this.userRepository.findById(uid);
		boolean  status = false;
		if(userOptional.isPresent())
		{
			this.userRepository.delete(userOptional.get());
			status = true;	
		}
		else
		{
			throw new USERNOTFOUNDEXCEPTION();
		}
		return status;
	}

	@Override
	public User getuserByUserEmail(String userEmail) {
		return this.userRepository.findByUserEmail(userEmail);
	}

}
