package com.briup.service;

import com.briup.common.bean.SUser;

public interface IUserService {
	SUser findAllSUer(String username,String password);
}
