package com.briup.server;

import java.sql.PreparedStatement;
import java.util.List;

import com.briup.bean.Environment;
import com.briup.util.WossModuleInit;

public interface DBStore extends WossModuleInit{
	public void getConnection(List<Environment> list); 
}
