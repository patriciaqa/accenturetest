package pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;

public class quotePage {
	
	protected WebDriver driver;
	private Faker faker = new Faker();

	private By txt_email = By.id("email");
	private By nbr_phone = By.id("phone");
	private By txt_username = By.id("username");
	private By txt_password = By.id("password");
	private By txt_confirmpassword = By.id("confirmpassword");
	private By txt_comments = By.id("Comments");
	private By btn_sendquote = By.id("sendquote");
	private By shw_counter = By.className("counter");
	private By btn_sendemail = By.id("sendemail");
	private By txt_alert = By.xpath("/html/body/div[4]/h2");

	public quotePage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillEmail() {
		String email = faker.internet().emailAddress();
		driver.findElement(txt_email).sendKeys(email);
	}

	public void fillPhone() {
		// PhoneNumber phone = faker.phoneNumber();
		// String phone_str = phone.toString();
		driver.findElement(nbr_phone).sendKeys("32450000");

	}

	public void fillUsername() {
		String username = faker.name().username();

		driver.findElement(txt_username).sendKeys(username);
	}

	public void fillPassword() {
		String password = faker.internet().password();
		String password_str = password.toString();
		password_str = "Ab1" + password_str;

		driver.findElement(txt_password).sendKeys(password_str); // fill password
		driver.findElement(txt_confirmpassword).sendKeys(password_str); // fill confirm password
	}

	public void fillComments() {
		Lorem obs = faker.lorem();
		String obs_str = obs.toString();

		driver.findElement(txt_comments).sendKeys(obs_str);
	}

	public void checkFillDataAccount() throws InterruptedException {
		WebElement countquote = driver.findElement(btn_sendquote).findElement(shw_counter);
		String countquote_str = countquote.getText();
		int countquote_int = Integer.parseInt(countquote_str);

		if (countquote_int == 0) {
			driver.findElement(btn_sendemail).click();
			TimeUnit.SECONDS.sleep(15);
		}
		
	}

	public void validateMessageSuccess(String message_text) {
		WebElement message = driver.findElement(txt_alert);
		assertEquals(message.getText(), message_text);
	}
}
