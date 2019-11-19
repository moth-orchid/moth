package com.briup.util;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogImpl implements log{
	Logger logger=null;
	private static String log;
	public void logTest() {
		//获取rootlogger
		logger = Logger.getRootLogger();
		//加载propertiles文件
		PropertyConfigurator.configure(log);
		
	}
	public void init(Properties properties) throws Exception {
		log=properties.getProperty("log4j-properties");
		
	}
	public void debuglog(String meaaage) {
		logger.debug(meaaage);
	}
	
	public void infolog(String meaaage) {
		logger.info(meaaage);
	}
//	public static void main(String[] args) {
//		LogImpl log=new LogImpl();
//		log.logTest();
//	}

}
