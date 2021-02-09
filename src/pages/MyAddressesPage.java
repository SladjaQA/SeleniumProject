package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {

	WebDriver driver;
    WebElement ubdateButton;
    WebElement addressBox;
    
	public WebElement getAddressBox() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getUbdateButton() {
		return driver.findElement(By.className("button-small"));
	}

	public MyAddressesPage(WebDriver driver) {
		this.driver = driver;
	}
	
   public void updateButtonClick() {
	   this.getUbdateButton().click();
   }
   
   public void addressUpdate(String address) {
	   this.getAddressBox().clear();
	   this.getAddressBox().sendKeys(address);
   }
}
