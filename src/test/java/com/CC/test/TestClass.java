package com.CC.test;

import org.testng.annotations.Test;

import com.SFDC.pages.LoginPage;

public class TestClass extends LoginPage {

	@Test
	public void login() throws Exception{
		
		Login();
	}
}
