package pixage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Kutuphane {

	@Test
	public void LoginPixage() {

		System.out.println("Baþlýyoruz.");

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		sleep(3000);
		driver.manage().window().maximize();

		String url = "https://console-test.pixage.com.tr/#/login";
		driver.get(url);
		System.out.println("Pixage login sayfasý açýldý.");
		sleep(2000);

		WebElement Eposta = driver.findElement(By.xpath("//input[@id='emailBasicInput']"));
		Eposta.sendKeys("murathasdemir07@gmail.com");
		sleep(2000);

		WebElement Password = driver.findElement(By.id("passwordBasicInput"));
		Password.sendKeys("123456Mh*");
		sleep(2000);

		WebElement LoginButton = driver.findElement(By.xpath(
				"/html//div[@id='root']//div[@class='login-container']//form[@class='form-part']//button[@type='submit']/span[@class='MuiButton-label']"));
		LoginButton.click();
		sleep(4000);
		System.out.println("Anasayfaya giriþ yapýldý.");
		
		WebElement Menu = driver.findElement(By.cssSelector("a[title='Kütüphane'] > .cat-text"));
		Menu.click();
		sleep(4000);
		
		String Kutuphane_url = "https://console-test.pixage.com.tr/#/library";
		String Kutuphane_url_link = driver.getCurrentUrl();
		Assert.assertEquals(Kutuphane_url_link, Kutuphane_url, "Kutuphane url hatali");
		
		WebElement Kutuphane_basarili_mesaj = driver.findElement(By.cssSelector(".anouncement-text"));
		String Kutuphane_metin = "Ýçeriðinizi oluþturmak için, Yeni Ýçerik Ekle butonuna týklayarak iþlem yapabilirsiniz";
		String Kutuphane_beklenen_mesaj = Kutuphane_basarili_mesaj.getText();
		Assert.assertTrue(Kutuphane_beklenen_mesaj.contains(Kutuphane_metin), "Kutuphane metni hatali");

		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
