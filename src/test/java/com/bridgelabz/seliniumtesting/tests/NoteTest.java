package com.bridgelabz.seliniumtesting.tests;

import org.testng.annotations.Test;

import com.bridgelabz.seliniumtesting.notes.Note;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NoteTest {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/rahi/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("localhost:4200/login");
		driver.manage().window().maximize();
		
	}
	@Test
	public void note() throws InterruptedException
	{
		Note.noteOperations(driver);
	}


	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
