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
				EditText editText = (EditText) formParent.getChildAt(i);
				setFieldRecursively(toObj, findNames(prefix, editText.getId()), 0, editText.getEditableText().toString());
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
				value = valueOf(field.getType(), fieldValue);
			}
			field.set(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object valueOf(Class<?> type, String string) {
		if(type.equals(Integer.class) || type.equals(int.class)) {
			return Integer.valueOf(string);
		}
		if(type.equals(Float.class) || type.equals(float.class)) {
			return Float.valueOf(string);
		}
		if(type.equals(Double.class) || type.equals(double.class)) {
			return Double.valueOf(string);
		}
		if(type.equals(Short.class) || type.equals(short.class)) {
			return Short.valueOf(string);
		}
		if(type.equals(Byte.class) || type.equals(byte.class)) {
			return Byte.valueOf(string);
		}
		if(type.equals(Long.class) || type.equals(long.class)) {
			return Long.valueOf(string);
		}
		if(type.equals(Boolean.class) || type.equals(boolean.class)) {
			return Boolean.valueOf(string);
		}
		if(type.equals(Character.class) || type.equals(char.class)) {
			if(string.length() > 0) {
				return Character.valueOf(string.charAt(0));
			}
		}
		return string;
	}

	private String[] findNames(String prefix, int id) {
		String fullName = res.getResourceName(id);
		int index = fullName.lastIndexOf('/' + getPrefix(prefix)) + 1 + prefix.length();
		if(index < fullName.length()) {
			return fullName.substring(index).split("_");
		}
		return null;
	}

	private String getPrefix(String prefix) {
		if(prefix == null || prefix.equals("")) {
			return "";
		}
		return prefix + "_";
	}
}
