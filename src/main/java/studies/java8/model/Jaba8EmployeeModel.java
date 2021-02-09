package studies.java8.model;

import studies.java8.features.Java8DefaultMethods;

public class Jaba8EmployeeModel implements Java8DefaultMethods {
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
