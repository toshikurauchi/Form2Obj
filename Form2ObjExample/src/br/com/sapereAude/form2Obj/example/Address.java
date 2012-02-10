package br.com.sapereAude.form2Obj.example;

public class Address {
	private int number;
	private String street;
	private String city;
	
	@Override
	public String toString() {
		return street + " - " + number + " - " + city;
	}
}
