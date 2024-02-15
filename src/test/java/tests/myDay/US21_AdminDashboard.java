package tests.myDay;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JobExplorerProPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US21_AdminDashboard extends TestBaseRapor {
	@Test
	public void adminLoginSayfasiErisimTesti_US21_TC01() {
		extentTest = extentReports.createTest("Admin Sayfasi Erisim Testi", "Tanimli URL bilgisi ile Admin Login Sayfasina Erisilebilmeli");
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		SoftAssert softAssert = new SoftAssert();

		JobExplorerProPage jobExplorerProPage = new JobExplorerProPage();

		softAssert.assertTrue(jobExplorerProPage.emailBoxAdmin.isDisplayed());
		extentTest.pass("Admin Login sayfasi e-mail kutusunun görünür oldugunu test eder.");

		softAssert.assertTrue(jobExplorerProPage.passwordBoxAdmin.isDisplayed());
		extentTest.pass("Admin Login sayfasi password kutusunun görünür oldugunu test eder.");

		softAssert.assertTrue(jobExplorerProPage.signinBoxAdmin.isDisplayed());
		extentTest.pass("Admin Login sayfasi Giriş butonunun görünür oldugunu test eder.");

		softAssert.assertTrue(jobExplorerProPage.adminDashboardBeniHatirlaCheckBox.isDisplayed());
		extentTest.pass("Admin Login sayfasi Beni Hatırla CheckBox görünürlüğünü test eder.");

		softAssert.assertTrue(jobExplorerProPage.adminDashboardBeniHatirlaYazisi.isDisplayed());
		extentTest.pass("Admin Login sayfasi Beni Hatırla Yazısının görünür oldugunu test eder.");

		softAssert.assertAll();

		//Driver.quitDriver();
		extentTest.info("Sayfayı kapatır.");

		/*

		Assert.assertTrue(jobExplorerProPage.adminDashboardPlatformStatisticsText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardLast24HoursText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardPaymentsText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardContentText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardNewUsersText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardUsersRolesText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardRegisteredUsersText.isDisplayed());

		 */  //Assertler

		/*
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(jobExplorerProPage.adminDashboardPlatformStatisticsText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardLast24HoursText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardPaymentsText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardContentText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardNewUsersText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardUsersRolesText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardRegisteredUsersText.isDisplayed());

		softAssert.assertAll();

		 */ //SoftAssertler

	}

	@Test
	public void adminDashboardErisimTesti_US21_TC02() {
		extentTest = extentReports.createTest("Admin Dashboard Erisim Testi", "Gecerli Kullanıcı Bilgileri ile Admin Dashboard Sayfasina Erisilebilmeli");
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		JobExplorerProPage jobExplorerProPage = new JobExplorerProPage();

		jobExplorerProPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		extentTest.info("Geçerli Admin E-posta bilgisi girilir.");

		jobExplorerProPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		extentTest.info("Geçerli Admin password bilgisi girilir.");

		jobExplorerProPage.signinBoxAdmin.click();
		extentTest.info("Giriş Butonuna tıklanır.");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(jobExplorerProPage.adminDashboardPlatformStatisticsText.isDisplayed());
		extentTest.pass("Admin Dashboard sayfasında olunduğu test edilir.");
		softAssert.assertAll();

		Driver.quitDriver();
		extentTest.info("Sayfayı kapatır.");
	}

	@Test
	public void adminDashboardPlatformIstatistikleriGoruntulemeTesti_US21_TC03() {
		extentTest = extentReports.createTest("Admin Dashboard Platform Istatistikleri Görüntüleyebilme Testi", "ILgiili Platform Istatistikleri Görüntülenebilmeli");
		Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
		extentTest.info("Jobexplorerpro Admin Login sayfasına gider.");
		JobExplorerProPage jobExplorerProPage = new JobExplorerProPage();

		jobExplorerProPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminEmail"));
		extentTest.info("Geçerli Admin E-posta bilgisi girilir.");

		jobExplorerProPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("ahmetAdminPassword"));
		extentTest.info("Geçerli Admin password bilgisi girilir.");

		jobExplorerProPage.signinBoxAdmin.click();
		extentTest.info("Giriş Butonuna tıklanır.");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(jobExplorerProPage.adminDashboardLast24HoursText.isDisplayed());
		extentTest.pass("Last 24 Hours bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(jobExplorerProPage.adminDashboardPaymentsText.isDisplayed());
		extentTest.pass("Payments bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(jobExplorerProPage.adminDashboardContentText.isDisplayed());
		extentTest.pass("Content bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(jobExplorerProPage.adminDashboardNewUsersText.isDisplayed());
		extentTest.pass("New Users bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(jobExplorerProPage.adminDashboardUsersRolesText.isDisplayed());
		extentTest.pass("User roles bilgilerinin görünürlüğü test edilir.");

		softAssert.assertTrue(jobExplorerProPage.adminDashboardRegisteredUsersText.isDisplayed());
		extentTest.pass("Registered users bilgilerinin görünürlüğü test edilir.");
		softAssert.assertAll();

		Driver.quitDriver();
		extentTest.info("Sayfayı kapatır.");


	}


}
