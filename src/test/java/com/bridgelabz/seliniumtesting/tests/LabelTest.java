package com.bridgelabz.seliniumtesting.tests;

import org.testng.annotations.Test;

import com.bridgelabz.seliniumtesting.label.Labels;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
/**
 * 
 * @author Shaik shaikshavali
 *
 */
public class LabelTest {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/rahi/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("localhost:4200/login");
		driver.manage().window().maximize();
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
	public void labels() {
		Labels.labelOperations(driver);
	}


	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
