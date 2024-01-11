package com.demo.crm_Hybridframework.base;



	
	 import org.openqa.selenium.By;
	 import org.openqa.selenium.WebDriver;
	 import org.openqa.selenium.WebElement;
	 import org.openqa.selenium.chrome.ChromeDriver;

	 import java.util.List;

	 public class validation {
	     public static void main(String[] args) {
	         // Set the path to your ChromeDriver executable
	         System.setProperty("webdriver.chrome.driver", "E:\\\\GoogleChrome114\\\\chromedriver.exe");

	         // Create a new instance of the Chrome driver
	         WebDriver driver = new ChromeDriver();

	         // Assuming you have stored data in a List<String> named 'storedData'
	         List<String> storedData = List("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n" + 
	         		"\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n" + 
	         		"\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");

	         // Open the webpage with the UI table
	         driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

	         // Wait for the table to load (you may need to implement a more robust wait strategy)
	         try {
	             Thread.sleep(3000);
	         } catch (InterruptedException e) {
	             e.printStackTrace();
	         }

	         // Locate the table and extract data from it
	         WebElement table = driver.findElement(By.xpath("//*[@id=\"dynamictable\"]/caption"));
	         List<WebElement> rows = table.findElements(By.tagName("name"));

	         // Assuming the data in the table is in the first column of each row
	         for (int i = 1; i < rows.size(); i++) {
	             String uiTableData = rows.get(i).findElements(By.tagName("name")).get(0).getText();
	             String storedTableData = storedData.get(i - 1);

	             // Compare the data
	             if (!uiTableData.equals(storedTableData)) {
	                 System.out.println("Data in the UI table does not match the stored data.");
	                 // You may choose to handle the mismatch appropriately (e.g., throw an exception)
	             }
	         }

	         System.out.println("Data in the UI table matches the stored data.");

	         // Close the browser
	         driver.quit();
	     }

	 	private static List<String> List(String string) {
	 		// TODO Auto-generated method stub
	 		return null;
	 	}
	 }




