package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	WebElement signInButton;
	

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void signInButtonClick() {
		this.getSignInButton().click();
	}
}
