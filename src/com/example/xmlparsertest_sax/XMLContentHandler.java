package com.example.xmlparsertest_sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLContentHandler extends DefaultHandler {
	// ��Ա��Ϣ
	private List<Person> persons;
	// ��
	private Person person;
	// ���
	private String perTag;
	//����Ԫ�ص��ַ����ݣ��Ӳ����п��Ի������
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
	//����Ԫ�ؽ����¼����Ӳ����п��Ի��Ԫ���������ƿռ��uri��Ԫ�����Ƶ���Ϣ
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		if ("person".equals(localName) && person != null) {
			persons.add(person);
			person = null;
		}
		perTag = null;
	}
	//���ڴ����ĵ�������ʼ�¼�
	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
	}
	//����Ԫ�ؿ�ʼ�¼����Ӳ����п��Ի��Ԫ���������ƿռ��uri��Ԫ�����ƣ�����������Ϣ
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
