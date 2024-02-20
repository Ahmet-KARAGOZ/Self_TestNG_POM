package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class JobExplorerProPage {
	public JobExplorerProPage(){
		PageFactory.initElements(Driver.getDriver() , this);
	}

	//US21 Locateler....
	@FindBy(xpath = "//*[@id='email']") public WebElement emailBoxAdmin;
	@FindBy(xpath = "//*[@name='password']") public WebElement passwordBoxAdmin;
	@FindBy(xpath = "//*[@class='signin']") public WebElement signinBoxAdmin;

	//--------- burdan sonraki locate ler kendi aldıklarım excel dosyasına eklenecek ---------

	//US21 için  aldığım locateler Ahmet

	@FindBy(xpath = "//h1[@class='page-title']")
	public WebElement adminDashboardPlatformStatisticsText; //Ahmet
	@FindBy(xpath = "//*[text()='Last 24 hours']")
	public WebElement adminDashboardLast24HoursText; //Ahmet
	@FindBy(xpath = "//*[text()='Payments']")
	public WebElement adminDashboardPaymentsText;//Ahmet
	@FindBy(xpath = "//*[text()='Content']")
	public WebElement adminDashboardContentText; //Ahmet
	@FindBy(xpath = "//*[text()='New users']")
	public WebElement adminDashboardNewUsersText;  //Ahmet
	@FindBy(xpath = "//*[text()='Users roles']")
	public WebElement adminDashboardUsersRolesText;  //Ahmet
	@FindBy(xpath = "//*[text()='Registered users']")
	public WebElement adminDashboardRegisteredUsersText;  //Ahmet
	@FindBy(xpath = "//input[@name='remember']")
	public WebElement adminDashboardBeniHatirlaCheckBox;  //Ahmet
	@FindBy(xpath = "//label[@for='remember']")
	public WebElement adminDashboardBeniHatirlaYazisi;  //Ahmet

	//US21 için alınan locate lerin sonu

	//US25 için ortak kullandığım locateler...
	@FindBy(xpath = "//*[@class='hamburger btn-link']")
	public WebElement leftMenuButtonAdmin;
	@FindBy(xpath = "//*[@href='#41-dropdown-element']")
	public WebElement leftMenuJobsButtonAdmin;

	//US 25 Kendi aldığım locateler
	@FindBy(xpath = "//span[@class='icon voyager-categories']")
	public WebElement leftMenuCategoriesIconuAdmin;  //Ahmet
	@FindBy(xpath = "//h1[@class='page-title']")
	public WebElement categoiresSayfaBasligiText;  //Ahmet
	@FindBy(xpath = "//a[@rel='next']")
	public WebElement categoriesNextPageIconu;  //Ahmet
	@FindBy(xpath = "//div[@class='show-res']")
	public WebElement categoriesSonucYazisi;  //Ahmet
	@FindBy(xpath = "//tbody/tr")
	public List<WebElement> categoriesTabloSatirlarListesi; //Ahmet
	@FindBy(xpath = "//a[@class='btn btn-success btn-add-new']")
	public WebElement categoriesAddNewButton;  //Ahmet
	@FindBy(xpath = "//input[@name='name']")
	public WebElement addCategoryNameBox; //Ahmet
	@FindBy(xpath = "//input[@name='slogan']")
	public WebElement addCategorySloganBox;  //Ahmet
	@FindBy(xpath = "//input[@name='description']")
	public WebElement addCategoryDescriptionBox;  //Ahmet
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement addCategorySaveButton; //Ahmet
	@FindBy(xpath = "//tbody/tr/td[2]")
	public List<WebElement> categoriesTabloIsimList;  //Ahmet
	@FindBy(xpath = "(//div[@class='panel-body'])[5]")
	public WebElement viewingCategoryNameText;  //Ahmet
	@FindBy(xpath = "//input[@name='name']")
	public WebElement editCategoryNameBox;  //Ahmet
	@FindBy(xpath = "//input[@name='slogan']")
	public WebElement editCategorySloganBox;  //Ahmet
	@FindBy(xpath = "//input[@name='description']")
	public WebElement editCategoryDescritionBox;  //Ahmet
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement editCategorySaveButton;  //Ahmet
	@FindBy(xpath = "//input[@value='Yes, Delete it!']")
	public WebElement categorySilmePopupOnayButton;  //Ahmet

	//US31 için locateler
	@FindBy(xpath = "//span[@class='icon voyager-company']")
	public WebElement leftMenuCompaniesButtonAdmin;  //Ahmet
	@FindBy(xpath = "//div[@class='show-res']")
	public WebElement companiesShowingEntryText; //Ahmet
	@FindBy(xpath = "//tbody/tr")
	public List<WebElement> companiesTabloSatirlarList; //Ahmet
	@FindBy(xpath = "//a[@rel='next']")
	public WebElement companiesNextPageButton;  //Ahmet
	@FindBy(xpath = "//a[@class='btn btn-success btn-add-new']")
	public WebElement companiesAddNewButonu;  //Ahmet
	@FindBy(xpath = "//input[@name='user_id']")
	public WebElement addCompanyUserIdBox; //Ahmet
	@FindBy(xpath = "//input[@name='name']")
	public WebElement addCompanyNameBox;  //Ahmet
	@FindBy(xpath = "//input[@name='slug']")
	public WebElement addCompanySlugBox;  //Ahmet
	@FindBy(xpath = "//input[@name='hq']")
	public WebElement addCompanyHqBox; //Ahmet
	@FindBy(xpath = "//input[@name='website_url']")
	public WebElement addCompanyWebUrlBox;  //Ahmet
	@FindBy(xpath = "//input[@name='email']")
	public WebElement addCompanyEmailBox;  //Ahmet
	@FindBy(xpath = "//input[@name='description']")
	public WebElement addCompanyDescriptionBox;  //Ahmet
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement addCompanySaveButton;  //Ahmet
	@FindBy(xpath = "//select[@id='search_key']")
	public WebElement companyAranacakBaslikDropdown; //Ahmet
	@FindBy(xpath = "//select[@id='filter']")
	public WebElement companyAramaEsitlemeContainsDropDown;  //Ahmet
	@FindBy(xpath = "//input[@name='s']")
	public WebElement companyAramaSearchTextBox;  //Ahmet
	@FindBy(xpath = "//button[@class='btn btn-info btn-lg']")
	public WebElement companyAramaSearchIcon; //Ahmet
	@FindBy(xpath = "//tbody/tr/td[4]")
	public List<WebElement> companiesNameList;  //Ahmet
	@FindBy(xpath = "//input[@value='Yes, Delete it!']")
	public WebElement companySilmePopupOnayButton;  //Ahmet

	//US_31 için locatelerin sonu
















}
