package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement welcomeMessage;
	WebElement errorMessage;
	WebElement signOutButton;
	WebElement myAddressesButton;
	
	public WebElement getMyAddressesButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span"));
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

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signOutButtonClick() {
		this.getSignOutButton().click();
	}
	
	public void myAddressesButtonClick() {
		this.getMyAddressesButton().click();
	}
}
