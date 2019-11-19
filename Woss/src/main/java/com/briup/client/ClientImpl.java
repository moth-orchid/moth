package com.briup.client;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.bean.Environment;
import com.briup.util.ConfigurationImpl;

public class ClientImpl implements Client{
	
	File file=null;
	List<Environment> data;
	int port;
	String ip;
	public static Logger log=Logger.getLogger("ClientImpl.class");
	public void send() {
		Properties p = new ConfigurationImpl().parseXml().get("Gather");
		GatherImpl o= (GatherImpl)ConfigurationImpl.map1.get("Gather");
		System.out.println(p);
		ObjectOutputStream ob=null;
		OutputStream outputStream=null;
		try {
			o.init(p);
			System.out.println(o.path);
			Socket socket=new Socket(ip,port);
			log.debug("连接成功");
			file = new File(o.path);
			try {
				 data = o.getData(file);
				outputStream = socket.getOutputStream();
				ob = new ObjectOutputStream(outputStream);
				 ob.writeObject(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(outputStream!=null)
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ob!=null)
				try {
					ob.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	public void init(Properties properties) throws Exception {
		ip=properties.getProperty("ip");
		port=Integer.parseInt(properties.getProperty("port"));
		
	}
	
}
