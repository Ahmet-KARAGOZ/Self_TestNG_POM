package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JobExplorerProPage {
	public JobExplorerProPage(){
		PageFactory.initElements(Driver.getDriver() , this);
	}

	@FindBy(xpath = "//*[@id='email']") public WebElement emailBoxAdmin;
	@FindBy(xpath = "//*[@name='password']") public WebElement passwordBoxAdmin;
	@FindBy(xpath = "//*[@class='signin']") public WebElement signinBoxAdmin;

	//--------- burdan sonraki locate ler kendi aldıklarım excel dosyasına eklenecek ---------

	//US21 için alınan locate ler

	@FindBy(xpath = "//h1[@class='page-title']") public WebElement adminDashboardPlatformStatisticsText;
	@FindBy(xpath = "//*[text()='Last 24 hours']") public WebElement adminDashboardLast24HoursText;
	@FindBy(xpath = "//*[text()='Payments']") public WebElement adminDashboardPaymentsText;
	@FindBy(xpath = "//*[text()='Content']") public WebElement adminDashboardContentText;
	@FindBy(xpath = "//*[text()='New users']") public WebElement adminDashboardNewUsersText;
	@FindBy(xpath = "//*[text()='Users roles']") public WebElement adminDashboardUsersRolesText;
	@FindBy(xpath = "//*[text()='Registered users']") public WebElement adminDashboardRegisteredUsersText;
	@FindBy(xpath = "//input[@name='remember']") public WebElement adminDashboardBeniHatirlaCheckBox;
	@FindBy(xpath = "//label[@for='remember']") public WebElement adminDashboardBeniHatirlaYazisi;

	//US21 için alınan locate lerin sonu






}
