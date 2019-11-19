package com.briup.main;

import java.util.List;
import java.util.Properties;

import com.briup.bean.Environment;
import com.briup.client.ClientImpl;
import com.briup.server.DBStoreImpl;
import com.briup.server.ServerImpl;
import com.briup.util.ConfigurationImpl;

public class ServerMain {
	public static void main(String[] args) {
		List<Environment> list=null;
		try {
			Properties properties = new ConfigurationImpl().parseXml().get("Server");
			ServerImpl obj= (ServerImpl)ConfigurationImpl.map1.get("Server");
			obj.init(properties);
			list = obj.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ServerImpl si=new ServerImpl();
		//List<Environment> list = si.get();
		
		try {
			Properties p = new ConfigurationImpl().parseXml().get("DBStore");
			DBStoreImpl o= (DBStoreImpl)ConfigurationImpl.map1.get("DBStore");
			o.init(p);
			o.getConnection(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		DBStoreImpl db=new DBStoreImpl();
//		db.getConnection(list);
//		System.out.println("插入成功");
	}
}
