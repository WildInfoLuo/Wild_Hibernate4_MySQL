package com.wild.service.Impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wild.dao.ShareDataDao;
import com.wild.entity.ShareData;
import com.wild.service.ShareDataService;

@Service
@Transactional
public class ShareDataServiceImpl implements ShareDataService {

	@Autowired
	ShareDataDao shareDataDao;

	public Serializable insertData(ShareData shareData) {
		return shareDataDao.save(shareData);
	}

	@Override
	public Serializable insertData(Object shareData) {
		// TODO Auto-generated method stub
		return shareDataDao.save(shareData);
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		shareDataDao.update(entity);
	}
}
