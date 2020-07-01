package VerifyNewOrderCreation;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyNewOrderCrMain {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		1. Open the chrome browser
//		2. Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
		driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx"); //2
//		3. Login using username Tester and password test		
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
//		4. Click on Order link
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Order")).click();
//		5. Enter a random quantity between 1 and 100
		
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(UtilityNewOrder.twoDigitsNum+"");
		
//		6. Enter Customer Name:
//		 John <Middle Name > Doe.
//		 Instead of <Middle Name> your code should enter a random string of length 5 every time.
		String randomMiddleName = UtilityNewOrder.randomString(5);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + randomMiddleName+" Doe");
		
//		7. Enter street: 8607 Westwood Center Dr
//		8. Enter City: Vienna
//		9. Enter State: Virginia
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("8607 Westwood Center Dr");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Vienna");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
		
//		10. Enter a random 5 digit number to the zip code field
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(UtilityNewOrder.fiveDigitsNum+"");
		
//		11. Select any card type. Every time your code should select a different type.
//		12. Enter any card number: 
//		If you selected Visa, card number should start with 4. If you selected Master, card number should start with 5. If you selected American Express, card number should start with 3. New card number should be auto generated every time you run the test. Card numbers should be 16 digits for Visa and Master, 15 for American Express.
		int radioButtons = UtilityNewOrder.randomQuantity(3);
        switch(radioButtons) {
		
		case 0: {driver.findElement(By.xpath("//input[@value = 'Visa']")).click();
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(UtilityNewOrder.Visa());
				
				break;}
		case 1: {driver.findElement(By.xpath("//input[@value = 'MasterCard']")).click();
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(UtilityNewOrder.Master());
				break;}
		
		case 2: {
			driver.findElement(By.xpath("//input[@value = 'American Express']")).click();
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(UtilityNewOrder.AmericanExpress());
			break;}
		}
		
//		13. Enter a valid expiration date 
        
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(UtilityNewOrder.expirationDate());

		Thread.sleep(5000);
			
//		14. Click on Process
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
//		15. Verify that the page contains text “New order has been successfully added”.


		Boolean verify = driver.findElement(By.tagName("strong")).getText().contains("New order has been successfully added");
		
		System.out.println("The page contains text true/false?   :   " + verify);
		
		Thread.sleep(10000);
		
		driver.quit();
		
		
	

	}

}
