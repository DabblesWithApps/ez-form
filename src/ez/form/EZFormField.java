package ez.form;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

public class EZFormField extends EZFormElement {
	public EZFormField(String text, Context context) {
		super(EZFormElement.ELEMENT_TYPE_FIELD, text, context);
	}
	
	public EZFormField(int type, String text, Context context, LayoutParams lp) {
		super(type, text, context, lp);
	}
}
