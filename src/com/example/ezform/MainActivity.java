package com.example.ezform;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import ez.form.EZForm;
import ez.form.EZFormOnClickListener;
import ez.form.EZFormElement;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*
		 * 
		 *  Using a standard EZForm object.
		 *  
		 */
		
		// Insantiate ezform object.
		EZForm ezform = new EZForm(this);
		
		// Create the elements you want.
		EZFormElement label1 = new EZFormElement(EZFormElement.ELEMENT_TYPE_LABEL, "My 1st label:", this);
		EZFormElement field1 = new EZFormElement(EZFormElement.ELEMENT_TYPE_FIELD, null, this);
		EZFormElement button1 = new EZFormElement(EZFormElement.ELEMENT_TYPE_BUTTON, "My 1st button:", this);

		// Attach the form elements to the form (ORDER MATTERS!).
		ezform.addFormElement(label1);
		ezform.addFormElement(field1);
		ezform.addFormElement(button1);
		
		// Get the viewgroup from the current layout that you want to attach the form to.
		// In this example we use the root of the view itself.
		ViewGroup layout = (ViewGroup) findViewById(android.R.id.content);
		
		// Append the form to the of your choice view.
		layout.addView(ezform.createForm());
		
		/*
		 * 
		 *  Responding to form submission
		 *  
		 */
		
		// Get the view from the element.
		View btnView = button1.getView();
		
		// Assign the OnClickListener.
		btnView.setOnClickListener(new EZFormOnClickListener(ezform, this) {

			@Override
			public void onClick(View v) {
				
				List<String> inputs = mParentForm.getInputs();
				for(int i = 0; i < inputs.size(); i++) {
				    Log.d("TEST", inputs.get(i));	
				}
				
				Intent intent = new Intent(mContext, OtherActivity.class);
				startActivity(intent);
				
			}
			
		});
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
