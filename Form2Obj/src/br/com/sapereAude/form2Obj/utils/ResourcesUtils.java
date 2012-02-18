package br.com.sapereAude.form2Obj.utils;

import android.content.res.Resources;

public class ResourcesUtils {
	private final Resources res;

	public ResourcesUtils(Resources res) {
		this.res = res;
	}

	public String[] findNames(String prefix, int id) {
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
