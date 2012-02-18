package br.com.sapereAude.form2Obj;

public class ObjectUtil {
	public static Object valueOf(Class<?> type, String string) {
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

}
