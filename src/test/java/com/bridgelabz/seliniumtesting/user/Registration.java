package com.bridgelabz.seliniumtesting.user;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
 * @author Shaik Shaiksha vali
 *
 */
public class Registration {
	private static ExtentTest test;
	static int c=0;
	public static void register(WebDriver driver) throws IOException, InterruptedException
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/rahi/Downloads/chromedriver_win32 (1)/chromedriver.exe"); 
		 driver=new ChromeDriver();
		String workingDir = System.getProperty("user.dir");
		ExtentReports report =ExtendManager.getReporter("register"); 
				BufferedReader reader = new BufferedReader(new FileReader(workingDir + "\\ExcelSheet\\ExcelSheet.csv"));
		String line;
		reader.readLine();
		while ((line = reader.readLine()) != null) {
		      String[] data = line.split(",");
			   System.out.print(data[0]);
			   System.out.print(" ");
			   System.out.print(data[1]);
			   System.out.print(" ");
			   System.out.print(data[2]);
			   System.out.println(" ");
			   System.out.println(data[3]);
			   driver.get("localhost:4200/register");
			   Thread.sleep(5000);
			   driver.manage().window().maximize();
//			   	test.log(LogStatus.INFO, "starting the test");
			 	String title=driver.getTitle();
			    System.out.println("The title is--->"+title);
			    String currenturl= driver.getCurrentUrl();
			    System.out.println("The title is--->"+currenturl);
			    if(title.equalsIgnoreCase("Fundoonotes"))
			    {	
		    		test=report.startTest("Registration test for correct values");
			    	WebElement name=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			    	name.sendKeys(data[0]);
			    	test.log(LogStatus.PASS,"peroforming the assertions");
			    	WebElement email=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			    	email.sendKeys(data[1]);
			    	WebElement password= driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			    	password.sendKeys(data[2]);
//					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					WebElement mobileNumber= driver.findElement(By.xpath("//input[@id='mat-input-3']"));
			    	mobileNumber.clear();
//			    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					mobileNumber.sendKeys(data[3]);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.log(LogStatus.PASS, "peroforming the submit action");
					driver.findElement(By.xpath("/html/body/app-root/app-registration/div/mat-card/div[5]/button[1]/span")).click();
					test.log(LogStatus.PASS,"test pass");
					report.endTest(test);
					report.flush();
			    }
			    			 
			   
		        
		}
	}
	}

