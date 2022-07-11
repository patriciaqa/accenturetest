package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.insurantPage;
import pages.pricePage;
import pages.productPage;
import pages.quotePage;
import pages.vehiclePage;

public class QuoteSteps_POM {

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
		vehiclePage vehicle = new vehiclePage(driver);

		vehicle.selectMake();
		vehicle.selectModel();
		vehicle.fillCylinderCapacity();
		vehicle.fillEnginePerformance();
		vehicle.fillDateManufacture();
		vehicle.selectNumberSeats();
		vehicle.markRightHandDrive();
		vehicle.selectNumberSeatsMotorcycle();
		vehicle.selectFuelType();
		vehicle.fillPayload();
		vehicle.fillTotalWeight();
		vehicle.fillListPrice();
		vehicle.fillMileage();
		vehicle.checkFillDataVehicle();

	}

	@Given("I enter valid insurant data")
	public void i_enter_valid_insurant_data() {
		insurantPage insurant = new insurantPage(driver);

		insurant.fillFirstName();
		insurant.fillLastName();
		insurant.fillBirthDate();
		insurant.fillAddress();
		insurant.selectCountry();
		insurant.fillZipCode();
		insurant.fillCity();
		insurant.selectOccupation();
		insurant.markHobbies();
		insurant.fillSite();
		insurant.checkFillDataInsurant();
	}

	@Given("I enter valid product data")
	public void i_enter_valid_product_data() {
		productPage product = new productPage(driver);

		product.fillStartDate();
		product.selectInsuranceSum();
		product.selectMeritRating();
		product.selectDamageInsurance();
		product.markOptionalProducts();
		product.selectCourtesyCar();
		product.checkFillDataProduct();
	}

	@Given("I choose the price")
	public void i_choose_the_price() throws InterruptedException {
		pricePage price = new pricePage(driver);

		price.markPrice();
		price.checkFillDataPrice();
	}

	@Given("I enter the account info")
	public void i_enter_the_account_info() {
		quotePage quote = new quotePage(driver);

		quote.fillEmail();
		quote.fillPhone();
		quote.fillUsername();
		quote.fillPassword();
		quote.fillComments();
	}

	@When("I send quote")
	public void i_send_quote() throws InterruptedException {
		quotePage quote = new quotePage(driver);

		quote.checkFillDataAccount();
	}

	@Then("the system should display the confirmation message {string}")
	public void the_system_should_display_the_confirmation_message(String message_text) throws InterruptedException {
		quotePage quote = new quotePage(driver);

		quote.validateMessageSuccess(message_text);
	}
}
