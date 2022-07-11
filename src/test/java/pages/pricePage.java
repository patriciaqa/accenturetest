package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pricePage {
		
	protected WebDriver driver;

	private By opt_price_gold = By.xpath("//*[@id=\'priceTable\']/tfoot/tr/th[2]/label[2]/span");
	private By slt_pricedata = By.id("selectpriceoption");
	private By shw_counter = By.className("counter");
	private By btn_next = By.id("nextsendquote");

	public pricePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void markPrice() throws InterruptedException {
		// mark Price [gold]default
		WebElement check_price = driver.findElement(opt_price_gold);
		check_price.click();
		TimeUnit.SECONDS.sleep(2);
	}
	
	public void checkFillDataPrice() {
		WebElement countprice = driver.findElement(slt_pricedata).findElement(shw_counter);
		String countprice_str = countprice.getText();
		int countprice_int = Integer.parseInt(countprice_str);
		if (countprice_int == 0) {
			driver.findElement(btn_next).click();
		}
	}
}
