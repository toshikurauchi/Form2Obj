package br.com.sapereAude.form2Obj.example;

public class Contact {
	private String name;
	private String phone;
	private int age;
	
	@Override
	public String toString() {
		return name + " - " + phone + " - " + age;
	}
}
