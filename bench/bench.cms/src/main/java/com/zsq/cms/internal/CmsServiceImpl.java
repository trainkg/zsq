package com.zsq.cms.internal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zsq.cms.ICmsService;

@Service
@Transactional
public class CmsServiceImpl implements ICmsService {

	@Override
	public void deleteByUserId(String id) {
		System.out.println("delete user " + id);
	}

}
