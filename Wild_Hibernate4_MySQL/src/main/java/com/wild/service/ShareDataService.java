package com.wild.service;

import java.io.Serializable;

public interface ShareDataService {
	Serializable insertData(Object shareData);
	void update(Object entity);
}
