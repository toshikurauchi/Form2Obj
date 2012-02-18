package br.com.sapereAude.form2Obj;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import br.com.sapereAude.form2Obj.utils.ResourcesUtils;

public class ToForm {

	private FormFields formFields = new FormFields();
	private ResourcesUtils resourcesUtils;

	public ToForm(Resources res) {
		resourcesUtils = new ResourcesUtils(res);
	}

	public void toForm(Object object, ViewGroup formParent) {
		toForm(object, formParent, "");
	}

	public void toForm(Object object, ViewGroup formParent, String prefix) {
		storeEditTextsById(formParent, prefix);
		formFields.setFieldFromObject(object);
	}
	
	private void storeEditTextsById(ViewGroup viewGroup, String prefix) {
		for(int i = 0; i < viewGroup.getChildCount(); i++) {
			View view = viewGroup.getChildAt(i);
			if(view instanceof EditText) {
				EditText editText = (EditText) view;
				formFields.put(resourcesUtils.findNames(prefix, editText.getId()), editText);
			}
		}
	}
}
