package tests.day20_CrossBrowserCalısacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

import java.util.List;
//1- https://www.testotomasyonu.com/ anasayfasina gidin
//2- phone icin arama yapin
// 3- Listelenen sonuclardan ilkini tiklayin
//4- urun ismini kaydedin ve sepete ekleyin
//5- your cart linkine tiklayin
//6- kaydettiginiz urun ismi ile sepetteki urun isminin
//   case sensitive olmadan ayni oldugunu test edin

public class C02_CrossBrowserUrunSepetiTesti extends TestBaseCross {
	@Test
	public void urunSepetiTesti(){
		driver.get(ConfigReader.getProperty("toUrl"));
		WebElement aramaKutusu = driver.findElement(By.id("global-search"));
		aramaKutusu.sendKeys("phone" , Keys.ENTER);

		List<WebElement> bulunanElementlerListesi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));
		bulunanElementlerListesi.get(0).click();

		WebElement urunSayfasiUrunIsmiElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
		String urunIsmi = urunSayfasiUrunIsmiElementi.getText();

		WebElement addToCartButonu = driver.findElement(By.xpath("//*[@class='add-to-cart']"));
		addToCartButonu.click();

		WebElement yourCartLinki = driver.findElement(By.xpath("(//*[@class='cart-bar'])[2]"));
		yourCartLinki.click();

		WebElement sepettekiUrunIsimElementi = driver.findElement(By.xpath("//*[@*='product-title text-center']"));

		String sepettekiUrunIsmi = sepettekiUrunIsimElementi.getText();
		Assert.assertEquals(sepettekiUrunIsmi.toLowerCase() , urunIsmi.toLowerCase());

	}
}
