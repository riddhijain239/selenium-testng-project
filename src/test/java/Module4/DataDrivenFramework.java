/*Assignment -1(Apache POI (Data Driven)):
➤url :http://demo.guru99.com/V4/
➤ Get the data from excel sheet using Apache poi
➤ Enter the username 
➤ Enter the password
➤ Click on Login button
➤ One prompt will open click on OK 

*/

package Module4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenFramework {

	public static void main(String[] args) throws IOException {
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("http://demo.guru99.com/V4/");
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String filePath = "F:\\TestingDataKeyword_ORHM.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Data");
		int rows = sheet.getLastRowNum();

		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);

			chromeDriver.findElement(By.name("uid")).sendKeys(username.toString());
			chromeDriver.findElement(By.name("password")).sendKeys(password.toString());
			chromeDriver.findElement(By.name("btnLogin")).click();
			chromeDriver.switchTo().alert().dismiss();

		}

		chromeDriver.close();

	}

}
