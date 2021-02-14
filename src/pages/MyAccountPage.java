package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAddressesButton;
	WebElement myPersonalInfoButton;
	WebElement myWishlistsButton;
	WebElement welcomeMessage;
	WebElement errorMessage;
	WebElement signOutButton;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getMyPersonalInfoButton() {
		return driver.findElement(By.xpath("//a[@title='Information']"));
	}

	public WebElement getMyWishlistsButton() {
		return driver.findElement(By.xpath("//a[@title='My wishlists']"));
	}

	public WebElement getMyAddressesButton() {
		return driver.findElement(By.xpath("//a[@title='Addresses']"));
	}
	
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}

	public WebElement getErrorMessage() {
		return driver.findElement(By.className("alert-danger"));
	}

	public WebElement getWelcomeMessage() {
		return driver.findElement(By.className("info-account"));
	}
	
	//Methods
	
	public void signOutButtonClick() {
		this.getSignOutButton().click();
	}
	
	public void myAddressesButtonClick() {
		this.getMyAddressesButton().click();
	}
	
	public void MyPersonalInfoButtonClick() {
		this.getMyPersonalInfoButton().click();
	}
	
	public void MyWishlistsButtonClick() {
	    this.getMyWishlistsButton().click();
}
	
	}
	

