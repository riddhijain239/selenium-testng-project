package GroupsAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	@Test
	public void openFormPage() throws InterruptedException {
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://demoqa.com/");
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
		js.executeScript("window.scrollBy(0,250)", "");

		chromeDriver.findElement(By.xpath("//div[@class='category-cards']/div[2]/div")).click();
		chromeDriver.findElement(By.xpath("//div[@class='accordion']/div/div/ul/li/span[text()='Practice Form']"))
				.click();


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
		Thread.sleep(2000);
		cityDropdown.sendKeys("Delhi");
		cityDropdown.sendKeys(Keys.ENTER);

	}

}