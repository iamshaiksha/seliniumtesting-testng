package com.bridgelabz.seliniumtesting.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author Shaik shaikshavali
 *
 */
public class RobertTest {

	 public WebDriver driver;
	    public WebDriverWait wait;
	    private static String filePath = System.getProperty("user.dir") + "\\indianarmy.jpg";
	 
	    @BeforeMethod
	    public void setup () {
	    	System.setProperty("webdriver.chrome.driver", "C:/Users/rahi/Downloads/chromedriver_win32 (1)/chromedriver.exe"); 
	        driver = new ChromeDriver();
	        driver.navigate().to("localhost:4200/login");
	        driver.manage().window().maximize();
			WebElement email=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			email.sendKeys("iamshaiksha2019@gmail.com");
			WebElement password=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			password.sendKeys("Shaiksha@123");
			driver.findElement(By.xpath("/html/body/app-root/app-login/div/mat-card/div[3]/button[1]/span")).click();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	        wait = new WebDriverWait(driver,10);
	        
	    }
	 
	    @Test
	    public void robotTest () throws InterruptedException {
	        //Click Image Upload
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-dashboard/div/div[1]/mat-toolbar/mat-toolbar-row/div[4]/button[4]/span/img")));
	        driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div[1]/mat-toolbar/mat-toolbar-row/div[4]/button[4]/span/img")).click();
	        
	        Thread.sleep(10000);
	        wait.until(ExpectedConditions.elementToBeClickable(By.name("imo")));
	        driver.findElement(By.name("imo")).click();
	        uploadFileWithRobot(filePath);
	        Thread.sleep(2000);
	    }
	 
	    @AfterMethod
	    public void teardown () {
	        driver.quit();
	    }
	 
	    //File upload by Robot Class
	    public void uploadFileWithRobot (String imagePath) {
	    	driver.findElement(By.xpath("//input[@id='mat-tab-content-0-0']/div/div/span[4]/form/input")).click();
	        StringSelection stringSelection = new StringSelection(imagePath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	 
	        Robot robot = null;
	 
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	 
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	}