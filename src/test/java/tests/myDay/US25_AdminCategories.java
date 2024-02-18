package tests.myDay;

import org.openqa.selenium.By;
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
	public void adminCategoriesGoruntulemeTesti_US25_TC01() {
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


		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(jobExplorerProPage.categoiresSayfaBasligiText.getText(), "Categories");
		extentTest.pass("Categories sayfasında olduğunu doğrular.");


		RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
		extentTest.info("Sayfa sonuna gelerek diğer sayfaları da kontrol eder.");

		//en altta bulunan text split ile ayrıştırılıp toplam entry sayısı ve görüntülenen entry sayısı bulunur.
		//Oluşturulan listeye sayfada bulunan entryler eklenir.
		String[] sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
		List<WebElement> tabloToplamSatirlar = new ArrayList<>();
		tabloToplamSatirlar.addAll(jobExplorerProPage.categoriesTabloSatirlarListesi);

		//Görüntülenen entry sayısı toplam entry sayısına eşit  değilse sonraki sayfaya geçer
		//Geçilen sayfadaki entryleri oluşturulan listeye ekler
		while (!sonucYaziDizisi[3].equals(sonucYaziDizisi[5])) {
			jobExplorerProPage.categoriesNextPageIconu.click();
			RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
			sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
			tabloToplamSatirlar.addAll(jobExplorerProPage.categoriesTabloSatirlarListesi);

		}
		//System.out.println(tabloToplamSatirlar.size());

		softAssert.assertTrue(tabloToplamSatirlar.size() == Integer.parseInt(sonucYaziDizisi[3]));
		extentTest.pass("Tüm listedeki kategori sayısı ile en altta yazan entry sayısının eşit olduğunu doğrular.");
		softAssert.assertAll();

		//Driver.quitDriver();
		extentTest.info("Sayfatı Kapatır.");
	}

	@Test
	public void adminYeniCategoryEklemeTesti_US25_TC02() {
		extentTest = extentReports.createTest("Admin Sayfasi Yeni Category Ekleme Testi", "Admin yeni Category ekleyip listede görebilmeli.");
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


		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(jobExplorerProPage.categoiresSayfaBasligiText.getText(), "Categories");
		extentTest.pass("Categories sayfasında olduğunu doğrular.");
		//ReusableMethods.bekle(2);

		RecepHocaJSUtilities.clickWithJS(Driver.getDriver(), jobExplorerProPage.categoriesAddNewButton);
		extentTest.info("Add New butonuna tıklar.");

		jobExplorerProPage.addCategoryNameBox.sendKeys(ConfigReader.getProperty("categoryNameTest"));
		jobExplorerProPage.addCategorySloganBox.sendKeys(ConfigReader.getProperty("categorySloganTest"));
		jobExplorerProPage.addCategoryDescriptionBox.sendKeys(ConfigReader.getProperty("categoryDescriptionTest"));
		extentTest.info("Add Category sayfasında Name, Slogan ve Description bilgilerini girer.");
		jobExplorerProPage.addCategorySaveButton.click();
		extentTest.info("Save butonuna basarak kaydı tamamlar.");

		ReusableMethods.bekle(1);


		List<WebElement> tabloToplamIsimler = new ArrayList<>(jobExplorerProPage.categoriesTabloIsimList);
		List<String> isimlerStringList = new ArrayList<>(ReusableMethods.stringListeCevir(tabloToplamIsimler));

		RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
		String[] sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
		extentTest.info("Sayfa sonundan mevcut diğer sayfalarıda kontrol eder.");


		while (!sonucYaziDizisi[3].equals(sonucYaziDizisi[5])) {
			jobExplorerProPage.categoriesNextPageIconu.click();
			isimlerStringList.addAll(ReusableMethods.stringListeCevir(jobExplorerProPage.categoriesTabloIsimList));
			RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
			sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
		}
		if (isimlerStringList.contains(ConfigReader.getProperty("categoryNameTest"))) {
			System.out.println("Yeni kayıt ekeleme başarılı.");
		}
		softAssert.assertTrue(isimlerStringList.contains(ConfigReader.getProperty("categoryNameTest")), "Eklenen Kategori bulunamadı.");
		extentTest.pass("Ekelenen yeni Category nin listede yer aldığını doğrular.");
		extentTest.info("Sayfatı kapatır.");
		softAssert.assertAll();
	}

	@Test(dependsOnMethods = "adminYeniCategoryEklemeTesti_US25_TC02")
	public void eklediginCategoriyiGoruntulemeTesti_US25_TC03() {
		extentTest = extentReports.createTest("Admin Sayfasi Categories Görüntüleme Testi", "Admin seçtiği Category bilgilerini görüntüleyebilmeli.");
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


		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(jobExplorerProPage.categoiresSayfaBasligiText.getText(), "Categories");
		extentTest.pass("Categories sayfasında olduğunu doğrular.");

		String dinamikXpath;
		String dinamikXpathViewButton;

		for (int i = 1; i <= jobExplorerProPage.categoriesTabloIsimList.size(); i++) {
			dinamikXpath = "//tbody/tr[" + i + "]/td[2]";
			dinamikXpathViewButton = "//tbody/tr[" + i + "]/td[6]/a[3]";
			if (Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText().equals(ConfigReader.getProperty("categoryNameTest"))) {
				//System.out.println("-----kayıt bulundu.");
				Driver.getDriver().findElement(By.xpath(dinamikXpathViewButton)).click();
				extentTest.info("Görüntülemek istediği Category satırında bulunan View butonu ile Category bilgilerini görüntüler.");
			}
		}
		//System.out.println(jobExplorerProPage.viewingCategoryNameText.getText());
		softAssert.assertEquals(jobExplorerProPage.viewingCategoryNameText.getText(), ConfigReader.getProperty("categoryNameTest"));
		extentTest.pass("Viewing Category sayfasında category bilgilerinin, seçtiği satıra ait olduğunu doğrular.");

		extentTest.info("Sayfayı kapatır.");
		softAssert.assertAll();
	}

	@Test(dependsOnMethods = "adminYeniCategoryEklemeTesti_US25_TC02")
	public void eklenenCategoriyiDuzenlemeTesti_US25_TC04() {
		extentTest = extentReports.createTest("Admin Sayfasi Categories Güncelleme Testi", "Admin seçtiği Category bilgilerini güncelleyebilmeli.");
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


		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(jobExplorerProPage.categoiresSayfaBasligiText.getText(), "Categories");
		extentTest.pass("Categories sayfasında olduğunu doğrular.");

		String dinamikXpath;
		String dinamikXpathEditButton;

		for (int i = 1; i <= jobExplorerProPage.categoriesTabloIsimList.size(); i++) {
			dinamikXpath = "//tbody/tr[" + i + "]/td[2]";
			dinamikXpathEditButton = "//tbody/tr[" + i + "]/td[6]/a[2]";
			if (Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText().equals(ConfigReader.getProperty("categoryNameTest"))) {
				System.out.println("-----kayıt bulundu.");
				Driver.getDriver().findElement(By.xpath(dinamikXpathEditButton)).click();
				extentTest.info("Düzenlemek istediği Category satırında bulunan Edit butonuna tıklar.");

			}
		}
		jobExplorerProPage.editCategoryNameBox.clear();
		jobExplorerProPage.editCategoryNameBox.sendKeys(ConfigReader.getProperty("categoryNameTestEditText"));
		jobExplorerProPage.editCategorySloganBox.clear();
		jobExplorerProPage.editCategorySloganBox.sendKeys(ConfigReader.getProperty("categorySloganTestEditTExt"));
		jobExplorerProPage.editCategoryDescritionBox.clear();
		jobExplorerProPage.editCategoryDescritionBox.sendKeys(ConfigReader.getProperty("categoryDescriptionTestEditText"));
		ReusableMethods.bekle(1);
		extentTest.info("Editlenmiş Name, Slogan ve Descrition bilgilerini girer.");
		jobExplorerProPage.editCategorySaveButton.click();
		extentTest.info("Save butonuna tıklar.");

		List<String> isimlerStringList = new ArrayList<>(ReusableMethods.stringListeCevir(jobExplorerProPage.categoriesTabloIsimList));
		/*if (isimlerStringList.contains(ConfigReader.getProperty("categoryNameTestEditText"))) {
			System.out.println("Edit başarılı....");
		}

		 */
		softAssert.assertTrue(isimlerStringList.contains(ConfigReader.getProperty("categoryNameTestEditText")));
		extentTest.pass("Editlenmiş bilgilerin Categories sayfasında göründüğünü doğrular.");
		softAssert.assertAll();
		extentTest.info("Sayfayı kapatır.");
	}

	@Test(dependsOnMethods = "adminYeniCategoryEklemeTesti_US25_TC02")
	public void eklenenCategoriyiSilmeTesti_US25_TC05() {
		extentTest = extentReports.createTest("Admin Sayfasi ilgili Category silme Testi", "Admin istediği Categoryi silebilmeli.");
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


		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(jobExplorerProPage.categoiresSayfaBasligiText.getText(), "Categories");
		extentTest.pass("Categories sayfasında olduğunu doğrular.");

		String dinamikXpath;
		String dinamikXpathDeleteButton;

		for (int i = 1; i <= jobExplorerProPage.categoriesTabloIsimList.size(); i++) {
			dinamikXpath = "//tbody/tr[" + i + "]/td[2]";
			dinamikXpathDeleteButton = "//tbody/tr[" + i + "]/td[6]/a[1]";
			if (Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText().equals(ConfigReader.getProperty("categoryNameTest"))) {
				//System.out.println("-----Silinecek kayıt bulundu.");
				Driver.getDriver().findElement(By.xpath(dinamikXpathDeleteButton)).click();
				extentTest.info("Silnmek istediği Category satırında bulunan Delete butonuna tıklar.");
				ReusableMethods.bekle(1);
				jobExplorerProPage.categorySilmePopupOnayButton.click();
				extentTest.info("Açılan Pop-up mesajında Yes Delete It butonuna tıklar.");
			}
			if (Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText().equals(ConfigReader.getProperty("categoryNameTestEditText"))) {
				//System.out.println("-----Silinecek editli kayıt bulundu.");
				Driver.getDriver().findElement(By.xpath(dinamikXpathDeleteButton)).click();
				extentTest.info("Silnmek istediği Category satırında bulunan Delete butonuna tıklar.");
				ReusableMethods.bekle(1);
				jobExplorerProPage.categorySilmePopupOnayButton.click();
				extentTest.info("Açılan Pop-up mesajında Yes Delete It butonuna tıklar.");
			}
		}
		List<String> isimlerStringList = new ArrayList<>(ReusableMethods.stringListeCevir(jobExplorerProPage.categoriesTabloIsimList));
		RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
		String[] sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");

		while (!sonucYaziDizisi[3].equals(sonucYaziDizisi[5])) {
			jobExplorerProPage.categoriesNextPageIconu.click();
			isimlerStringList.addAll(ReusableMethods.stringListeCevir(jobExplorerProPage.categoriesTabloIsimList));
			RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
			sonucYaziDizisi = jobExplorerProPage.categoriesSonucYazisi.getText().split(" ");
		}

		/*if (!isimlerStringList.contains(ConfigReader.getProperty("categoryNameTest"))) {
			System.out.println("Silme başarılı listede category bulunamadı.....");
		}

		 */
		softAssert.assertFalse(isimlerStringList.contains(ConfigReader.getProperty("categoryNameTest")));
		softAssert.assertFalse(isimlerStringList.contains(ConfigReader.getProperty("categoryNameTestEditText")));
		extentTest.info("Diğer sayfalarıda kontrol eder ve istenen Category nin silindiğini doğrular.");
		softAssert.assertAll();
		extentTest.info("Sayfayı kapatır.");
	}
}
