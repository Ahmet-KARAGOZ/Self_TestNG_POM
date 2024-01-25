package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestOtomasyonPage {
	@FindBy(id = "global-search")
	public WebElement aramaKutusu;

	@FindBy(xpath = "(//a[@class='e-cart'])[1]") public WebElement accountLinki;

	@FindBy(xpath = "//input[@id='email']") public WebElement emailKutusu;

	@FindBy(xpath = "//input[@id='password']") public WebElement passwordKutusu;

	@FindBy(xpath = "//*[@id='submitlogin']") public WebElement loginButonu;

	@FindBy(xpath = "//span[text()='Logout']") public WebElement logoutButonu;
	@FindBy(xpath = "//*[@*='product-box my-2  py-1']") public List<WebElement> bulunanUrunElementleriList;
	@FindBy(xpath = "//div[@class=' heading-sm mb-4']") public WebElement urunSayfasindaUrunIsimElementi;

}