package com.capgemini.onlinemovieticketsystem.dao;

import com.capgemini.onlinemovieticketsystem.dto.User;

public interface UserDao {
	public User registerNewUser(User user);

	public User signIn(String userName, String password);

	public boolean signOut();
}
