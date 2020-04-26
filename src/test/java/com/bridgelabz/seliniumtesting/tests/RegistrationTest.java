package com.bridgelabz.seliniumtesting.tests;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bridgelabz.seliniumtesting.user.Registration;
/**
 * 
 * @author Shaik shaikshavali
 *
 */
public class RegistrationTest {

	private WebDriver driver;
	@BeforeTest
	public void startBrowser()
	{

		System.setProperty("webdriver.chrome.driver", "C:/Users/rahi/Downloads/chromedriver_win32 (1)/chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();;
		driver.get("localhost:4200");
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Fundoonotes"))
		{
			System.out.println("title :"+title);
		}
		else
		{
			System.out.println(" plzz check your url");
		}
	}
	@Test
	public void register() throws IOException, InterruptedException
	{
		Registration.register(driver);
	}
	public void browserClose()
	{
		driver.close();
	}
}
