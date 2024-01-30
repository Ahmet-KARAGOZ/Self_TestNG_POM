package tests.day18_SoftAssertions_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
//1. “http://zero.webappsecurity.com/” Adresine gidin
// 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
// 3. Sign in butonuna basin
// 4. Login kutusuna “username” yazin
// 5. Password kutusuna “password” yazin
// 6. Sign in tusuna basin
// 7. Back tusuna basin
// 8. Giris yapilabildigini dogrulayin
// 9. Online banking menusunu tiklayin
//10. Pay Bills sayfasina gidin
//11. “Purchase Foreign Currency” tusuna basin
//12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
//13. “Currency” dropdown menusunden Eurozone’u secin
//14. "Eurozone (euro)" secildigini dogrulayin
//15. Dropdown menude 16 option bulundugunu dogrulayin.
//16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
//17. Sayfayi kapatin

public class C02_WebAppTesti {
	@Test
	public void test01(){
		Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

		String expURL = "http://zero.webappsecurity.com/";
		String actURL = Driver.getDriver().getCurrentUrl();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actURL,expURL,"URL Testi");

		ZeroWebPage zeroWebPage = new ZeroWebPage();
		zeroWebPage.signInLinki.click();

		zeroWebPage.userNameKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUserName"));
		zeroWebPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));
		zeroWebPage.signInButonu.click();

		Driver.getDriver().navigate().back();

		softAssert.assertTrue(zeroWebPage.loginDogrulama.isDisplayed(),"Giris yapıldı Testi Failed");

		zeroWebPage.onlineBankingLinki.click();

		zeroWebPage.payBillsLinki.click();

		zeroWebPage.purchaseForeignCurrencyTab.click();

		softAssert.assertTrue(zeroWebPage.pcCurrencyDropdown.isEnabled());

		Select select = new Select(zeroWebPage.pcCurrencyDropdown);
		select.selectByValue("EUR");

		String expSecilenOption = "Eurozone (euro)";
		String actSecilenOption = select.getFirstSelectedOption().getText();

		softAssert.assertEquals(actSecilenOption,expSecilenOption,"EuroZone secim Testi Failed");


		int expOptionSayisi = 16;
		int actOptionSayisi = select.getOptions().size();
		softAssert.assertEquals(actOptionSayisi,expOptionSayisi,"DropdownOption Sayi Testi Failed");

		List<WebElement> dropdownOptionElementleriList = select.getOptions();
		List<String> dropdownOptionsListesiString = ReusableMethods.stringListeCevir(dropdownOptionElementleriList);

		String expOptionIcerigi = "Canada (dollar)";
		softAssert.assertTrue(dropdownOptionsListesiString.contains(expOptionIcerigi),"Kanada Testi Failed");

		softAssert.assertAll();

		Driver.quitDriver();





































	}
}
