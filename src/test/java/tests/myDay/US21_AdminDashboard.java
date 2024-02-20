package tests.myDay;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPanelPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US21_AdminDashboard extends TestBaseRapor {
	@Test
	public void adminLoginSayfasiErisimTesti_US21_TC01() {
		extentTest = extentReports.createTest("Admin Sayfasi Erisim Testi", "Tanimli URL bilgisi ile Admin Login Sayfasina Erisilebilmeli");
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		SoftAssert softAssert = new SoftAssert();
		AdminPanelPage adminPanelPage = new AdminPanelPage();


		softAssert.assertTrue(adminPanelPage.emailBoxAdmin.isDisplayed() , "E-mail kutusu görüntülenemdi.");
		extentTest.pass("Admin Login sayfasi e-mail kutusunun görünür oldugunu test eder.");

		softAssert.assertTrue(adminPanelPage.passwordBoxAdmin.isDisplayed() , "Password kutusu görüntülenemdi.");
		extentTest.pass("Admin Login sayfasi password kutusunun görünür oldugunu test eder.");

		softAssert.assertTrue(adminPanelPage.signinBoxAdmin.isDisplayed() , "Giris butonu görüntülenemdi.");
		extentTest.pass("Admin Login sayfasi Giriş butonunun görünür oldugunu test eder.");

		softAssert.assertTrue(adminPanelPage.adminDashboardBeniHatirlaCheckBox.isDisplayed() , "Beni hatirla checkboxi görüntülenemdi.");
		extentTest.pass("Admin Login sayfasi Beni Hatırla CheckBox görünürlüğünü test eder.");

		softAssert.assertTrue(adminPanelPage.adminDashboardBeniHatirlaYazisi.isDisplayed() , "Beni hatirla yazisi görüntülenemdi." );
		extentTest.pass("Admin Login sayfasi Beni Hatırla Yazısının görünür oldugunu test eder.");

		softAssert.assertAll();

		//Driver.quitDriver();
		extentTest.info("Sayfayı kapatır.");



	}

	@Test
	public void adminDashboardErisimTesti_US21_TC02() {
		extentTest = extentReports.createTest("Admin Dashboard Erisim Testi", "Gecerli Kullanıcı Bilgileri ile Admin Dashboard Sayfasina Erisilebilmeli");
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		AdminPanelPage adminPanelPage = new AdminPanelPage();


		adminPanelPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		extentTest.info("Geçerli Admin E-posta bilgisi girilir.");

		adminPanelPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		extentTest.info("Geçerli Admin password bilgisi girilir.");

		adminPanelPage.signinBoxAdmin.click();
		extentTest.info("Giriş Butonuna tıklanır.");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(adminPanelPage.adminDashboardPlatformStatisticsText.isDisplayed() , "Admin Dashboard görüntülenemedi.");
		extentTest.pass("Admin Dashboard sayfasında olunduğu test edilir.");
		softAssert.assertAll();

		//Driver.quitDriver();
		extentTest.info("Sayfayı kapatır.");
	}

	@Test
	public void adminDashboardPlatformIstatistikleriGoruntulemeTesti_US21_TC03() {
		extentTest = extentReports.createTest("Admin Dashboard Platform Istatistikleri Görüntüleyebilme Testi", "ILgiili Platform Istatistikleri Görüntülenebilmeli");
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		AdminPanelPage adminPanelPage = new AdminPanelPage();

		adminPanelPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		extentTest.info("Geçerli Admin E-posta bilgisi girilir.");

		adminPanelPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		extentTest.info("Geçerli Admin password bilgisi girilir.");

		adminPanelPage.signinBoxAdmin.click();
		extentTest.info("Giriş Butonuna tıklanır.");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(adminPanelPage.adminDashboardLast24HoursText.isDisplayed() , "Last 24 Hours paneli görünütülenemdi.");
		extentTest.pass("Last 24 Hours bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(adminPanelPage.adminDashboardPaymentsText.isDisplayed() , "Payments paneli görünütülenemdi.");
		extentTest.pass("Payments bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(adminPanelPage.adminDashboardContentText.isDisplayed() , "Content paneli görünütülenemdi.");
		extentTest.pass("Content bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(adminPanelPage.adminDashboardNewUsersText.isDisplayed() , "New users paneli görünütülenemdi.");
		extentTest.pass("New Users bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(adminPanelPage.adminDashboardUsersRolesText.isDisplayed() , "User roles paneli görünütülenemdi.");
		extentTest.pass("User roles bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(adminPanelPage.adminDashboardRegisteredUsersText.isDisplayed() , "Registered users paneli görünütülenemdi.");
		extentTest.pass("Registered users bilgilerinin görünürlüğü test edilir.");
		softAssert.assertAll();

		//Driver.quitDriver();
		extentTest.info("Sayfayı kapatır.");


	}


}
