package com.briup.client;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.briup.bean.Environment;
import com.briup.util.ConfigurationImpl;

import oracle.sql.TIMESTAMP;
public class GatherImpl implements Gather{
	public static List<Environment> list=new ArrayList<Environment>();
	//从文件中获取数据，并且封装成对象
	public static String path=null;
    public List<Environment> getData(File file) throws Exception {
			FileReader r=null;
			Environment environment=null;
			BufferedReader br=null;
			try {
				r = new FileReader(file);
				br = new BufferedReader(r);
				String name1=null;
				String name=null;
				String name2=null;
				// 环境值
				float data1=0.0f;
				float data2=0.0f;
				String data=null;
				while((data=br.readLine())!=null) {
					String[] str = data.split("[|]");
					// 发送端id
					String sendId=str[0];
					// 树莓派系统id
					String smId=str[1];
					// 实验箱区域模块id(1-8)
					String qmId=str[2];
					// 模块上传感器地址
					String address=str[3];
					// 传感器个数
					int count=Integer.parseInt(str[4]);
					// 指令标号(3表示需要接受数据 16表示需要发送数据)
					String ordernumber=str[5];
					// 状态 默认为1表示成功
					int status=Integer.parseInt(str[7]);
					// 采集时间
					Timestamp gather_date=new Timestamp(Long.parseLong(str[8]));
					// 环境种类名称
					int a=Integer.parseInt(str[3]);
					if(a==16) {
						name1 = "温度";
						data1=(float) ((Integer.parseInt(str[6].substring(0, 4), 16) * 0.00268127) - 46.85);
						environment=new Environment(name1,sendId,smId,qmId,address,count,ordernumber,status,data1,gather_date);
						list.add(environment);
						name2 = "湿度";
						data2=(float) ((Integer.parseInt(str[6].substring(4, 8), 16)*0.00190735)-6);
						environment=new Environment(name2,sendId,smId,qmId,address,count,ordernumber,status,data2,gather_date);
						list.add(environment);
					}else if(a==256) {
						name = "光照强度";
						data1=Integer.valueOf(str[6].substring(0, 4), 16);
						environment=new Environment(name,sendId,smId,qmId,address,count,ordernumber,status,data1,gather_date);
						list.add(environment);
					}else {
						name="二氧化碳浓度";
						data1=Integer.valueOf(str[6].substring(0, 4), 16);
						environment=new Environment(name,sendId,smId,qmId,address,count,ordernumber,status,data1,gather_date);
						list.add(environment);
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(r!=null)
					try {
						r.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(br!=null)
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			return list;
		}
	public void init(Properties properties) throws Exception {
		path=properties.getProperty("path");
	}
	
}
	

