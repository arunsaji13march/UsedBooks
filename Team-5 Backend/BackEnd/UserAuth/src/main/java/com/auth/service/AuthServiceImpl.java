package com.auth.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth.feignconfig.RegisterRestConsumer;
import com.auth.model.User;
@Service
public class AuthServiceImpl implements IAuthService {
	
	@Autowired
	private RegisterRestConsumer rconsumer;
	
	@Override
	public String validateUser(User uObj) {
		
		User registeredDetails = this.rconsumer.getuserByUserEmailHandler(uObj.getUserEmail());
		if(registeredDetails!=null) {
			if(uObj.getUserEmail().equals("admin@gmail.com") && uObj.getUserPassword().equals("admin@123")) {
					return "aTrue";
			}
			else if(uObj.getUserEmail().equals(registeredDetails.getUserEmail()) && uObj.getUserPassword().equals(registeredDetails.getUserPassword())) {
				return "uTrue";
			}else {
				return "False";
			}
		}else {
			return "False";
		}
		
	}
}