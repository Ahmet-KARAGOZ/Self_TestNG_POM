package tests.day16_TestNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;
/*
1- testotomasyonu anasayfaya gidin
2- phone icin arama yapin
3- Arama sonucunda bulunan urun sayisinin 3’den cok oldugunu test edin
4- ilk urunu tiklayin
5- acilan urun sayfasinda, urun isminde case sensitive olmadan phone bulundugunu test edin.
 */

public class C02_PageClassKullanimi {
	@Test
	public void aramaTesti(){
		Driver.getDriver().get("https://www.testotomasyonu.com/");
		TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
		testOtomasyonPage.aramaKutusu.sendKeys("phone" , Keys.ENTER);

		int actSonucSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();
		int expMinSonucSayisi = 3;

		Assert.assertTrue(actSonucSayisi>expMinSonucSayisi);

		testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
		String expUrunIsimIcerigi = "phone";
		String actUrunIsmiKucukHarf = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();
		Assert.assertTrue(actUrunIsmiKucukHarf.contains(expUrunIsimIcerigi));

		ReusableMethods.bekle(2);
		Driver.quitDriver();

	}
}
