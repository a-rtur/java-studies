package studies.java8.model;

import studies.java8.features.default_methods.DefaultMethods;

public class Employee implements DefaultMethods {
	String name;
	String code;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
