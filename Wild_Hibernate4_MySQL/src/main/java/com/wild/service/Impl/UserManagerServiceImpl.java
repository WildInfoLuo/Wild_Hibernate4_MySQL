package com.wild.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wild.dao.UserManagerDao;
import com.wild.entity.User;
import com.wild.service.UserManagerService;

@Service
@Transactional
public class UserManagerServiceImpl implements UserManagerService {
	@Autowired
	private UserManagerDao managerDao;

	public void setUserDao(UserManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public User getUser(String id) {
		return managerDao.getUser(id);
	}

	@Override
	public List<User> getAllUser() {
		return managerDao.getAllUser();
	}

	@Override
	public void addUser(User user) {
		managerDao.addUser(user);
	}

	@Override
	public boolean delUser(String id) {
		return managerDao.delUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return managerDao.updateUser(user);
	}

}
