package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInformationPage {
	WebDriver driver;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement eMailField;
	WebElement validPasswordField;
	WebElement newPasswordField;
	WebElement newPasswordConfirmationField;
	WebElement savePersonalInfoButton;
	WebElement successMessage;
	
	public MyPersonalInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSuccessMessage() {
		return driver.findElement(By.className("alert-success"));
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement geteMailField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getValidPasswordField() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getNewPasswordField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getNewPasswordConfirmationField() {
		return driver.findElement(By.id("confirmation"));
	}

	public WebElement getSavePersonalInfoButton() {
		return driver.findElement(By.name("submitIdentity"));
	}

	//Methods
	
	public void validPasswordInsert(String password) {
		this.getValidPasswordField().clear();
		this.getValidPasswordField().sendKeys(password);
	}
	
	public void newPasswordInsert(String password) {
		this.getNewPasswordField().clear();
		this.getNewPasswordField().sendKeys(password);
	}
	
	public void eMailInsert(String email) {
		this.geteMailField().clear();
		this.geteMailField().sendKeys(email);
	}
	
	public void firstNameInsert(String name) {
		this.getFirstNameField().clear();
		this.getFirstNameField().sendKeys(name);
	}
	
	public void lastNameInsert(String surname) {
		this.getLastNameField().clear();
		this.getLastNameField().sendKeys(surname);
	}
	
	public void newPasswordConfirmationFieldInsert(String password) {
		this.getNewPasswordConfirmationField().clear();
		this.getNewPasswordConfirmationField().sendKeys(password);
	}
	
	public void savePersonalInfoButtonClick() {
		this.getSavePersonalInfoButton().click();
		
	}
	
	public void changingPersonalInfo(String name, String surname, String eMail, String currentPassword) {
		firstNameInsert(name);
		lastNameInsert(surname);
		eMailInsert(eMail);
		validPasswordInsert(currentPassword);
	}
	
	public void setingSecondPassword(String password) {
		newPasswordInsert(password);
		newPasswordConfirmationFieldInsert(password);
	}
}
