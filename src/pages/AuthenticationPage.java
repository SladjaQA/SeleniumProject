package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AuthenticationPage {
	WebDriver driver;
	WebElement eMail;
	WebElement password;
	WebElement signInButton;

	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement geteMail() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}

	// Methods

	public void eMailInsert(String eMail) {
		this.geteMail().clear();
		this.geteMail().sendKeys(eMail);
	}

	public void passwordInsert(String password) {
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
	}

	public void signInButtonClick() {
		this.getSignInButton().click();
	}
	public void invalidLogIn(String eMail, String password1) {
	    eMailInsert(eMail);
	    passwordInsert(password1);
	    signInButtonClick();
	}
}
