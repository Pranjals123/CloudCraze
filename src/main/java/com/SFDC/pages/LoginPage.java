package com.SFDC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CC.test.BaseClass;
import com.CC.test.ReadExcel;

public class LoginPage extends BaseClass {
	
	//@FindBy(xpath = "//input[@id='username']")
    private WebElement username;
	
	public void Login() throws Exception
	{
		ReadExcel readexcl = new ReadExcel("Credentials");
		driver.get(getObject("URL"));	
		username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(readexcl.ReadExcel("Credentials", "Username", 1));
	}

	
}
