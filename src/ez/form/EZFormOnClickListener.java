package ez.form;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class EZFormOnClickListener implements OnClickListener {

	protected EZForm mParentForm;
	protected Context mContext;
	
	public EZFormOnClickListener(EZForm parentForm, Context context) {
		mParentForm = parentForm;
		mContext = context;
	}
	
	@Override
	public void onClick(View v) {
		
	}

}
