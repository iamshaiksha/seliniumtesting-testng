package com.bridgelabz.seliniumtesting.notes;

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
 * @author Shaik Shaiksha vali
 *
 */
public class Note {
	private static ExtentTest test;
	/**
	 * 
	 * @param driver2 
	 * @throws InterruptedException
	 * Navigate to dashboard ,tap on note ,Enter title and description ,add colour
	 */

	public static void noteOperations(WebDriver driver) throws InterruptedException {
		String workingDir = System.getProperty("user.dir");
		ExtentReports report =ExtendManager.getReporter("Note");
		test=report.startTest("login test for correct fields");

		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("iamshaiksha2019@gmail.com");
		test.log(LogStatus.PASS,"email passed"); 
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Shaiksha@123");
		test.log(LogStatus.PASS,"password passed");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/mat-card/div[3]/button[1]/span")).click();
		test.log(LogStatus.PASS,"login successfull");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='noteclick ']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.PASS,"performing note operation");
		driver.findElement(By.xpath("//textarea[@id='title']")).click();
		driver.findElement(By.xpath("//textarea[@id='title']")).sendKeys("cucumber testcase passed");
		driver.findElement(By.xpath("//textarea[@id='description']")).click();
		test.log(LogStatus.PASS,"created succesfully");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("selenieum testcase passed");
		Thread.sleep(5000);
		driver.findElement(By.name("tapnote")).click();
		report.endTest(test);
		report.flush();

		/**
		 * Setting color to note
		 */

		//			driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/mat-sidenav-container/mat-sidenav-content/app-note/app-note-com/div/div[10]/div/span/mat-card/form/address/div[2]/app-icon/div[1]/button[3]/span/mat-icon")).click();
		//			Thread.sleep(5000);
		//			driver.findElement(By.id("//button[@id='colorsetting']")).click();
//		Thread.sleep(5000);
//		/**
//		 * Archeving notes
//		 */
//		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/mat-sidenav-container/mat-sidenav-content/app-note/app-note-com/div/div[8]/div/span/mat-card/form/address/div[2]/app-icon/div[1]/button[5]/span/mat-icon")).click();
//		Thread.sleep(5000);
		//		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/mat-sidenav-container/mat-sidenav-content/app-note/app-note-com/div/div[10]/div/span/mat-card/form/address/div[2]/app-icon/div[1]/button[6]/span/mat-icon")).click();
		//		Thread.sleep(5000);
		//		driver.findElement(By.id("trashsend")).click();
	}
}