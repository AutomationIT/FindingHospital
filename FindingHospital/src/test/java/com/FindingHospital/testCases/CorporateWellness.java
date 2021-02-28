package com.FindingHospital.testCases;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class CorporateWellness extends Homepage {
	@Test(priority = 10)
	public void corporateWellness() throws Exception {
		driver.navigate().to("https://www.practo.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scrolling to get more hotels
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(7000);

		driver.navigate().to("https://www.practo.com/plus/corporate");
		Thread.sleep(10000);

		// Filling value in form
		WebElement name = driver.findElement(By.xpath("//*[@id='name']"));
		name.sendKeys("psnsp");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[2]"))
				.sendKeys("Group-3");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[3]"))
				.sendKeys("psnsp.gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[4]"))
				.sendKeys("9876543210");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/button"))
				.click();
		Thread.sleep(7000);

		Alert alt = driver.switchTo().alert();
		String msg = alt.getText();
		alt.accept();
		Thread.sleep(3000);

		// To capture screenshot of Home page
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			// FileUtils.copyFile(source,new
			// File(properties.getProperty("ScreenshotLocation")+"/Homepage.png"));
			FileUtils.copyFile(source, new File("./Screenshots/CorporateWelllness Error Message.png"));

		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Message is : " + msg);

	}

}
