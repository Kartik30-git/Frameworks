package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By email = By.id("user_email");
	By password = By.id("user_password");
	By submit = By.name("commit");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement emailElement() {
		return driver.findElement(email);
	}

	public WebElement passwordElement() {
		return driver.findElement(password);
	}
	
	public WebElement submitElement() {
		return driver.findElement(submit);
	}

}
