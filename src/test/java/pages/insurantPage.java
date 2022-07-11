package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class insurantPage {

	protected WebDriver driver;
	private Random rand = new Random();
	private Faker faker = new Faker();

	private By txt_firstname = By.id("firstname");
	private By txt_lastname = By.id("lastname");
	private By txt_birthdate = By.id("birthdate");
	private By txt_address = By.id("streetaddress");
	private By slt_country = By.id("country");
	private By nbr_zipcode = By.id("zipcode");
	private By txt_city = By.id("city");
	private By slt_occupation = By.id("occupation");
	private By opt_hobbies = By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span");
	private By url_website = By.id("website");
	private By cnt_insurantdata = By.id("enterinsurantdata");
	private By shw_counter = By.className("counter");
	private By btn_next = By.id("nextenterproductdata");

	public insurantPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillFirstName() {
		String firstName = faker.name().firstName();
		driver.findElement(txt_firstname).sendKeys(firstName);
	}

	public void fillLastName() {
		String lastName = faker.name().lastName();
		driver.findElement(txt_lastname).sendKeys(lastName);
	}

	public void fillBirthDate() {
		SimpleDateFormat dateFormatb = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calb = Calendar.getInstance();
		calb.add(Calendar.YEAR, -21); // to get previous year add -21
		Date nextYearb = calb.getTime();
		String dateFutureBStr = dateFormatb.format(nextYearb);

		driver.findElement(txt_birthdate).sendKeys(dateFutureBStr);
	}

	public void fillAddress() {
		String address = faker.address().streetAddress();
		driver.findElement(txt_address).sendKeys(address);
	}

	public void selectCountry() {
		int index_country = 30; // generate random values from 0-30
		int random_country = rand.nextInt(index_country);
		
		Select country = new Select(driver.findElement(slt_country));
		country.selectByVisibleText("– please select –");
		country.selectByIndex(random_country + 1);

	}

	public void fillZipCode() {
		Integer postal = rand.nextInt(01000002);
		String postal_str = postal.toString();
		driver.findElement(nbr_zipcode).sendKeys(postal_str);

	}

	public void fillCity() {
		String city = faker.address().cityName();
		driver.findElement(txt_city).sendKeys(city);

	}

	public void selectOccupation() {
		int index_occupation = 4; // generate random values from 0-4
		int random_occupation = rand.nextInt(index_occupation);
		
		Select occupation = new Select(driver.findElement(slt_occupation));
		occupation.selectByVisibleText("– please select –");
		occupation.selectByIndex(random_occupation + 1);
	}

	public void markHobbies() {
		WebElement check_hob = driver.findElement(opt_hobbies);
		check_hob.click();
	}

	public void fillSite() {
		driver.findElement(url_website).sendKeys("www.open.com.br");
	}

	public void checkFillDataInsurant() {
		WebElement countinsurant = driver.findElement(cnt_insurantdata).findElement(shw_counter);
		String countinsurant_str = countinsurant.getText();
		int countinsurant_int = Integer.parseInt(countinsurant_str);
		if (countinsurant_int == 0) {
			driver.findElement(btn_next).click();
		}
	}
}
