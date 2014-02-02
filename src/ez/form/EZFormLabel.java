package ez.form;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

public class EZFormLabel extends EZFormElement {

	public EZFormLabel(String text, Context context) {
		super(EZFormElement.ELEMENT_TYPE_LABEL, text, context);
	}
	
	public EZFormLabel(int type, String text, Context context, LayoutParams lp) {
		super(type, text, context, lp);
	}

}
