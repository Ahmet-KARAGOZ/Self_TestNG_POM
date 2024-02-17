package tests.myDay;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JobExplorerProPage;
import utilities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Admin olarak giriş yaptıktan sonra
Jobs menüsü altındaki Categories menüsünden sitede yer alan kategorileri görüntüleyebilmeli,
yeni kategori ekleyebilmeli,
eklediğim kategoriyi görüntüleyebilmeli,
düzenleyebilmeli ve silebilmeliyim
 */

public class US25_AdminCategories extends TestBaseRapor {
	@Test
	public void adminCategoriesGoruntulemeTesti_US25_TC01(){
		extentTest = extentReports.createTest("Admin Sayfasi Categories Görüntüleme Testi", "Admin tüm kategorileri görüntüleyebilmeli.");
		JobExplorerProPage jobExplorerProPage = new JobExplorerProPage();
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		jobExplorerProPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		jobExplorerProPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		jobExplorerProPage.signinBoxAdmin.click();
		extentTest.info("Geçerli email ve password bilgilerini girerek giriş butonuna tıklar.");

		jobExplorerProPage.leftMenuButtonAdmin.click();
		extentTest.info("Menü ikonu ile soldan açılır menüyü açar");
		jobExplorerProPage.leftMenuJobsButtonAdmin.click();
		extentTest.info("Jobs sekmesine tıklar.");
		jobExplorerProPage.leftMenuCategoriesIconuAdmin.click();
		extentTest.info("Jobs sekmesi altındaki Categories sekmesine tıklar.");

		RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
		extentTest.info("Sayfa sonuna gelerek diğer sayfaları da kontrol eder.");

		//en altta bulunan text split ile ayrıştırılıp toplam entry sayısı ve görüntülenen entry sayısı bulunur.
		//Oluşturulan listeye sayfada bulunan entryler eklenir.
		String[] sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
		List<WebElement> tabloToplamSatirlar = new ArrayList<>();
		tabloToplamSatirlar.addAll(jobExplorerProPage.categoriesTabloSatirlarListesi);

		//Görüntülenen entry sayısı toplam entry sayısına eşit  değilse sonraki sayfaya geçer
		//Geçilen sayfadaki entryleri oluşturulan listeye ekler
		if (!sonucYaziDizisi[3].equals(sonucYaziDizisi[5])){
			jobExplorerProPage.categoriesNextPageIconu.click();
			RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
			sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
			tabloToplamSatirlar.addAll(jobExplorerProPage.categoriesTabloSatirlarListesi);

		}
		//System.out.println(tabloToplamSatirlar.size());


		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(tabloToplamSatirlar.size() == Integer.parseInt(sonucYaziDizisi[3]));
		extentTest.pass("Tüm listedeki kategori sayısı ile en altta yazan entry sayısının eşit olduğunu doğrular.");
		softAssert.assertAll();

		ReusableMethods.bekle(2);

		//Driver.quitDriver();
		extentTest.info("Sayfatı Kapatır.");
	}
}
