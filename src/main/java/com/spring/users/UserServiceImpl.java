package com.spring.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")   //Spring Framework �� Bean ��� : userService 
public class UserServiceImpl implements UserService {

	// ����Ͻ� ������ ó�� �ϴ� Ŭ���� 
	
				// @Autowired ������̼��� Spring Framework�� ���� Bean �� Ÿ���� 
	@Autowired					//Ÿ���� ã�Ƽ� ���� (DI) 
	UserDAO userDAO ; 
	
	@Override
	public UserDTO getUser(UserDTO dto) {
		
		UserDTO user = userDAO.getUser(dto); 
		
		return user;
	}

}
