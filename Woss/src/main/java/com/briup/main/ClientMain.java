package com.briup.main;

import java.io.File;
import java.util.Map;
import java.util.Properties;

import com.briup.client.ClientImpl;
import com.briup.client.GatherImpl;
import com.briup.util.ConfigurationImpl;

public class ClientMain {
	public static void main(String[] args) {
//		ClientImpl ci=new ClientImpl();
//		ci.send();
		try {
			Properties properties = new ConfigurationImpl().parseXml().get("Client");
			ClientImpl obj= (ClientImpl)ConfigurationImpl.map1.get("Client");
			obj.init(properties);
			obj.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
