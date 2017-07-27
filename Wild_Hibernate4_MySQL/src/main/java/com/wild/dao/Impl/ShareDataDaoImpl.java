package com.wild.dao.Impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wild.dao.ShareDataDao;
import com.wild.entity.ShareData;

@Repository   
@Transactional
public class ShareDataDaoImpl implements ShareDataDao {
	@Autowired
	SessionFactory sessionFactory;

	public Serializable save(ShareData shareData) {
		Session session = sessionFactory.getCurrentSession();
		return session.save(shareData);
	}

	@Override
	public Serializable save(Object shareData) {
		Session session = sessionFactory.getCurrentSession();
		return session.save(shareData);
	}

	@Override
	public Serializable update(Object enity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(enity);
		return null;
	}
}
