package com.FindingHospital.testCases;

import java.io.*;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class Diagnosispage extends Homepage {

	// Click on Diagnosis
	@Test(priority = 8)
	public void click_Diagnosis() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scrolling to get more hotels
		js.executeScript("window.scrollTo(document.body.scrollHeight , 0)");

		Thread.sleep(5000);

		driver.navigate().to("https://www.practo.com/tests?city=bangalore");

		Thread.sleep(4000);

		// To capture screenshot of Home page
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			// FileUtils.copyFile(source,new
			// File(properties.getProperty("ScreenshotLocation")+"/Homepage.png"));
			FileUtils.copyFile(source, new File("./Screenshots/Diagnosis.png"));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// display all top cities
	@Test(priority = 9)
	public void Top_cities() throws Exception {
		driver.findElement(By.xpath("//*[@id='locationInput']")).click();

		Thread.sleep(5000);

		List<WebElement> topCities = driver
				.findElements(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div/div[3]/ul"));

		for (int i = 0; i < topCities.size(); i++) {

			String TopCities = topCities.get(i).getText();
			System.out.println(TopCities);
		}

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create Excel Sheet
		XSSFSheet sheet = workbook.createSheet("Details");
		// Iterate over the Data
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("SNo.");
		row.createCell(1).setCellValue("Top Cities");

		// hospitals of Bangalore city with rating more than 3.5
		for (int i = 0; i < topCities.size(); i++) {
			row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(i + 1);
			row.createCell(1).setCellValue(topCities.get(i).getText());
			System.out.println(topCities.get(i).getText());
		}

		// Write Down file on HardDisk

		FileOutputStream fos = new FileOutputStream(new File("Top_Cities.xlsx"));

		workbook.write(fos);

	}
}
