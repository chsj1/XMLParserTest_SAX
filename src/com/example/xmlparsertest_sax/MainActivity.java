package com.example.xmlparsertest_sax;

import java.io.InputStream;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		InputStream xml = this.getClass().getClassLoader()
				.getResourceAsStream("persons.xml");
		List<Person> persons;
		try {
			persons = SAXPearseUtils.readXML(xml);
			
			for(Person person : persons){
				System.out.println(person);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
