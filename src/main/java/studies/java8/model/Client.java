package studies.java8.model;

import studies.java8.features.FunctionalInterfaces;

public class Client implements FunctionalInterfaces {
	String name;
	String username;
	String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean passwordAuthentication(String password) {
		if (this.password.equals(password)) {
			System.out.println("Autenticado.");
			return true;
		} 
		
		System.out.println("Não autenticado.");
		return false;
	}
	
	public void printName() {
		System.out.println(name);
	}
}
