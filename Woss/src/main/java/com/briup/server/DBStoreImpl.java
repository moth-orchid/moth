package com.briup.server;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import com.briup.bean.Environment;

public class DBStoreImpl implements DBStore{
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static Properties pp=null;
	static {
		pp = new Properties();
		InputStream in = DBStoreImpl.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		try {
			pp.load(in);
			driver = pp.getProperty("driver");
			url=pp.getProperty("url");
			username=pp.getProperty("username");
			password=pp.getProperty("password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private int batchSize;
	public void getConnection(List<Environment> list) {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			int j=1;
			int s=list.size()%batchSize;
			Statement cs = conn.createStatement();
			for(Environment en:list) {
				int i = en.getGather_date().getDate();
				String sql="insert into e_detail_"+i+" values ('"+en.getName()+"','"+en.getSendId()+"','"+en.getSmId()+"','"+en.getQmId()+"','"+en.getAddress()+"',"+en.getCount()+",'"+en.getOrdernumber()+"',"+en.getStatus()+","+en.getData()+",'"+en.getGather_date()+"')";
				cs.addBatch(sql);
				if(j%batchSize==0) {
					cs.executeBatch();
				}else if(j>(list.size()/batchSize)*batchSize && j%batchSize==s) {
					cs.executeBatch();
				}
				j++;
			}
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void init(Properties properties) throws Exception {
	 batchSize=Integer.parseInt(properties.getProperty("batchSize"));
		
	}
	
}
