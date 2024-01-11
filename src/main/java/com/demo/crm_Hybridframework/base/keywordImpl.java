package com.demo.crm_Hybridframework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class keywordImpl implements keyword {

	static ChromeDriver driver;
	static FileInputStream input = null;
	static Properties prop = null;

	public void open() {

		prop = new Properties();

		try {
			// Load the properties file
			input = new FileInputStream("");
					
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.setProperty("webdriver.chrome.driver", "E:\\GoogleChrome114\\chromedriver.exe");

			driver = new ChromeDriver();
		}
	}

	public void url(String url) {

		driver.get(url);
	}

	public void click(String objectName) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
	}

	public void input(String testdata, String objectName) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(testdata);

	}

}
