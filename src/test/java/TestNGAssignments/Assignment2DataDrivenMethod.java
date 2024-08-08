/*Assignment -2(TestNG):
➤url : https://demo.guru99.com/test/login.html
➤ Using TestNG Annotaions to complete this assignment
➤ In Before test annotation must have the initialize the drivers
➤ In Test annotation we have to enter the username and password
➤ You need to take the data(username and password) from datadriven method
➤ In After annotation must have the close() to close the application*/

package TestNGAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment2DataDrivenMethod {
	WebDriver chromeDriver;

	@DataProvider(name = "loginDataSet")
	public Object[][] loginData() {

		Object[][] data = new Object[3][2];
		data[0][0] = "test1@example.com";
		data[0][1] = "Test1@123";
		data[1][0] = "test2@example.com";
		data[1][1] = "Test2@123";
		data[2][0] = "test3@example.com";
		data[2][1] = "Test3@123";
		return data;
	}

	@BeforeSuite
	public void initializeDriver() throws InterruptedException {
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://demo.guru99.com/test/login.html");
		Thread.sleep(2000);
	}

	@Test(dataProvider = "loginDataSet")
	public void login(String email, String password) throws InterruptedException {
		WebElement emailinput = chromeDriver.findElement(By.id("email"));
		emailinput.sendKeys(email);
		WebElement passwordinput = chromeDriver.findElement(By.id("passwd"));
		passwordinput.sendKeys(password);
		chromeDriver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(2000);
		chromeDriver.navigate().back();
		emailinput.clear();
		passwordinput.clear();
	}

	@AfterSuite
	public void closeWindow() {
		chromeDriver.close();
	}
}