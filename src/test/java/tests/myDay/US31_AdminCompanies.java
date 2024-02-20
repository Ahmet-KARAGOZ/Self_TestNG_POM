package tests.myDay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPanelPage;
import utilities.*;

import java.util.ArrayList;
import java.util.List;
/*
Admin olarak giriş yaptıktan sonra
Companies menüsünden siteye üye olan şirketleri görüntüleyebilmeli,
yeni şirket ekleyebilmeli,
eklediğim şirket bilgilerini düzenleyebilmeli.
şirketi kaydını silebilmeliyim.




 */

public class US31_AdminCompanies extends TestBaseRapor {
	@Test
	public void companiesUyeSirketleriGoruntulemeTesti_US31_TC01() {
		extentTest = extentReports.createTest("Admin Sayfasi Companies Görüntüleme Testi", "Admin tüm şirketleri görüntüleyebilmeli.");
		AdminPanelPage adminPanelPage = new AdminPanelPage();
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		adminPanelPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		adminPanelPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		adminPanelPage.signinBoxAdmin.click();
		extentTest.info("Geçerli email ve password bilgilerini girerek giriş butonuna tıklar.");

		adminPanelPage.leftMenuButtonAdmin.click();
		extentTest.info("Menü ikonu ile soldan açılır menüyü açar.");
		adminPanelPage.leftMenuCompaniesButtonAdmin.click();
		extentTest.info("Açılan bölümden Companies seçeneğine tıklar.");
		RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
		String[] sonucYaziDizisi = adminPanelPage.companiesShowingEntryText.getText().split(" ");
		List<WebElement> tabloToplamSatirlar = new ArrayList<>(adminPanelPage.companiesTabloSatirlarList);
		extentTest.info("Sayfa sonuna gidip diğer sayfalarıda kontrol eder.");

		while (!sonucYaziDizisi[3].equals(sonucYaziDizisi[5])) {
			adminPanelPage.companiesNextPageButton.click();
			RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
			tabloToplamSatirlar.addAll(adminPanelPage.companiesTabloSatirlarList);
			sonucYaziDizisi = adminPanelPage.companiesShowingEntryText.getText().split(" ");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tabloToplamSatirlar.size() == Integer.parseInt(sonucYaziDizisi[3]));
		extentTest.pass("Gösterilen sayıda Company olduğunu test eder.");
		//System.out.println(tabloToplamSatirlar.size());
		softAssert.assertAll();
		extentTest.info("Sayfayı kapatır.");
	}

