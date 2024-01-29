package tests.day16_TestNG_POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

//1."http://webdriveruniversity.com/" adresine gidin
//2."Login Portal" a kadar asagi inin
//3."Login Portal" a tiklayin
//4.Diger window'a gecin
//5."username" ve "password" kutularina deger yazdirin
//6."login" butonuna basin
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
//8.Ok diyerek Popup'i kapatin
//9.Ilk sayfaya geri donun
//10.Ilk sayfaya donuldugunu test edin

public class C05_WebuniversityTest {
	@Test
	public void webuniversityTest(){
		Driver.getDriver().get("https://webdriveruniversity.com/");
		String ilkSayfaWHD = Driver.getDriver().getWindowHandle();
		WebuniversityPage webuniversityPage = new WebuniversityPage();

		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("arguments[0].scrollIntoView();",webuniversityPage.loginPortalYaziElementi);

		//login portal yazısına kadar scrooll yaptığımızda yazı sayfanın üstündeki kırmızı bantın altında kaldığından
		//dolayı sonrasında clik yapamıyorduk. Bizde CONTACT US yazsına kadar yukarıya alıp her ekranda görünür olmasını sağladık.
		//jse.executeScript("arguments[0].scrollIntoView();",webuniversityPage.contactUsYaziElementi);

		//Intercept hatasından dolayı click yapamadığımız noktaya javaScript executer ile clik yapabildik.
		jse.executeScript("arguments[0].click();", webuniversityPage.loginPortalYaziElementi);




		//

		//webuniversityPage.loginPortalYaziElementi.click();

		ReusableMethods.titleIleWindowDegistir("WebDriver | Login Portal" , Driver.getDriver());
		Faker faker = new Faker();
		webuniversityPage.userNameKutusu.sendKeys(faker.name().username());
		webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());
		webuniversityPage.loginButonu.click();

		String expAlertYazisi = "validation failed";
		String actAlertYazisi = Driver.getDriver().switchTo().alert().getText();

		Assert.assertEquals(actAlertYazisi,expAlertYazisi);

		Driver.getDriver().switchTo().alert().accept();

		Driver.getDriver().switchTo().window(ilkSayfaWHD);

		String expURL = "https://webdriveruniversity.com/";
		String actURL = Driver.getDriver().getCurrentUrl();

		Assert.assertEquals(actURL,expURL);





		ReusableMethods.bekle(2);
		Driver.quitDriver();


	}
}
