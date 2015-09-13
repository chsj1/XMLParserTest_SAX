package com.example.xmlparsertest_sax;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXPearseUtils {
	public static  List<Person> readXML(InputStream inStream) throws Exception{
		//��ȡʵ��
		SAXParserFactory spf = SAXParserFactory.newInstance();
		///����������
		SAXParser sax = spf.newSAXParser();
		XMLContentHandler handler = new XMLContentHandler();
		sax.parse(inStream, handler);//��ʼ����
		inStream.close();
		return handler.getPersons();//���ؽ��������Ľ��
		}
}
