For me, making forms with Android is extremely annoying. This library is to make it easier.  

# V1  
## Example of Most Simple Use (Inside of OnCreate method of Activity Class)

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
		
## Responding to Form Submission

		/*
		 * 
		 *  Responding to form submission
		 *  
		 */

		// Get the view from the element.
		View btnView = button1.getView();
		
		// Assign the OnClickListener.
		btnView.setOnClickListener(new EZFormClickListener(ezform, this) {

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
		
## Extending the EZFormClass (1 of 2)
 * To create a custom form extend the EZForm class.
 * Create the elements you want to add to your form (fields, buttons, labels).
 * You can use EZFormElement.getView() to get the views and edit them.
 * Use EZForm.getInputs() to retrieve a list of strings from the fields of this form.

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
				
				submit.getView().setOnClickListener(new EZFormClickListener(this, context) { 
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


## Extending the EZFormClass (2 of 2)

Comming soon.  
