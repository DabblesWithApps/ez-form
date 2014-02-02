package ez.form;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EZFormElement {
	protected int mType;
	protected String mText;
	protected Context mContext;
	protected LayoutParams mLayoutParams = null;
	protected View mView;
	
	public static final int ELEMENT_TYPE_LABEL = 0;
	public static final int ELEMENT_TYPE_FIELD = 1;
	public static final int ELEMENT_TYPE_BUTTON = 2;
	
	public int getType() {
		return mType;
	}
	
	public EZFormElement(int type, String text, Context context) {
	    mType = type;
	    mText = text;
	    mContext = context;
	    
	    mView = createView();
	}

	public EZFormElement(int type, String text, Context context, LayoutParams lp) {
	    mType = type;
	    mText = text;
	    mContext = context;
	    mLayoutParams = lp;
	    
	    mView = createView();
	}
	
	public void setLayoutParams(LayoutParams lp) {
		mLayoutParams = lp;
		mView.setLayoutParams(lp);
	}
	
	public View getView() {
		return mView;
	}
	
	// Assumes text, type, and context are not null.
	private View createView() {
		View view = null;
		
		switch (mType) {
		case ELEMENT_TYPE_LABEL:
			TextView te = new TextView(mContext);
			te.setText(mText);
			view = te;
			break;
		case ELEMENT_TYPE_FIELD:
			EditText et = new EditText(mContext);
			et.setText(mText);
			view = et;
			break;
		case ELEMENT_TYPE_BUTTON:
			Button btn = new Button(mContext);
			btn.setText(mText);
			view = btn;
			break;
		}
		
		if(mLayoutParams != null) {
			view.setLayoutParams(mLayoutParams);
		}
		
		return view;
	}
	
}
