package br.com.sapereAude.form2Obj;

import java.lang.reflect.Field;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.EditText;

public class Form2Obj {
	private Resources res;

	public Form2Obj(Resources res) {
		this.res = res;
	}
	
	public void assign(ViewGroup formParent, Object toObj) {
		assign(formParent, toObj, "");
	}
	
	public void assign(ViewGroup formParent, Object toObj, String prefix) {
		for (int i = 0; i < formParent.getChildCount(); i++) {
			if(formParent.getChildAt(i) instanceof EditText) {
				EditText campo = (EditText) formParent.getChildAt(i);
				try {
					Field field = toObj.getClass().getDeclaredField(findName(prefix, campo.getId()));
					field.setAccessible(true);
					field.set(toObj, campo.getEditableText().toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private String findName(String prefix, int id) {
		String fullName = res.getResourceName(id);
		int index = fullName.lastIndexOf('/' + prefix) + 1 + prefix.length();
		if(index < fullName.length()) {
			return fullName.substring(index);
		}
		return null;
	}
}
