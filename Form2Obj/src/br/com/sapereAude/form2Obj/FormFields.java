package br.com.sapereAude.form2Obj;

import java.lang.reflect.Field;
import java.util.HashMap;

import android.widget.EditText;

public class FormFields {
	private HashMap<String, FormFields> fields;
	private EditText editText;

	public FormFields() {
		fields = new HashMap<String, FormFields>();
	}

	public FormFields(EditText editText) {
		this.editText = editText;
	}

	public void put(String[] fieldNames, EditText editText) {
		put(fieldNames, editText, 0);
	}

	private void put(String[] fieldNames, EditText editText, int index) {
		if(index >= fieldNames.length) {
			return;
		}
		if(index == fieldNames.length - 1) {
			fields.put(fieldNames[index], new FormFields(editText));
			return;
		}
		String fieldName = fieldNames[index];
		FormFields formFields = fields.get(fieldName);
		if(formFields == null) {
			formFields = new FormFields();
			fields.put(fieldName, formFields);
		}
		formFields.put(fieldNames, editText, index+1);
	}
	
	public boolean isEditText() {
		return this.editText != null;
	}
	
	public EditText getEditText() {
		return editText;
	}

	public void setFieldFromObject(Object object) {
		for(Field field : object.getClass().getDeclaredFields()) {
			setFieldFromObject(field, object);
		}
	}
	
	private void setFieldFromObject(Field field, Object object) {
		field.setAccessible(true);
		Object value = null;
		try {
			value = field.get(object);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if(value == null) {
			return;
		}
		String fieldName = field.getName();
		FormFields formFields = fields.get(fieldName);
		if(formFields != null) {
			if(formFields.isEditText()) {
				formFields.getEditText().setText(value.toString());
			}
			else {
				formFields.setFieldFromObject(value);
			}
		}
	}
}
