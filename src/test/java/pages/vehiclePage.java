package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class vehiclePage {

	protected WebDriver driver;
	private Random rand = new Random();

	private By slt_make = By.id("make");
	private By slt_model = By.id("model");
	private By nbr_capacity = By.id("cylindercapacity");
	private By nbr_performance = By.id("engineperformance");
	private By txt_dateofmanufacture = By.id("dateofmanufacture");
	private By nbr_seats = By.id("numberofseats");
	private By mk_yes = By.xpath("//*[@id='insurance-form']/div/section[1]/div[7]/p/label[1]/span");
	private By nbr_seatsmotorcycle = By.id("numberofseatsmotorcycle");
	private By nbr_payload = By.name("Payload");
	private By nbr_totalweight = By.id("totalweight");
	private By nbr_price = By.name("List Price");
	private By cnt_vehicledata = By.id("entervehicledata");
	private By nbr_counter = By.className("counter");
	private By btn_next = By.id("nextenterinsurantdata");

	public vehiclePage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMake() throws InterruptedException {
		int index_makes = 13; // generate random values from 0-14
		int random_makes = rand.nextInt(index_makes);
		
		Select makes = new Select(driver.findElement(slt_make));
		makes.selectByVisibleText("– please select –");
		makes.selectByIndex(random_makes + 1);

		TimeUnit.SECONDS.sleep(2);
	}

	public void selectModel() {
		int index_model = 3; // generate random values from 0-3
		int random_model = rand.nextInt(index_model);
		
		Select model = new Select(driver.findElement(slt_model));
		model.selectByVisibleText("– please select –");
		model.selectByIndex(random_model + 1);
	}

	public void fillDateManufacture() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -10);// to get previous day add -10
		Date datePast = cal.getTime();
		String datePastStr = dateFormat.format(datePast);

		driver.findElement(txt_dateofmanufacture).sendKeys(datePastStr);
	}

	public void fillCylinderCapacity() {
		int min_cylinder = 50;
		int max_cylinder = 100;
		Integer random_cylinder = (int) Math.floor(Math.random() * (max_cylinder - min_cylinder + 1) + min_cylinder);
		String random_cylinder_str = random_cylinder.toString();

		driver.findElement(nbr_capacity).sendKeys(random_cylinder_str);
	}

	public void fillEnginePerformance() {
		int min_engine = 50;
		int max_engine = 100;
		Integer random_engine = (int) Math.floor(Math.random() * (max_engine - min_engine + 1) + min_engine);
		String random_engine_str = random_engine.toString();

		driver.findElement(nbr_performance).sendKeys(random_engine_str);
	}

	public void selectNumberSeats() {
		int index_seats = 8; // generate random values from 0-9
		int random_seats = rand.nextInt(index_seats);
		
		Select seats = new Select(driver.findElement(nbr_seats));
		seats.selectByVisibleText("– please select –");
		seats.selectByIndex(random_seats + 1);
	}

	public void markRightHandDrive() {
		WebElement radio_dr = driver.findElement(mk_yes);
		radio_dr.click();
	}

	public void selectNumberSeatsMotorcycle() {
		int index_seats_m = 2; // generate random values from 0-9
		int random_seats_m = rand.nextInt(index_seats_m);
		
		Select seats_m = new Select(driver.findElement(nbr_seatsmotorcycle));
		seats_m.selectByVisibleText("– please select –");
		seats_m.selectByIndex(random_seats_m + 1);
	}

	public void selectFuelType() {
		int index_fuel = 4; // generate random values from 0-4
		int random_fuel = rand.nextInt(index_fuel);
		
		Select fuel = new Select(driver.findElement(By.id("fuel")));
		fuel.selectByVisibleText("– please select –");
		fuel.selectByIndex(random_fuel + 1);
	}

	public void fillPayload() {
		Integer random_payload_int = rand.nextInt(900);
		String random_payload_str = random_payload_int.toString();

		driver.findElement(nbr_payload).sendKeys(random_payload_str);
	}

	public void fillTotalWeight() {
		int min_weight = 100;
		int max_weight = 50000;
		Integer random_weight = (int) Math.floor(Math.random() * (max_weight - min_weight + 1) + min_weight);
		String random_weight_str = random_weight.toString();

		driver.findElement(nbr_totalweight).sendKeys(random_weight_str);

	}

	public void fillListPrice() {
		int min_price = 500;
		int max_price = 100000;
		Integer random_price = (int) Math.floor(Math.random() * (max_price - min_price + 1) + min_price);
		String random_price_str = random_price.toString();

		driver.findElement(nbr_price).sendKeys(random_price_str);
	}

	public void fillMileage() {
		int min_mileage = 100;
		int max_mileage = 100000;
		Integer random_mileage = (int) Math.floor(Math.random() * (max_mileage - min_mileage + 1) + min_mileage);
		String random_mileage_str = random_mileage.toString();

		driver.findElement(By.name("Annual Mileage")).sendKeys(random_mileage_str);

	}

	public void checkFillDataVehicle() {
		WebElement countvehicle = driver.findElement(cnt_vehicledata).findElement(nbr_counter);
		String countvehicle_str = countvehicle.getText();
		int countvehicle_int = Integer.parseInt(countvehicle_str);
		if (countvehicle_int == 0) {
			driver.findElement(btn_next).click();
		}
	}
}
