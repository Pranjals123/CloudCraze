package com.CC.test;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;


public class BaseClass {



public static WebDriver driver; 
static Properties properties;
	
	 public static void loadfile() throws Exception
	    {
	    	properties  = new Properties();
			File f = new File(System.getProperty("user.dir")+"\\Object.properties");
			FileReader obj = new FileReader(f);
			properties.load(obj); 
			
			File f2 = new File(System.getProperty("user.dir")+"\\Cred.properties");
			FileReader obj2 = new FileReader(f2);
			properties.load(obj2); 
	    		
	    }
	    public static String getObject(String readdata) throws Exception
	    {
	    	loadfile();
	    	String data = properties.getProperty(readdata);
	    	return data;
	    }
	    
	    @BeforeClass(alwaysRun = true)
	    public void beforeclass() throws Exception
	    {
	    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	    	//System.setProperty("testng.show.stack.frames", "false");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//Thread.sleep(3000);
			//test = extent.createTest(getClass().getSimpleName());
			//driver.get(getObject("URL"));
	    }
	    
	    public void ImplicitWait(long seconds)
        {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        }
	    
        public void ExplicitWait(long seconds, WebElement element)
        {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            
        }
        
       /* public void dropDown(String dropdownButton, String text) throws Exception
        {
                
                Select s = new Select(driver.findElement(By.xpath(dropdownButton)));
                Thread.sleep(2000);
        		s.selectByVisibleText(text);
        		Thread.sleep(2000);
            
        }*/
        
        public void dropDown(WebElement dropdownButton, String value) throws Exception
        {
            //Check whether the dropdown is displayed or not
            if (dropdownButton.isDisplayed())
            {
                dropdownButton.click();
                Thread.sleep(2000);
                //Gets all the values present in dropdown 
                List<WebElement> optionToSelect = driver.findElements(By.tagName("li"));
                for (int i = 0; i < optionToSelect.size(); i++)
                {
                    if (optionToSelect.get(i).equals(value))
                    {
                    	optionToSelect.get(i).click();
                        break;
                    }
                }
            }
        }
        
       
}
