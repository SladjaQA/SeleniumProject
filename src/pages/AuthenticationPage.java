package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
	WebDriver driver;
    WebElement eMailAddressBox;
    WebElement passwordBox;
    WebElement signInButton;
    


	public WebElement geteMailAddressBox() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordBox() {
		return driver.findElement(By.id("passwd"));
	}
	
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public void eMailInsert(String eMail) {
		this.geteMailAddressBox().clear();
		this.geteMailAddressBox().sendKeys(eMail);
	}
	
	public void passwordInsert(String password) {
		this.getPasswordBox().clear();
		this.getPasswordBox().sendKeys(password);
	}
	
	public void signInButtonClick() {
		this.getSignInButton().click();
	}
}
