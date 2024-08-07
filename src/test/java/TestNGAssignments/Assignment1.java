package TestNGAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment1 {
	/*
	 * Assignment -1(TestNG): ➤url : https://demo.guru99.com/test/login.html ➤ Using
	 * TestNG Annotaions to complete this assignment ➤ In Before test annotation
	 * must have the initialize the drivers ➤ In Test annotation we have to enter
	 * the username and password ➤ In After annotation must have the close() to
	 * close the application
	 */

	WebDriver chromeDriver;
	
	
@BeforeTest
	public void initializeDriver() throws InterruptedException {
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://demo.guru99.com/test/login.html");
		Thread.sleep(2000);
	}

	@Test
	public void login() throws InterruptedException {
		chromeDriver.findElement(By.id("email")).sendKeys("test@example.com");
		chromeDriver.findElement(By.id("passwd")).sendKeys("Test@123");
		chromeDriver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(2000);
	}
	
@AfterTest
	public void closeWindow() {
		chromeDriver.close();
	}
}
