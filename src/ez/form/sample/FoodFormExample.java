package ez.form.sample;

import java.util.List;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ezform.OtherActivity;

import ez.form.EZForm;
import ez.form.EZFormOnClickListener;
import ez.form.EZFormElement;

/*
 * To create a custom form extend the EZForm class.
 * Create the elements you want to add to your form (fields, buttons, labels).
 * You can use EZFormElement.getView() to get the views and edit them.
 * Use EZForm.getInputs() to retrieve a list of strings from the fields of
 * this form.
 */

public class FoodFormExample extends EZForm {

	@SuppressLint("NewApi")
	public FoodFormExample(Context context) {
		super(context);
		
		// Create a label.
		EZFormElement label = new EZFormElement(EZFormElement.ELEMENT_TYPE_LABEL, "Food Name:", context);
		
		// Get the labels view and edit it.
		TextView labelView = (TextView) label.getView();
		labelView.setTextAppearance(context, R.style.TextAppearance_Large);
		
		// Create a button.
		EZFormElement submit = new EZFormElement(EZFormElement.ELEMENT_TYPE_BUTTON, "SUBMIT", context);
		
		// Add elements to the form. Order matters!
		addFormElement(label);
		addFormElement(EZFormElement.ELEMENT_TYPE_FIELD, "");
		addFormElement(EZFormElement.ELEMENT_TYPE_LABEL, "Calories (g):");
		addFormElement(EZFormElement.ELEMENT_TYPE_FIELD, "");
		
		submit.getView().setOnClickListener(new EZFormOnClickListener(this, context) { 
			@Override
			public void onClick(View v) {
				
				// THIS TINY LITTLE SUBTLE LINE IS VBRY IMPORTANT!
				// ITS WHERE THE INPUT COMES FROM!
				List<String> inputs = getInputs();
				
				for(int i = 0; i < inputs.size(); i++) {
				    Log.d("TEST", inputs.get(i));	
				}
				
				// Since getContext() works im not sure if I should make another constructor
				// where you do not pass in the context.
				Intent intent = new Intent(getContext(), OtherActivity.class);
				getContext().startActivity(intent);
			}
		});
		
		addFormElement(submit);

	}

}
