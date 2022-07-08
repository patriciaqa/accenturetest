package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.github.javafaker.PhoneNumber;

import io.cucumber.java.en.*;

public class QuoteSteps {

	WebDriver driver = null;

	@Given("I want to purchase vehicle insurance")
	public void i_want_to_purchase_vehicle_insurance() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				projectPath + "/src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().window().maximize();

		driver.navigate().to("http://sampleapp.tricentis.com/101/app.php");

	}

	@Given("I enter valid vehicle data")
	public void i_enter_valid_vehicle_data() throws InterruptedException {
		Random rand = new Random();

		// selection make
		int index_makes = 14; // generate random values from 0-14
		int random_makes = rand.nextInt(index_makes);

		Select makes = new Select(driver.findElement(By.id("make")));
		makes.selectByVisibleText("– please select –");
		makes.selectByIndex(random_makes + 1);

		TimeUnit.SECONDS.sleep(2);

		// selection model
		int index_model = 3; // generate random values from 0-3
		int random_model = rand.nextInt(index_model);

		Select model = new Select(driver.findElement(By.id("model")));
		model.selectByVisibleText("– please select –");
		model.selectByIndex(random_model + 1);

		// fill cylinder capacity
		/*
		 * int min = 50; int max = 100; int random_engine =
		 * (int)Math.floor(Math.random()*(max-min+1)+min);
		 */

		driver.findElement(By.id("cylindercapacity")).sendKeys("90");

		// fill engine performance
		/*
		 * int min = 50; int max = 100; int random_engine =
		 * (int)Math.floor(Math.random()*(max-min+1)+min);
		 */

		driver.findElement(By.id("engineperformance")).sendKeys("70");

		// fill Date
		driver.findElement(By.id("dateofmanufacture")).sendKeys("05/10/2020");

		// selection number of seats
		int index_seats = 8; // generate random values from 0-9
		int random_seats = rand.nextInt(index_seats);

		Select seats = new Select(driver.findElement(By.id("numberofseats")));
		seats.selectByVisibleText("– please select –");
		seats.selectByIndex(random_seats + 1);

		// mark right hand drive
		WebElement radio_dr = driver
				.findElement(By.xpath("//*[@id='insurance-form']/div/section[1]/div[7]/p/label[1]/span"));
		radio_dr.click();

		// selection number of seats
		int index_seats_m = 2; // generate random values from 0-9
		int random_seats_m = rand.nextInt(index_seats_m);

		Select seats_m = new Select(driver.findElement(By.id("numberofseatsmotorcycle")));
		seats_m.selectByVisibleText("– please select –");
		seats_m.selectByIndex(random_seats_m + 1);

		// selection fuel type
		int index_fuel = 4; // generate random values from 0-4
		int random_fuel = rand.nextInt(index_fuel);

		Select fuel = new Select(driver.findElement(By.id("fuel")));
		fuel.selectByVisibleText("– please select –");
		fuel.selectByIndex(random_fuel + 1);

		// fill payload
		Integer random_payload_int = rand.nextInt(300);
		String random_payload_str = random_payload_int.toString();

		driver.findElement(By.name("Payload")).sendKeys(random_payload_str);

		// fill total weight [kg]
		/*
		 * int min = 500; int max = 100000; int random_engine =
		 * (int)Math.floor(Math.random()*(max-min+1)+min);
		 */

		driver.findElement(By.id("totalweight")).sendKeys("400");

		// fill list price
		/*
		 * int min = 500; int max = 100000; int random_engine =
		 * (int)Math.floor(Math.random()*(max-min+1)+min);
		 */

		driver.findElement(By.name("List Price")).sendKeys("700");

		// fill mileage
		/*
		 * int min = 100; int max = 100000; int random_engine =
		 * (int)Math.floor(Math.random()*(max-min+1)+min);
		 */
		driver.findElement(By.name("Annual Mileage")).sendKeys("250");

		// validate fill valid data
		WebElement countvehicle = driver.findElement(By.id("entervehicledata")).findElement(By.className("counter"));
		String countvehicle_str = countvehicle.getText();
		int countvehicle_int = Integer.parseInt(countvehicle_str);
		if (countvehicle_int == 0) {
			driver.findElement(By.id("nextenterinsurantdata")).click();
		}
	}

	@Given("I enter valid insurant data")
	public void i_enter_valid_insurant_data() {
		Random rand = new Random();
		Faker faker = new Faker();

		// fill First Name
		String firstName = faker.name().firstName();
		driver.findElement(By.id("firstname")).sendKeys(firstName);

		// fill Last Name
		String lastName = faker.name().lastName();
		driver.findElement(By.id("lastname")).sendKeys(lastName);

		// fill birth date
		driver.findElement(By.id("birthdate")).sendKeys("04/13/1989");

		// gender

		// fill address
		String address = faker.address().streetAddress();
		driver.findElement(By.id("streetaddress")).sendKeys(address);

		// select country
		int index_country = 30; // generate random values from 0-30
		int random_country = rand.nextInt(index_country);

		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("– please select –");
		country.selectByIndex(random_country + 1);

		// fill Zip Code
		Integer postal = rand.nextInt(01000002);
		String postal_str = postal.toString();
		driver.findElement(By.id("zipcode")).sendKeys(postal_str);

		// fill city
		String city = faker.address().cityName();
		driver.findElement(By.id("city")).sendKeys(city);

		// select Occupation
		int index_occupation = 4; // generate random values from 0-4
		int random_occupation = rand.nextInt(index_occupation);

		Select occupation = new Select(driver.findElement(By.id("occupation")));
		occupation.selectByVisibleText("– please select –");
		occupation.selectByIndex(random_occupation + 1);

		// mark Hobbies
		WebElement check_hob = driver
				.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span"));
		check_hob.click();

		// fill site
		// String site = faker.internet().emailAddress();
		driver.findElement(By.id("website")).sendKeys("www.open.com.br");

		// validate filled valid data insurant
		WebElement countinsurant = driver.findElement(By.id("enterinsurantdata")).findElement(By.className("counter"));
		String countinsurant_str = countinsurant.getText();
		int countinsurant_int = Integer.parseInt(countinsurant_str);
		if (countinsurant_int == 0) {
			driver.findElement(By.id("nextenterproductdata")).click();
		}

	}

	@Given("I enter valid product data")
	public void i_enter_valid_product_data() {
		Random rand = new Random();

		// fill start date
		driver.findElement(By.id("startdate")).sendKeys("05/10/2023");

		// select Insurance Sum
		int index_sum = 8; // generate random values from 0-8
		int random_sum = rand.nextInt(index_sum);

		Select sum = new Select(driver.findElement(By.id("insurancesum")));
		sum.selectByVisibleText("– please select –");
		sum.selectByIndex(random_sum + 1);

		// select Merit Rating
		int index_merit = 18; // generate random values from 0-18
		int random_merit = rand.nextInt(index_merit);

		Select merit = new Select(driver.findElement(By.id("meritrating")));
		merit.selectByVisibleText("– please select –");
		merit.selectByIndex(random_merit + 1);

		// select Damage Insurance
		int index_damage = 2; // generate random values from 0-2
		int random_damage = rand.nextInt(index_damage);

		Select damage = new Select(driver.findElement(By.id("damageinsurance")));
		damage.selectByVisibleText("– please select –");
		damage.selectByIndex(random_damage + 1);

		// mark Optional Products
		WebElement check_products = driver
				.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]/span"));
		check_products.click();

		// select Courtesy Car
		int index_courtesy = 1; // generate random values from 0-1
		int random_courtesy = rand.nextInt(index_courtesy);

		Select courtesy = new Select(driver.findElement(By.id("courtesycar")));
		courtesy.selectByVisibleText("– please select –");
		courtesy.selectByIndex(random_courtesy + 1);

		// validate filled valid data product
		WebElement countproduct = driver.findElement(By.id("enterproductdata")).findElement(By.className("counter"));
		String countproduct_str = countproduct.getText();
		int countproduct_int = Integer.parseInt(countproduct_str);
		if (countproduct_int == 0) {
			driver.findElement(By.id("nextselectpriceoption")).click();
		}

	}

	@Given("I choose the price")
	public void i_choose_the_price() throws InterruptedException {
		// mark Price [gold]
		WebElement check_price = driver.findElement(By.xpath("//*[@id=\'priceTable\']/tfoot/tr/th[2]/label[2]/span"));
		check_price.click();

		TimeUnit.SECONDS.sleep(2);

		// validate view/download quote

		// validate filled valid data price
		WebElement countprice = driver.findElement(By.id("selectpriceoption")).findElement(By.className("counter"));
		String countprice_str = countprice.getText();
		int countprice_int = Integer.parseInt(countprice_str);
		if (countprice_int == 0) {
			driver.findElement(By.id("nextsendquote")).click();
		}

	}

	@Given("I enter the account info")
	public void i_enter_the_account_info() {
		Faker faker = new Faker();

		// fill email
		String email = faker.internet().emailAddress();
		driver.findElement(By.id("email")).sendKeys(email);

		// fill phone
		//PhoneNumber phone = faker.phoneNumber();
		//String phone_str = phone.toString();
		driver.findElement(By.id("phone")).sendKeys("32450000");

		// fill username
		String username = faker.name().username();
		driver.findElement(By.id("username")).sendKeys(username);

		// fill password
		String password = faker.internet().password();
		String password_str = password.toString();
		password_str = "Ab1" + password_str;
		driver.findElement(By.id("password")).sendKeys(password_str);

		// fill confirm password
		driver.findElement(By.id("confirmpassword")).sendKeys(password_str);

		// fill Comments
		Lorem obs = faker.lorem();
		String obs_str = obs.toString();
		driver.findElement(By.id("Comments")).sendKeys(obs_str);
	}

	@When("I send quote")
	public void i_send_quote() {
		// validate filled valid account info
		WebElement countquote = driver.findElement(By.id("sendquote")).findElement(By.className("counter"));
		String countquote_str = countquote.getText();
		int countquote_int = Integer.parseInt(countquote_str);
		if (countquote_int == 0) {
			driver.findElement(By.id("sendemail")).click();
		}
	}

	@Then("the system should display the confirmation message {string}")
	public void the_system_should_display_the_confirmation_message(String message_text) throws InterruptedException {
		TimeUnit.SECONDS.sleep(15);
		
		// validate message
		WebElement message = driver.findElement(By.xpath("/html/body/div[4]/h2"));
		assertEquals(message.getText(), message_text);

	}
}
