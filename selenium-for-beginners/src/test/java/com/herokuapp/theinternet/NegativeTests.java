package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTests {
	
	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeLoginTest(String username, String password, String expectedErrorMessage) {

		System.out.println("Starting negativeLoginTest with " + username + " and " + password);

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		sleep(1000);

		driver.manage().window().maximize();

		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);

		System.out.println("Sayfa açýldý.");

		sleep(1000);

		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.sendKeys(username);
		sleep(1000);

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(password);
		sleep(1000);

		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();
		sleep(3000);

		WebElement errorMessage = driver.findElement(By.id("flash"));
		//String expectedErrorMessage = "Your username is invalid!";
		String actualErrorMessage = errorMessage.getText();

		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Uyarý bildirimi hatalý");

		driver.quit();

	}

	/*
	 * @Test(priority = 2) public void incorrectPasswordTest() {
	 * 
	 * System.out.println("Starting incorrectPasswordTest");
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "src/main/resources/chromedriver.exe"); WebDriver driver = new
	 * ChromeDriver();
	 * 
	 * sleep(1000);
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * String url = "https://the-internet.herokuapp.com/login"; driver.get(url);
	 * 
	 * System.out.println("Sayfa açýldý.");
	 * 
	 * sleep(1000);
	 * 
	 * WebElement username = driver.findElement(By.id("username"));
	 * username.sendKeys("tomsmith"); sleep(1000);
	 * 
	 * WebElement password = driver.findElement(By.name("password"));
	 * password.sendKeys("hatalýpass"); sleep(1000);
	 * 
	 * WebElement logInButton = driver.findElement(By.tagName("button"));
	 * logInButton.click(); sleep(3000);
	 * 
	 * WebElement errorMessage = driver.findElement(By.id("flash")); String
	 * expectedErrorMessage = "Your password is invalid!"; String actualErrorMessage
	 * = errorMessage.getText();
	 * 
	 * Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
	 * "Uyarý bildirimi hatalý");
	 * 
	 * driver.quit(); }
	 */
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
