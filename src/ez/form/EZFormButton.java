package ez.form;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

public class EZFormButton extends EZFormElement {
	public EZFormButton(String text, Context context) {
		super(EZFormElement.ELEMENT_TYPE_BUTTON, text, context);
	}
	
	public EZFormButton(int type, String text, Context context, LayoutParams lp) {
		super(type, text, context, lp);
	}
}
