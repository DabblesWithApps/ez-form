ez-form
=======

For me, making forms with Android is extremely annoying. This library is to make it easier.

==========
V1
==========
Example of Most Simple Use:

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
