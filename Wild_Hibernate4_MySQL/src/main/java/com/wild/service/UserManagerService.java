package com.wild.service;

import java.util.List;

import com.wild.entity.User;

public interface UserManagerService {
	public User getUser(String id);

	public List<User> getAllUser();

	public void addUser(User user);

	public boolean delUser(String id);

	public boolean updateUser(User user);
}
