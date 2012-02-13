package br.com.sapereAude.form2Obj;

import android.content.res.Resources;
import android.view.ViewGroup;

public class Form2Obj {
	private ToObj form;

	public Form2Obj(Resources res) {
		form = new ToObj(res);
	}
	
	public void toObj(ViewGroup formParent, Object toObj) {
		form.toObj(formParent, toObj);
	}
	
	public void toObj(ViewGroup formParent, Object toObj, String prefix) {
		form.toObj(formParent, toObj, prefix);
	}
}
