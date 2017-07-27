package com.wild.dao;

import java.io.Serializable;

import com.wild.entity.ShareData;

public interface ShareDataDao {
	Serializable save(ShareData shareData);
	
	Serializable save(Object shareData);
	
	Serializable update(Object enity);
}
