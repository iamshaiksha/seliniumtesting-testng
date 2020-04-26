package com.bridgelabz.seliniumtesting.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
public class Login {
	private static ExtentTest test;
	public static void login(WebDriver driver) {
		ExtentReports report =ExtendManager.getReporter("Login");
//		System.setProperty("webdriver.chrome.driver", "C:/Users/rahi/Downloads/chromedriver_win32 (1)/chromedriver.exe"); 
//		WebDriver driver=new ChromeDriver();
		driver.get("localhost:4200/login");
		driver.manage().window().maximize();
		test=report.startTest("login test for correct values");
		test.log(LogStatus.PASS,"peroforming the assertions");
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("iamshaiksha2019@gmail.com");
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Shaiksha@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/mat-card/div[3]/button[1]/span")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		test.log(LogStatus.PASS,"submit");
		test.log(LogStatus.PASS,"login success");
		report.endTest(test);
		report.flush();
	}
}
