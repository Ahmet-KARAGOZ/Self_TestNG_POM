package tests.day20_dataProvider_crossBrowserTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProviderileNegatifLoginTesti {


	@DataProvider
	public static Object[][] emailVePasswordProvider() {

		String[][] emailVeSifreler = {  {"banu@gmail.com","898989"},
										{"sedat@yahoo.com","989887"},
										{"orkong@tmail.com","122334"},
										{"fatih@hotmail.com","454545"},
										{"arzu@senmail.com","676767"},
										{"mehmet@mynet.com","878987"}     };

		return emailVeSifreler;
	}

	@Test(dataProvider = "emailVePasswordProvider")
	public void topluNegatifLoginTesti(String email , String password){

		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.accountLinki.click();
		testOtomasyonPage.emailKutusu.sendKeys(email);
		testOtomasyonPage.passwordKutusu.sendKeys(password);
		testOtomasyonPage.loginButonu.click();

		Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

		Driver.quitDriver();

	}
}
