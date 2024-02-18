package tests.myDay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JobExplorerProPage;
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
		jobExplorerProPage.leftMenuCompaniesButtonAdmin.click();

		RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
		String[] sonucYaziDizisi = jobExplorerProPage.companiesShowingEntryText.getText().split(" ");
		List<WebElement> tabloToplamSatirlar = new ArrayList<>(jobExplorerProPage.companiesTabloSatirlarList);

		while (!sonucYaziDizisi[3].equals(sonucYaziDizisi[5])) {
			jobExplorerProPage.companiesNextPageButton.click();
			RecepHocaJSUtilities.scrollToBottom(Driver.getDriver());
			tabloToplamSatirlar.addAll(jobExplorerProPage.companiesTabloSatirlarList);
			sonucYaziDizisi = jobExplorerProPage.companiesShowingEntryText.getText().split(" ");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tabloToplamSatirlar.size() == Integer.parseInt(sonucYaziDizisi[3]));
		//System.out.println(tabloToplamSatirlar.size());
		softAssert.assertAll();
	}

	@Test
	public void companiesYeniSirketEkleyebilmeTesti_US31_TC02() {
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
		jobExplorerProPage.leftMenuCompaniesButtonAdmin.click();

		RecepHocaJSUtilities.clickWithJS(Driver.getDriver(), jobExplorerProPage.companiesAddNewButonu);

		//jobExplorerProPage.addCompanyUserIdBox.sendKeys(ConfigReader.getProperty("companyUserIdTest"));
		//UserID girilince sayfa hata veriyor!-----------------------------------------------------------------
		jobExplorerProPage.addCompanyNameBox.sendKeys(ConfigReader.getProperty("companyNameTest"));
		jobExplorerProPage.addCompanySlugBox.sendKeys(ConfigReader.getProperty("companySlugTest"));
		jobExplorerProPage.addCompanyHqBox.sendKeys(ConfigReader.getProperty("companyHqTest"));
		jobExplorerProPage.addCompanyWebUrlBox.sendKeys(ConfigReader.getProperty("companyWebsiteUrlTest"));
		jobExplorerProPage.addCompanyEmailBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		jobExplorerProPage.addCompanyDescriptionBox.sendKeys(ConfigReader.getProperty("companyDescriptionTest"));
		jobExplorerProPage.addCompanySaveButton.click();

		Select selectBaslik = new Select(jobExplorerProPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");

		Select selectEsit = new Select(jobExplorerProPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");

		jobExplorerProPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		jobExplorerProPage.companyAramaSearchIcon.click();

		List<String> isimlerStrList = new ArrayList<>(ReusableMethods.stringListeCevir(jobExplorerProPage.companiesNameList));
		if (isimlerStrList.contains(ConfigReader.getProperty("companyNameTest"))) {
			System.out.println("Company Ekleme BAşarılı...");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isimlerStrList.contains(ConfigReader.getProperty("companyNameTest")), "Eklenen şirket bulunamadı!");
		softAssert.assertAll();
	}

	@Test(dependsOnMethods = "companiesYeniSirketEkleyebilmeTesti_US31_TC02")
	public void eklenenSirketBilgileriniGuncellemeTesti_US31_TC03() {
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
		jobExplorerProPage.leftMenuCompaniesButtonAdmin.click();

		Select selectBaslik = new Select(jobExplorerProPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");

		Select selectEsit = new Select(jobExplorerProPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");

		jobExplorerProPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		jobExplorerProPage.companyAramaSearchIcon.click();

		String dinamikNameXpath;
		String dinamikXpathEditButton;

		for (int i = 1; i <= jobExplorerProPage.categoriesTabloIsimList.size(); i++) {
			dinamikNameXpath = "//tbody/tr[" + i + "]/td[4]";
			dinamikXpathEditButton = "//tbody/tr[" + i + "]/td[8]/a[2]";
			if (Driver.getDriver().findElement(By.xpath(dinamikNameXpath)).getText().equals(ConfigReader.getProperty("companyNameTest"))) {
				Driver.getDriver().findElement(By.xpath(dinamikXpathEditButton)).click();
			}
		}
		//jobExplorerProPage.addCompanyUserIdBox.clear();
		//jobExplorerProPage.addCompanyUserIdBox.sendKeys(ConfigReader.getProperty("companyUserIdEditTest"));
		//UserID girilince sayfa hata veriyor!-----------------------------------------------------------------
		jobExplorerProPage.addCompanyNameBox.clear();
		jobExplorerProPage.addCompanyNameBox.sendKeys(ConfigReader.getProperty("companyNameEditTest"));
		jobExplorerProPage.addCompanySlugBox.clear();
		jobExplorerProPage.addCompanySlugBox.sendKeys(ConfigReader.getProperty("companySlugEditTest"));
		jobExplorerProPage.addCompanyHqBox.clear();
		jobExplorerProPage.addCompanyHqBox.sendKeys(ConfigReader.getProperty("companyHqEditTest"));
		jobExplorerProPage.addCompanyWebUrlBox.clear();
		jobExplorerProPage.addCompanyWebUrlBox.sendKeys(ConfigReader.getProperty("companyWebsiteUrlEditTest"));
		jobExplorerProPage.addCompanyEmailBox.clear();
		jobExplorerProPage.addCompanyEmailBox.sendKeys(ConfigReader.getProperty("companyEmailEditTest"));
		jobExplorerProPage.addCompanyDescriptionBox.clear();
		jobExplorerProPage.addCompanyDescriptionBox.sendKeys(ConfigReader.getProperty("companyDescriptionEditTest"));
		jobExplorerProPage.addCompanySaveButton.click();

	}

	@Test(dependsOnMethods = "companiesYeniSirketEkleyebilmeTesti_US31_TC02")
	public void istenenSirketBilgileriniSilmeTesti() {
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
		jobExplorerProPage.leftMenuCompaniesButtonAdmin.click();

		Select selectBaslik = new Select(jobExplorerProPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");

		Select selectEsit = new Select(jobExplorerProPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");

		jobExplorerProPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		jobExplorerProPage.companyAramaSearchIcon.click();
		System.out.println(jobExplorerProPage.companiesShowingEntryText.getText().replaceAll("\\D", ""));
		if (jobExplorerProPage.companiesShowingEntryText.getText().replaceAll("\\D", "").equals("0")) {
			jobExplorerProPage.companyAramaSearchTextBox.clear();
			jobExplorerProPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailEditTest"));
			jobExplorerProPage.companyAramaSearchIcon.click();
		}

		String dinamikNameXpath;
		String dinamikXpathDeleteButton;

		for (int i = 1; i <= jobExplorerProPage.categoriesTabloIsimList.size(); i++) {
			dinamikNameXpath = "//tbody/tr[" + i + "]/td[4]";
			dinamikXpathDeleteButton = "//tbody/tr[" + i + "]/td[8]/a[1]";
			if (Driver.getDriver().findElement(By.xpath(dinamikNameXpath)).getText().equals(ConfigReader.getProperty("companyNameTest"))) {
				Driver.getDriver().findElement(By.xpath(dinamikXpathDeleteButton)).click();
			}
			if (Driver.getDriver().findElement(By.xpath(dinamikNameXpath)).getText().equals(ConfigReader.getProperty("companyNameEditTest"))) {
				Driver.getDriver().findElement(By.xpath(dinamikXpathDeleteButton)).click();
			}

		}
		jobExplorerProPage.companySilmePopupOnayButton.click();

		selectBaslik = new Select(jobExplorerProPage.companyAranacakBaslikDropdown);
		selectBaslik.selectByValue("email");

		selectEsit = new Select(jobExplorerProPage.companyAramaEsitlemeContainsDropDown);
		selectEsit.selectByValue("equals");

		jobExplorerProPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailTest"));
		jobExplorerProPage.companyAramaSearchIcon.click();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(jobExplorerProPage.companiesShowingEntryText.getText().replaceAll("\\D", "").equals("0"));


		jobExplorerProPage.companyAramaSearchTextBox.clear();
		jobExplorerProPage.companyAramaSearchTextBox.sendKeys(ConfigReader.getProperty("companyEmailEditTest"));
		jobExplorerProPage.companyAramaSearchIcon.click();
		softAssert.assertTrue(jobExplorerProPage.companiesShowingEntryText.getText().replaceAll("\\D", "").equals("0"));
		//softAssert.assertTrue(jobExplorerProPage.companiesNameList.isEmpty());


	}


}
