package com.SFDC.pages;

import com.CC.test.BaseClass;

public class LoginPage extends BaseClass {
	
	public void Login() throws Exception
	{
		driver.get(getObject("CC_URL"));
	}

}
