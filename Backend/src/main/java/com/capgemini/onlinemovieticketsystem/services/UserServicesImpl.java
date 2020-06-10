package com.capgemini.onlinemovieticketsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.onlinemovieticketsystem.dao.UserDao;
import com.capgemini.onlinemovieticketsystem.dto.User;

@Service
public class UserServicesImpl implements UserServices {
	@Autowired
	private UserDao dao;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public User registerNewUser(User user) {
		// TODO Auto-generated method stub
		String encodedPassword=encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return dao.registerNewUser(user);
	}

	@Override
	public User signIn(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.signIn(userName, password);
	}

	@Override
	public boolean signOut() {
		// TODO Auto-generated method stub
		return false;
	}

}
