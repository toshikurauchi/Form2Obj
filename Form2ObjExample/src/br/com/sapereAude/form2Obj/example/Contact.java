package br.com.sapereAude.form2Obj.example;

public class Contact {
	private String name;
	private String phone;
	private int age;
	
	private Address address;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return name + " - " + phone + " - " + age + " - " + address.toString();
	}
}
