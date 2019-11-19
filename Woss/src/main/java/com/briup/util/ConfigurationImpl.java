package com.briup.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.briup.client.ClientImpl;

public class ConfigurationImpl implements Configuration{
	SAXReader reader=null;
	File file=null;
	Document document=null;
	public List<Element> elements;
	Properties pro;
	public static Map<String, Object> map1=new HashMap<String,Object>();
	Map<String, Properties> map2=new HashMap<String,Properties>();
	public Map<String, Properties> parseXml() {
		try {
			String name=null;
			String text=null;
			Object cl=null;
			String name2=null;
			reader = new SAXReader();
			file = new File("src/main/resources/config.xml");
			document=reader.read(file);
			Element root = document.getRootElement();
			elements = root.elements();
			for(Element el :elements) {
				name2 = el.getQName().getName();
				Attribute attribute = el.attribute("class");
				cl= Class.forName(attribute.getValue()).newInstance();
				if(cl instanceof WossModuleInit) {
					map1.put(name2,cl);
				}
				//System.out.println(map1);
				List<Element> elements2 = el.elements();
				pro=new Properties();
				for(Element el2:elements2) {
					name = el2.getQName().getName();
					text = el2.getText();
					pro.setProperty(name, text);
				}
				//System.out.println(pro);
				map2.put(name2, pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return map2;
		}
	}
	
}
