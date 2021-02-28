package com.FindingHospital.Base;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationDriver {
	// Create properties reference to read from properties file
	Properties properties = new Properties();

	// Constructor to initialize reader object with our properties file and load it
	public ApplicationDriver() throws Exception {
		FileReader readerobject = new FileReader("config.properties");
		properties.load(readerobject);
	}

	// Method to invoke Chrome driver
	public WebDriver ChromeDriver() {
		WebDriver driver;

		// To print on console that Chrome browser is launching
		System.out.println("Launching Chrome Browser");

		// Set driver properties (driverName, driverLocation)
		System.setProperty("webdriver.chrome.driver", properties.getProperty("chromepath"));
		driver = new ChromeDriver();

		// Get the value of baseURL by driver to open the website/web application
		driver.get(properties.getProperty("baseUrl"));

		// Maximize the opened window
		driver.manage().window().maximize();
		return driver;

	}

	// Method to invoke Firefox driver
	public WebDriver EdgeDriver() {
		WebDriver driver;

		// To print on console that Edge is launching
		System.out.println("Launching Edge Browser");

		// Set driver properties (driverName, driverLocation)
		System.setProperty("webdriver.edge.driver", properties.getProperty("edgepath"));
		driver = new org.openqa.selenium.edge.EdgeDriver();

		// Get the value of baseURL by driver to open the website/web application
		driver.get(properties.getProperty("baseUrl"));

		// Maximize the opened window
		driver.manage().window().maximize();
		return driver;
	}

}