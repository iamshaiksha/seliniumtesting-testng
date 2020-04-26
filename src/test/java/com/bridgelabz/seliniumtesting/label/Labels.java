package com.bridgelabz.seliniumtesting.label;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bridgelabz.seliniumtesting.utility.ExtendManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
/**
 * 
 * @author Shaik shaikshavali
 *
 */
public class Labels {
	private static ExtentTest test;
	public static void labelOperations(WebDriver driver)
	{
		ExtentReports report =ExtendManager.getReporter("label");
		test=report.startTest("login test for correct values");
		driver.get("localhost:4200/login");
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "peroforming the assertions");
		WebElement email=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		email.sendKeys("iamshaiksha2019@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		password.sendKeys("Shaiksha@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/mat-card/div[3]/button[1]/span")).click();
		test.log(LogStatus.PASS, "peroforming the submit action");
		test.log(LogStatus.PASS, "login sucsess");
		try{
			Thread.sleep(5000);
		}catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(("/html/body/app-root/app-dashboard/div/div[1]/mat-toolbar/mat-toolbar-row/button/span/mat-icon"))).click();
		test.log(LogStatus.PASS, "MainMenu");
		try{
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("editlabel")).click();
		test.log(LogStatus.PASS, "peroforming the label operation");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement label=driver.findElement(By.id("edit"));
		label.sendKeys("cucumber");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("done")).click();

		test.log(LogStatus.PASS, "peroforming the submit action");
		report.endTest(test);
		report.flush();

	}
}
