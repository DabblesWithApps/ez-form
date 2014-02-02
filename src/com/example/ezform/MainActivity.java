package com.example.ezform;

import ez.form.sample.FoodFormExample;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Create the custom form.
		FoodFormExample fs = new FoodFormExample(this);
		
		// Get the root view.
		ViewGroup layout = (ViewGroup) findViewById(android.R.id.content);
		
		// Append the form to the root view.
		layout.addView(fs.createForm());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
