package tests.myDay;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JobExplorerProPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US21_AdminDashboard {
	@Test
	public void DashBoardKontrolTesti(){
		Driver.getDriver().get(ConfigReader.getProperty("jobExploreProUrlAdminUrl"));

		JobExplorerProPage jobExplorerProPage = new JobExplorerProPage();
		jobExplorerProPage.emailBoxAdmin.sendKeys(ConfigReader.getProperty("jobExplorerGecerliAdminUserName"));
		jobExplorerProPage.passwordBoxAdmin.sendKeys(ConfigReader.getProperty("jobExplorerGecerliAdminPassword"));
		jobExplorerProPage.signinBoxAdmin.click();

		/*

		Assert.assertTrue(jobExplorerProPage.adminDashboardPlatformStatisticsText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardLast24HoursText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardPaymentsText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardContentText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardNewUsersText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardUsersRolesText.isDisplayed());
		Assert.assertTrue(jobExplorerProPage.adminDashboardRegisteredUsersText.isDisplayed());

		 */

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(jobExplorerProPage.adminDashboardPlatformStatisticsText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardLast24HoursText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardPaymentsText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardContentText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardNewUsersText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardUsersRolesText.isDisplayed());
		softAssert.assertTrue(jobExplorerProPage.adminDashboardRegisteredUsersText.isDisplayed());

		softAssert.assertAll();

		Driver.quitDriver();







	}
}
