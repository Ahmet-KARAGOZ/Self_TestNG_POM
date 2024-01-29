package tests.day17_TestNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonAddRemovePage;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
//● https://testotomasyonu.com/addremove/ adresine gidin.
//● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
//● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
//● ’Please click for Electronics Products’ linkine tiklayin.
//● Electronics sayfasinin acildigini test edin
//● Bulunan urun sayisinin 16 olduğunu test edin
//● Ilk actiginiz addremove sayfasina donun
//● Url’in addremove icerdigini test edin

public class C03_SwitchingWindows {
	@Test
	public void windowTesti(){
		Driver.getDriver().get(ConfigReader.getProperty("toAddUrl"));

		String expYazi ="Add/Remove Elements";
		TestOtomasyonAddRemovePage testOtomasyonAddRemovePage = new TestOtomasyonAddRemovePage();
		String actYazi = testOtomasyonAddRemovePage.addRemoveYaziElementi.getText();
		Assert.assertEquals(actYazi , expYazi);

		String expTitle = "Test Otomasyonu";
		String actTitle = Driver.getDriver().getTitle();

		Assert.assertEquals(actTitle , expTitle);
		String addRemoveWHD = Driver.getDriver().getWindowHandle();

		testOtomasyonAddRemovePage.electronicsProductLinki.click();

		ReusableMethods.titleIleWindowDegistir("Test Otomasyonu - Electronics" , Driver.getDriver());
		Assert.assertTrue(testOtomasyonAddRemovePage.electronicsSayfasiDogrulama.isDisplayed());

		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		int expUrunSayisi = 16;
		int actUrunSayisi = testOtomasyonAddRemovePage.bulunanUrunElementleriList.size();

		Assert.assertEquals(actUrunSayisi,expUrunSayisi);

		Driver.getDriver().switchTo().window(addRemoveWHD);

		String expUrlicerik = "addremove";
		String actURL = Driver.getDriver().getCurrentUrl();

		Assert.assertTrue(actURL.contains(expUrlicerik));

		Driver.quitDriver();






	}
}
