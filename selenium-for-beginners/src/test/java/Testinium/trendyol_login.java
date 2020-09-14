package Testinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class trendyol_login {

	@Test
	public void LoginTrendyol() {

		System.out.println("Baþlýyoruz.");

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		sleep(3000);
		driver.manage().window().maximize();		
		

		String url = "https://www.trendyol.com/";
		driver.get(url);
		System.out.println("Trendyol sayfasý açýldý.");
		sleep(2000);
		
		WebElement ReklamButton = driver.findElement(By.xpath("//div[@id='popupContainer']//div[@class='homepage-popup-content']//a[@class='gender-button']//span[@class='homepage-popup-img']"));
		ReklamButton.click();
		sleep(2000);
		
		String trendyol_url = "https://www.trendyol.com/butik/liste/kadin";
		String trendyol_url_link = driver.getCurrentUrl();
		Assert.assertEquals(trendyol_url_link, trendyol_url, "Trendyol url hatali");
		
		WebElement login_ikon = driver.findElement(By.xpath("//li[@id='accountBtn']//i[@class='icon navigation-icon-user']"));
		login_ikon.click();
		sleep(2000);
		
		
		WebElement Eposta = driver.findElement(By.id("email"));
		Eposta.sendKeys("qqb3xh9d@classesmail.com");
		sleep(1000);

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("123456Mh*");
		sleep(1000);

		WebElement LoginButton = driver.findElement(By.id("loginSubmit"));
		LoginButton.click();
		sleep(4000);
		System.out.println("Trendyol'a login olundu.");
		
		WebElement indirim_popup = driver.findElement(By.xpath("//div[@class='modal-close']"));
		indirim_popup.click();
		sleep(1500);
		System.out.println("Arama öncesi");
		
		WebElement Arama = driver.findElement(By.xpath("//div[@class='search-box-container']//input[@class='search-box']"));
		Arama.sendKeys("bilgisayar");
		sleep(2000);
		System.out.println("Arama yapýldý");
		
		WebElement bilgisayar_secim = driver.findElement(By.xpath("//div[@class='suggestions-container']//div[@class='suggestion-result']//a[@class='suggestion']"));
		bilgisayar_secim.click();
		sleep(2000);
		System.out.println("Secim yapildi");
		
		WebElement bilgisayar_sec = driver.findElement(By.xpath("//div[@class='p-card-img-wr']"));
		bilgisayar_sec.click();
		sleep(1500);
		System.out.println("Secime tiklandi");
		
		WebElement sepete_ekle = driver.findElement(By.xpath("//button[@class='pr-in-btn add-to-bs']"));
		sepete_ekle.click();
		sleep(3000);
		System.out.println("Sepete ekle");
		
		WebElement sepete_git = driver.findElement(By.xpath("//div[@class='icon-container']//a[@href='/sepetim#/basket']//i[@class='icon navigation-icon-basket']"));
		sepete_git.click();
		sleep(3000);
		System.out.println("Sepete git");
		
		/*
		 * WebElement fiyat_bilgisi =
		 * driver.findElement(By.xpath("//div[@class='pb-basket-item-price']")); String
		 * beklenen_fiyat = "1.399 TL"; String urun_fiyat = fiyat_bilgisi.getText();
		 * Assert.assertTrue(urun_fiyat.contains(beklenen_fiyat),
		 * "Fiyat bilgisi hatalidir"); sleep(3000);
		 */
		
		WebElement urun_adet = driver.findElement(By.xpath("//button[@class='ty-numeric-counter-button']"));
		urun_adet.click();
		sleep(3000);
		System.out.println("urun adet");
		
		WebElement urun_sil = driver.findElement(By.xpath("//i[@class='i-trash']"));
		urun_sil.click();
		sleep(3000);
		System.out.println("urun silinsin mi");
		
		WebElement urun_sil_onay = driver.findElement(By.xpath("//button[@ng-click='removeItemAsMember()']"));
		urun_sil_onay.click();
		sleep(3000);
		System.out.println("urun silindi");
		

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
