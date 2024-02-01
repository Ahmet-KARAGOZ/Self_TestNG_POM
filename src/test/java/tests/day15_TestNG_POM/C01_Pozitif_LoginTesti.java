package tests.day15_TestNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;
/*
1- https://www.testotomasyonu.com/ anasayfasina gidin
2- account linkine basin
 3- Kullanici email'i olarak “wise@gmail.com”girin
 4- Kullanici sifresi olarak “12345” girin
 5- Login butonuna basarak login olun
 6- Basarili olarak giris yapilabildigini test edin
 */

public class C01_Pozitif_LoginTesti extends TestBase {
	@Test
	public void pozitifLogin(){
		driver.get("https://www.testotomasyonu.com/");
		driver.findElement(By.xpath("(//a[@class='e-cart'])[1]")).click();

		WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
		emailKutusu.sendKeys("wise@gmail.com");

		WebElement sifreKutusu = driver.findElement(By.xpath("//input[@id='password']"));
		sifreKutusu.sendKeys("12345");

		driver.findElement(By.xpath("//*[@id='submitlogin']")).click();

		WebElement logOutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));
		Assert.assertTrue(logOutButonu.isDisplayed());
		ReusableMethods.bekle(2);


	}
}
