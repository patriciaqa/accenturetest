package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class productPage {
	
	protected WebDriver driver;
	private Random rand = new Random();

	private By txt_startdate = By.id("startdate");
	private By slt_insurancesum = By.id("insurancesum");
	private By slt_meritrating = By.id("meritrating");
	private By slt_damageinsurance = By.id("damageinsurance");
	private By opt_products = By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]/span");
	private By slt_courtesycar = By.id("courtesycar");
	private By cnt_productdata = By.id("enterproductdata");
	private By nbr_counter = By.className("counter");
	private By btn_next = By.id("nextselectpriceoption");

	public productPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillStartDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 60);// to get previous day add 60
		Date nextYear = cal.getTime();
		String dateFutureStr = dateFormat.format(nextYear);

		driver.findElement(txt_startdate).sendKeys(dateFutureStr);
	}

	public void selectInsuranceSum() {
		int index_sum = 8; // generate random values from 0-8
		int random_sum = rand.nextInt(index_sum);
		
		Select sum = new Select(driver.findElement(slt_insurancesum));
		sum.selectByVisibleText("– please select –");
		sum.selectByIndex(random_sum + 1);
	}

	public void selectMeritRating() {
		int index_merit = 18; // generate random values from 0-18
		int random_merit = rand.nextInt(index_merit);
		
		Select merit = new Select(driver.findElement(slt_meritrating));
		merit.selectByVisibleText("– please select –");
		merit.selectByIndex(random_merit + 1);
	}

	public void selectDamageInsurance() {
		int index_damage = 2; // generate random values from 0-2
		int random_damage = rand.nextInt(index_damage);
		
		Select damage = new Select(driver.findElement(slt_damageinsurance));
		damage.selectByVisibleText("– please select –");
		damage.selectByIndex(random_damage + 1);
	}

	public void markOptionalProducts() {
		WebElement check_products = driver.findElement(opt_products);
		check_products.click();
	}

	public void selectCourtesyCar() {
		int index_courtesy = 1; // generate random values from 0-1
		int random_courtesy = rand.nextInt(index_courtesy);
		
		Select courtesy = new Select(driver.findElement(slt_courtesycar));
		courtesy.selectByVisibleText("– please select –");
		courtesy.selectByIndex(random_courtesy + 1);
	}

	public void checkFillDataProduct() {
		WebElement countproduct = driver.findElement(cnt_productdata).findElement(nbr_counter);
		String countproduct_str = countproduct.getText();
		int countproduct_int = Integer.parseInt(countproduct_str);
		if (countproduct_int == 0) {
			driver.findElement(btn_next).click();
		}
	}
}
