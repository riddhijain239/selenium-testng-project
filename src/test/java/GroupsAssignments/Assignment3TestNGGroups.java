package GroupsAssignments;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*Assignment -3(TestNG):
➤url : https://demoqa.com/
➤ Click on  Forms
➤ Click on Practise Form
➤ Make above two actions in group as smoke test
➤ Then fill the entire form group name will be regression 
➤ Enter Submit*/

public class Assignment3TestNGGroups {

	WebDriver chromeDriver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void setUp() {
		chromeDriver = new ChromeDriver();
		js = (JavascriptExecutor) chromeDriver;
		chromeDriver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser() {
		chromeDriver.quit();
	}
		
	@Test(groups = "SmokeTest")
	public void openFormPage() {
		chromeDriver.get("https://demoqa.com/");
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js.executeScript("window.scrollBy(0,350)");
	
		chromeDriver.findElement(By.xpath("//h5[text()='Forms']")).click();
		chromeDriver.findElement(By.xpath("//span[text()='Practice Form']")).click();
		
		String practiceForm = chromeDriver.findElement(By.xpath("//div[@id='app']/descendant::h1[1]")).getText();
		Assert.assertEquals(practiceForm, "Practice Form");
	}
	
	@Test(groups = "RegressionTest", dependsOnGroups = "SmokeTest")
	public void formCreation() {
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		js.executeScript("window.scrollBy(0,350)");
		
		chromeDriver.findElement(By.id("firstName")).sendKeys("Riddhi");
		chromeDriver.findElement(By.id("lastName")).sendKeys("Jain");
		chromeDriver.findElement(By.id("userEmail")).sendKeys("test@example.com");

		chromeDriver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
		chromeDriver.findElement(By.id("userNumber")).sendKeys("9012345678");
		chromeDriver.findElement(By.id("currentAddress")).sendKeys("Abc Flat number 123, Hyderabad 500019");

		chromeDriver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
		chromeDriver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();

		WebElement subjects = chromeDriver.findElement(By.id("subjectsInput"));
		subjects.sendKeys("maths");
		subjects.sendKeys(Keys.ENTER);

		WebElement stateDropdown = chromeDriver.findElement(By.id("react-select-3-input"));
		stateDropdown.sendKeys("NCR");
		stateDropdown.sendKeys(Keys.ENTER);

		WebElement cityDropdown = chromeDriver.findElement(By.id("react-select-4-input"));
		// Thread.sleep(1000);
		cityDropdown.sendKeys("Delhi");
		cityDropdown.sendKeys(Keys.ENTER);

		// Choose File
	    File uploadFile = new File("src/jquery.jpeg");
		WebElement chooseFile = chromeDriver.findElement(By.id("uploadPicture"));
		chooseFile.sendKeys(uploadFile.getAbsolutePath());
		js.executeScript("window.scrollBy(0,100)");
		chromeDriver.findElement(By.id("submit")).click();
	}
}