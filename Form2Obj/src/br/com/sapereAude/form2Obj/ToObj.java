package br.com.sapereAude.form2Obj;

import java.lang.reflect.Field;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.EditText;
import br.com.sapereAude.form2Obj.utils.ResourcesUtils;

public class ToObj {

	private Resources res;
	private ResourcesUtils resourcesUtils;

	public ToObj(Resources res) {
		this.res = res;
		resourcesUtils = new ResourcesUtils(res);
	}

	public void toObj(ViewGroup formParent, Object toObj) {
		toObj(formParent, toObj, "");		
	}

	public void toObj(ViewGroup formParent, Object toObj, String prefix) {
		for (int i = 0; i < formParent.getChildCount(); i++) {
			if(formParent.getChildAt(i) instanceof EditText) {
				EditText editText = (EditText) formParent.getChildAt(i);
				setFieldRecursively(toObj, resourcesUtils.findNames(prefix, editText.getId()), 0, editText.getEditableText().toString());
			}
		}
	}
	
	private void setFieldRecursively(Object obj, String[] fieldNames, int position, String fieldValue) {
		try {
			Field field = obj.getClass().getDeclaredField(fieldNames[position]);
			field.setAccessible(true);
			Object value;
			if(position < fieldNames.length - 1) {
				value = field.get(obj);
				if(value == null) {
					value = field.getType().newInstance();
				}
				setFieldRecursively(value, fieldNames, position + 1, fieldValue);
			}
			else {
				value = ObjectUtil.valueOf(field.getType(), fieldValue);
			}
			field.set(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
