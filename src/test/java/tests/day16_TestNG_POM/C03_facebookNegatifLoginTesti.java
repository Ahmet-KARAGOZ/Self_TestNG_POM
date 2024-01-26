package tests.day16_TestNG_POM;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;
/*
1 - https://www.facebook.com/ adresine gidin
2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
4- Basarili giris yapilamadigini test edin
 */

public class C03_facebookNegatifLoginTesti {
	@Test
	public void facebookNegatifLoginTesti(){
		Driver.getDriver().get("https://www.facebook.com/");
		FacebookPage facebookPage = new FacebookPage();

		Faker faker = new Faker();
		facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());

		facebookPage.passWordKutusu.sendKeys(faker.internet().password());
		facebookPage.loginButonu.click();

		ReusableMethods.bekle(5);

		Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());

		Driver.quitDriver();




	}
}
