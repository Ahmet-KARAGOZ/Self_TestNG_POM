package tests.day18_SoftAssertions_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssertion {
	//

	@Test
	public void softAssertAramaTesti(){
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

		String expUrl = ConfigReader.getProperty("toUrl") + "/asdf";
		String actUrl = Driver.getDriver().getCurrentUrl();

		//Assert.assertEquals(actUrl,expUrl);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actUrl,expUrl,"URL Testi failed");

		testOtomasyonPage.aramaKutusu.sendKeys("phone" , Keys.ENTER);


		int expMinUrunSayisi = 33;
		int actUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

		//Assert.assertTrue(actUrunSayisi > expMinUrunSayisi);
		softAssert.assertTrue(actUrunSayisi>expMinUrunSayisi,"2. Assertion failed");

		testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

		String expUrunIsimIcerik = "phoneX";
		String actUrunIsmiKucukHarf = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();

		//Assert.assertTrue(actUrunIsmiKucukHarf.contains(expUrunIsimIcerik));
		softAssert.assertTrue(actUrunIsmiKucukHarf.contains(expUrunIsimIcerik),"Ürün ismi Testi  failed");

		softAssert.assertAll();

		Driver.quitDriver();
	}
}
