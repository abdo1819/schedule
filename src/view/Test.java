package view;

import javax.annotation.PostConstruct;

public class Test {

	 private String test;
	 
	 @PostConstruct
	 public void init() {
		 this.setTest("hello");
	 }
	 
	 
	 
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	 
	
	
}
