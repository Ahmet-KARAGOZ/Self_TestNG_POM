package tests.myDay;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JobExplorerProPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.RecepHocaJSUtilities;
import utilities.ReusableMethods;

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

public class US25_AdminCategories {
	@Test
	public void test01(){
		JobExplorerProPage jobExplorerProPage = new JobExplorerProPage();
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		jobExplorerProPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		jobExplorerProPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		jobExplorerProPage.signinBoxAdmin.click();

		jobExplorerProPage.leftMenuButtonAdmin.click();
		jobExplorerProPage.leftMenuJobsButtonAdmin.click();
		jobExplorerProPage.leftMebuCategoriesIconuAdmin.click();

		RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
		/*int sayac = 0;


		try {
			while (jobExplorerProPage.categoriesNextPageIconu.isEnabled()){
				jobExplorerProPage.categoriesNextPageIconu.click();
				RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
				sayac++;
			}
		} catch (Exception e) {

		}


		System.out.println(sayac);

		 */


		String[] sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
		List<WebElement> tabloToplamSatirlar = new ArrayList<>();
		tabloToplamSatirlar.addAll(jobExplorerProPage.categoriesTabloSatirlarListesi);


		if (!sonucYaziDizisi[3].equals(sonucYaziDizisi[5])){
			jobExplorerProPage.categoriesNextPageIconu.click();
			RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
			sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
			tabloToplamSatirlar.addAll(jobExplorerProPage.categoriesTabloSatirlarListesi);

		}
		System.out.println(tabloToplamSatirlar.size());

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tabloToplamSatirlar.size() == Integer.parseInt(sonucYaziDizisi[3]));




		ReusableMethods.bekle(2);




		Driver.quitDriver();
	}
}
