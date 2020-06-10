package com.capgemini.onlinemovieticketsystem.services;

import com.capgemini.onlinemovieticketsystem.dto.User;

public interface UserServices {
	public User registerNewUser(User user);

	public User signIn(String userName, String password);

	public boolean signOut();
}
