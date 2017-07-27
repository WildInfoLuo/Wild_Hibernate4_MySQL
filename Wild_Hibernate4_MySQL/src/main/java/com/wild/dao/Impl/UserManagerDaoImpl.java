package com.wild.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wild.dao.UserManagerDao;
import com.wild.entity.User;

@Repository
@Transactional
public class UserManagerDaoImpl implements UserManagerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}
	/**
	 * 根据ID查询结果
	 */
	@Override
	public User getUser(String id) {
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (User) query.uniqueResult();
	}

	/**
	 * 批量获取数据库中的数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 增加用户信息
	 */
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public boolean delUser(String id) {
		String hql = "delete from User where id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (query.executeUpdate() > 0);
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public boolean updateUser(User user) {
		String hql = "update User u set u.userName =?,u.age=? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUserName());
		query.setString(1, user.getAge());
		query.setString(2, user.getId());
		return query.executeUpdate() > 0;
	}

}
