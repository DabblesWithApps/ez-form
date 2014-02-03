package ez.form;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


// Inherit this class to make an EZ form.
public class EZForm {

    protected List<EZFormElement> mElements;	
    protected LinearLayout mLayout;
    protected Context mContext;
	
	public EZForm(Context context) {
		mContext = context;
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		
		mLayout = new LinearLayout(context);
		mLayout.setOrientation(LinearLayout.VERTICAL);
    	mElements = new ArrayList<EZFormElement>();
    }
	
	public Context getContext() {
		return mContext;
	}
	
	public void addFormElement(EZFormElement element) {
		mElements.add(element);
	}
	
	public void addFormElement(int type, String text) {
		EZFormElement element = new EZFormElement(type, text, mContext);
		mElements.add(element);
	}
    
    public LinearLayout createForm() {
    	mLayout.removeAllViews();
    	
    	for(int i = 0; i < mElements.size(); i++) {
    		View view = mElements.get(i).getView();
    		mLayout.addView(view);
    	}
    	
    	return mLayout;
    }
    
    public List<String> getInputs() {
    	List<String> inputs = new ArrayList<String>();
    	
    	for(int i = 0; i < mElements.size(); i++) {
    	    if(mElements.get(i).getType() == EZFormElement.ELEMENT_TYPE_FIELD) {
        	    String input = "";
        	    EditText et = (EditText) mElements.get(i).getView();
        	    inputs.add(et.getText().toString());
    	    }
    	}
    	
		return inputs;
    }
    
    
}
