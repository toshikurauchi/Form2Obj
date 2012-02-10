package br.com.sapereAude.form2Obj.example;

public class Address {
	private int number;
	private String street;
	private String city;
	
	public void setNumber(int number) {
		this.number = number;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return street + " - " + number + " - " + city;
	}
}
