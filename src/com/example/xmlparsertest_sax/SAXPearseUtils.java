package com.example.xmlparsertest_sax;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXPearseUtils {
	public static  List<Person> readXML(InputStream inStream) throws Exception{
		//获取实例
		SAXParserFactory spf = SAXParserFactory.newInstance();
		///创建解析器
		SAXParser sax = spf.newSAXParser();
		XMLContentHandler handler = new XMLContentHandler();
		sax.parse(inStream, handler);//开始解析
		inStream.close();
		return handler.getPersons();//返回解析出来的结果
		}
}
