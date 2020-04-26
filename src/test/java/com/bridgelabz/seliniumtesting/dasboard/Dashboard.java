package com.bridgelabz.seliniumtesting.dasboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bridgelabz.seliniumtesting.utility.ExtendManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
/**
 * 
 * @author Shaik shaiksha vali
 *
 */
public class Dashboard {
private static ExtentTest test;
public static void dashboardOperations(WebDriver driver)
{
	ExtentReports report =ExtendManager.getReporter("dashboard");
	driver.get("localhost:4200/login");
	driver.manage().window().maximize();
	test=report.startTest("login test for correct values");
	test.log(LogStatus.PASS,"peroforming the assertions");
	driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("iamshaiksha2019@gmail.com");
	 driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Shaiksha@123");
	 test.log(LogStatus.PASS, "peroforming the submit action");
	 driver.findElement(By.xpath("/html/body/app-root/app-login/div/mat-card/div[3]/button[1]/span")).click();
	 test.log(LogStatus.PASS,"test pass");
	 try{
			Thread.sleep(5000);
		}catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		 driver.findElement(By.xpath(("/html/body/app-root/app-dashboard/div/div[1]/mat-toolbar/mat-toolbar-row/button/span/mat-icon"))).click();
		 test.log(LogStatus.PASS,"Main Menu");
		 try{
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/mat-sidenav-container/mat-sidenav/div/div[1]/button[1]/span/span")).click();
		test.log(LogStatus.PASS,"gett all notes test passed");
		/**
		 * Dashboard onArchevied getting all archeivedNotes testing
		 */
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/mat-sidenav-container/mat-sidenav/div/div[3]/button[1]/span/span")).click();
		test.log(LogStatus.PASS,"gett all archieved test passed");
		/**
		 * Dashboard on trash getting all trashNotes testing
		 */
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("trash")).click();
		test.log(LogStatus.PASS,"gett all trashnotes  test passed");
		report.endTest(test);
		report.flush();
}
}
