package com.briup.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.bean.Environment;

public class ServerImpl implements Server{

	ObjectInputStream ob=null;
	InputStream inputStream=null;
	List<Environment> readObject=null;
	int port;
	public static Logger log=Logger.getLogger("ClientImpl.class");
	public List<Environment>  get() {
		try {
			ServerSocket server=new ServerSocket(port);
			log.debug("等待连接");
			Socket socket=server.accept();
			System.out.println(socket);
			inputStream = socket.getInputStream();
			ob = new ObjectInputStream(inputStream);
			try {
				readObject = (List<Environment>)ob.readObject();
				System.out.println(((List<Environment>)readObject).size());
				log.debug("接收到所有数据");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(inputStream!=null)
				try {
					inputStream.close();
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
		return readObject;
	}
	public void init(Properties properties) throws Exception {
		port=Integer.parseInt(properties.getProperty("port"));
		
	}

}
