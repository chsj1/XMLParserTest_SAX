package com.example.xmlparsertest_sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLContentHandler extends DefaultHandler {
	// 人员信息
	private List<Person> persons;
	// 人
	private Person person;
	// 标记
	private String perTag;
	//处理元素的字符内容，从参数中可以获得内容
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (person != null) {
			String data = new String(ch, start, length);
			if ("name".equals(perTag)) {
				person.setName(data);
			} else if ("age".equals(perTag)) {
				person.setAge(new Short(data));
			}
		}
	}
	public List<Person> getPersons() {
		return persons;
	}
	//处理元素结束事件，从参数中可以获得元素所在名称空间的uri，元素名称等信息
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		if ("person".equals(localName) && person != null) {
			persons.add(person);
			person = null;
		}
		perTag = null;
	}
	//用于处理文档解析开始事件
	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
	}
	//处理元素开始事件，从参数中可以获得元素所在名称空间的uri，元素名称，属性类表等信息
	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		if ("person".equals(localName)) {
			person = new Person();
			person.setId(new Integer(attributes.getValue(0)));
		}
		perTag = localName;
	}
}