	@Test
	public void companiesYeniSirketEkleyebilmeTesti_US31_TC02() {
		extentTest = extentReports.createTest("Admin Sayfasi Yeni Company Ekleyebilme Testi", "Admin yeni şirket ekleyebilmeli.");
		AdminPanelPage adminPanelPage = new AdminPanelPage();
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		adminPanelPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		adminPanelPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		adminPanelPage.signinBoxAdmin.click();
		extentTest.info("Geçerli email ve password bilgilerini girerek giriş butonuna tıklar.");

		adminPanelPage.leftMenuButtonAdmin.click();
		extentTest.info("Menü ikonu ile soldan açılır menüyü açar.");
		adminPanelPage.leftMenuCompaniesButtonAdmin.click();
		extentTest.info("Açılan bölümden Companies seçeneğine tıklar.");
		RecepHocaJSUtilities.clickWithJS(Driver.getDriver(), adminPanelPage.companiesAddNewButonu);
		extentTest.info("Add New butonuna tıklar.");

		//jobExplorerProPage.addCompanyUserIdBox.sendKeys(ConfigReader.getProperty("companyUserIdTest"));
		//UserID girilince sayfa hata veriyor!-----------------------------------------------------------------
		adminPanelPage.addCompanyNameBox.sendKeys(ConfigReader.getProperty("companyNameTest"));
		adminPanelPage.addCompanySlugBox.sendKeys(ConfigReader.getProperty("companySlugTest"));
		adminPanelPage.addCompanyHqBox.sendKeys(ConfigReader.getProperty("companyHqTest"));
		adminPanelPage.addCompanyWebUrlBox.sendKeys(ConfigReader.getProperty("companyWebsiteUrlTest"));
		adminPanelPage.addCompanyEmailBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		adminPanelPage.addCompanyDescriptionBox.sendKeys(ConfigReader.getProperty("companyDescriptionTest"));
		extentTest.info("Name, Slug, Hq, WebsiteUrl, Email ve Description bilgilerini girer.");
		adminPanelPage.addCompanySaveButton.click();
		extentTest.info("Save butonuna tıklar.");

		Select selectBaslik = new Select(adminPanelPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");
		extentTest.info("Arama kutusunda default User Id yazan dropdown menüden Email seçeneğini seçer.");

		Select selectEsit = new Select(adminPanelPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");
		extentTest.info("Arama kutusunda default contains yazan dropdown menüden eşitlik simgesini seçer.");

		adminPanelPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		extentTest.info("Placeholderda Search yazan kutuya eklediği şirketin Email adresini yazar.");
		adminPanelPage.companyAramaSearchIcon.click();
		extentTest.info("Arama mercek iconuna tıklar.");

		List<String> isimlerStrList = new ArrayList<>(ReusableMethods.stringListeCevir(adminPanelPage.companiesNameList));
		/*if (isimlerStrList.contains(ConfigReader.getProperty("companyNameTest"))) {
			System.out.println("Company Ekleme BAşarılı...");
		}

		 */
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isimlerStrList.contains(ConfigReader.getProperty("companyNameTest")), "Eklenen şirket bulunamadı!");
		extentTest.pass("Sonuçlarda eklemiş olduğu şirketin göründüğünü test eder.");
		softAssert.assertAll();
		extentTest.info("Sayfayı kapatır.");
	}

	@Test(dependsOnMethods = "companiesYeniSirketEkleyebilmeTesti_US31_TC02")
	public void eklenenSirketBilgileriniGuncellemeTesti_US31_TC03() {
		extentTest = extentReports.createTest("Admin Sayfası Eklenen Company Düzenleme Testi", "Admin eklediği şirket bilgilerini güncelleyebilmeli.");
		AdminPanelPage adminPanelPage = new AdminPanelPage();
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		adminPanelPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		adminPanelPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		adminPanelPage.signinBoxAdmin.click();
		extentTest.info("Geçerli email ve password bilgilerini girerek giriş butonuna tıklar.");

		adminPanelPage.leftMenuButtonAdmin.click();
		extentTest.info("Menü ikonu ile soldan açılır menüyü açar.");
		adminPanelPage.leftMenuCompaniesButtonAdmin.click();
		extentTest.info("Açılan bölümden Companies seçeneğine tıklar.");
		Select selectBaslik = new Select(adminPanelPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");
		extentTest.info("Arama kutusunda default User Id yazan dropdown menüden Email seçeneğini seçer.");

		Select selectEsit = new Select(adminPanelPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");
		extentTest.info("Arama kutusunda default contains yazan dropdown menüden eşitlik simgesini seçer.");

		adminPanelPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		extentTest.info("Placeholderda Search yazan kutuya değişiklik yapmak istediği şirketin Email adresini yazar.");
		adminPanelPage.companyAramaSearchIcon.click();
		extentTest.info("Arama mercek iconuna tıklar.");

		String dinamikNameXpath;
		String dinamikXpathEditButton;

		for (int i = 1; i <= adminPanelPage.companiesTabloSatirlarList.size(); i++) {
			dinamikNameXpath = "//tbody/tr[" + i + "]/td[4]";
			dinamikXpathEditButton = "//tbody/tr[" + i + "]/td[8]/a[2]";
			if (Driver.getDriver().findElement(By.xpath(dinamikNameXpath)).getText().equals(ConfigReader.getProperty("companyNameTest"))) {
				Driver.getDriver().findElement(By.xpath(dinamikXpathEditButton)).click();
			}
		}
		extentTest.info("Bulunan sonuçlarda değişiklik yapmak istediği şirketin yanında bulunan Edit butonuna tıklar.");
		//jobExplorerProPage.addCompanyUserIdBox.clear();
		//jobExplorerProPage.addCompanyUserIdBox.sendKeys(ConfigReader.getProperty("companyUserIdEditTest"));
		//UserID girilince sayfa hata veriyor!-----------------------------------------------------------------
		adminPanelPage.addCompanyNameBox.clear();
		adminPanelPage.addCompanyNameBox.sendKeys(ConfigReader.getProperty("companyNameEditTest"));
		adminPanelPage.addCompanySlugBox.clear();
		adminPanelPage.addCompanySlugBox.sendKeys(ConfigReader.getProperty("companySlugEditTest"));
		adminPanelPage.addCompanyHqBox.clear();
		adminPanelPage.addCompanyHqBox.sendKeys(ConfigReader.getProperty("companyHqEditTest"));
		adminPanelPage.addCompanyWebUrlBox.clear();
		adminPanelPage.addCompanyWebUrlBox.sendKeys(ConfigReader.getProperty("companyWebsiteUrlEditTest"));
		adminPanelPage.addCompanyEmailBox.clear();
		adminPanelPage.addCompanyEmailBox.sendKeys(ConfigReader.getProperty("companyEmailEditTest"));
		adminPanelPage.addCompanyDescriptionBox.clear();
		adminPanelPage.addCompanyDescriptionBox.sendKeys(ConfigReader.getProperty("companyDescriptionEditTest"));
		extentTest.info("Name, Slug, Hq, WebsiteUrl, Email ve Description bilgilerini günceller.");
		adminPanelPage.addCompanySaveButton.click();
		extentTest.info("Save butonuna tıklar.");

		selectBaslik = new Select(adminPanelPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");
		extentTest.info("Arama kutusunda default User Id yazan dropdown menüden Email seçeneğini seçer.");

		selectEsit = new Select(adminPanelPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");
		extentTest.info("Arama kutusunda default contains yazan dropdown menüden eşitlik simgesini seçer.");

		adminPanelPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailEditTest"));
		extentTest.info("Placeholderda Search yazan kutuya güncellediği şirket Email adresini yazar.");
		adminPanelPage.companyAramaSearchIcon.click();
		extentTest.info("Arama mercek iconuna tıklar.");

		List<String> isimlerStrList = new ArrayList<>(ReusableMethods.stringListeCevir(adminPanelPage.companiesNameList));
		if (isimlerStrList.contains(ConfigReader.getProperty("companyEmailEditTest"))) {
			System.out.println("Company Editleme Başarılı...");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isimlerStrList.contains(ConfigReader.getProperty("companyNameEditTest")), "Düzenlenen şirket bulunamadı!");
		extentTest.pass("Sonuçlarda güncellenmiş şirket bilgilerinin göründüğünü test eder.");
		softAssert.assertAll();
		extentTest.info("Sayfayı kapatır.");


	}

	@Test(dependsOnMethods = "companiesYeniSirketEkleyebilmeTesti_US31_TC02")
	public void istenenSirketBilgileriniSilmeTesti() {
		extentTest = extentReports.createTest("Admin Sayfasi Company Silme Testi", "Admin istediği şirketi silebilmeli.");
		AdminPanelPage adminPanelPage = new AdminPanelPage();
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		adminPanelPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		adminPanelPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		adminPanelPage.signinBoxAdmin.click();
		extentTest.info("Geçerli email ve password bilgilerini girerek giriş butonuna tıklar.");

		adminPanelPage.leftMenuButtonAdmin.click();
		extentTest.info("Menü ikonu ile soldan açılır menüyü açar");
		adminPanelPage.leftMenuCompaniesButtonAdmin.click();
		extentTest.info("Açılan bölümden Companies seçeneğine tıklar.");
		Select selectBaslik = new Select(adminPanelPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");
		extentTest.info("Arama kutusunda default User Id yazan dropdown menüden Email seçeneğini seçer.");

		Select selectEsit = new Select(adminPanelPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");
		extentTest.info("Arama kutusunda default contains yazan dropdown menüden eşitlik simgesini seçer.");

		adminPanelPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		extentTest.info("Placeholderda Search yazan kutuya silmek istediği şirketin Email adresini yazar.");
		adminPanelPage.companyAramaSearchIcon.click();
		extentTest.info("Arama mercek iconuna tıklar.");

		//Class olarak çalıştırıldığında eklenen şirket bilgilerinin güncellenmiş olabileceğinden dolayı
		//Eğer normal email adresi ile kayıt bulamaz ise güncellenmiş şirket email adresi ile arama yapmak için yazılmıştır.
		System.out.println(adminPanelPage.companiesShowingEntryText.getText().replaceAll("\\D", ""));
		if (adminPanelPage.companiesShowingEntryText.getText().replaceAll("\\D", "").equals("0")) {
			adminPanelPage.companyAramaSearchTextBox.clear();
			adminPanelPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailEditTest"));
			adminPanelPage.companyAramaSearchIcon.click();
		}

		String dinamikNameXpath;
		String dinamikXpathDeleteButton;

		for (int i = 1; i <= adminPanelPage.categoriesTabloIsimList.size(); i++) {
			dinamikNameXpath = "//tbody/tr[" + i + "]/td[4]";
			dinamikXpathDeleteButton = "//tbody/tr[" + i + "]/td[8]/a[1]";
			if (Driver.getDriver().findElement(By.xpath(dinamikNameXpath)).getText().equals(ConfigReader.getProperty("companyNameTest"))) {
				Driver.getDriver().findElement(By.xpath(dinamikXpathDeleteButton)).click();
				extentTest.info("Arama sonucunda çıkan şirket bilgilerinin yanında bulunan Delete butonuna tıklar.");
			}
			if (Driver.getDriver().findElement(By.xpath(dinamikNameXpath)).getText().equals(ConfigReader.getProperty("companyNameEditTest"))) {
				Driver.getDriver().findElement(By.xpath(dinamikXpathDeleteButton)).click();
				extentTest.info("Arama sonucunda çıkan şirket bilgilerinin yanında bulunan Delete butonuna tıklar.");
			}

		}
		adminPanelPage.companySilmePopupOnayButton.click();
		extentTest.info("Silme onayı için açılan Pop-up tan Yes Delete It seçeneğini seçer.");

		selectBaslik = new Select(adminPanelPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");
		extentTest.info("Arama kutusunda default User Id yazan dropdown menüden Email seçeneğini seçer.");
		selectEsit = new Select(adminPanelPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");
		extentTest.info("Arama kutusunda default contains yazan dropdown menüden eşitlik simgesini seçer.");
		adminPanelPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		extentTest.info("Placeholderda Search yazan kutuya sildiği şirketin Email adresini yazar.");
		adminPanelPage.companyAramaSearchIcon.click();
		extentTest.info("Arama mercek iconuna tıklar.");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(adminPanelPage.companiesShowingEntryText.getText().replaceAll("\\D", "").equals("0"));
		extentTest.pass("Arama sonucunda sildiği şirketin görünmediğini test eder.");


		adminPanelPage.companyAramaSearchTextBox.clear();
		adminPanelPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailEditTest"));
		adminPanelPage.companyAramaSearchIcon.click();
		extentTest.info("Arama kutusu Email bölümüne editlenmiş şirket mail adresini girer.");
		softAssert.assertTrue(adminPanelPage.companiesShowingEntryText.getText().replaceAll("\\D", "").equals("0"));
		extentTest.pass("Arama sonucunda editlenmiş şirket bilgilerinin görünmediğini test eder.");
		//softAssert.assertTrue(jobExplorerProPage.companiesNameList.isEmpty());
		softAssert.assertAll();
		extentTest.info("Sayfayı kapatır.");


	}


}
