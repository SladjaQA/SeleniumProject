package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAddressesPage {

	WebDriver driver;
	WebElement ubdateButton;
	WebElement addressBox;
	WebElement addressTitle;
	WebElement updateSave;
	WebElement addNewAddressButton;
	WebElement cityField;
	WebElement zipCodeField;
	WebElement mobilePhoneNumberField;
	WebElement stateDropdownSelection;
	WebElement secondAddressLabel;
	WebElement deleteSecondAddressButton;
	List<WebElement> numberOfAddresses;

	public MyAddressesPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getNumberOfAddresses() {
		return driver.findElements(By.xpath("//div[@class='addresses']/div/div[2]/ul/li/h3"));
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getZipCodeField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getMobilePhoneNumberField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getStateDropdownSelection() {
		return driver.findElement(By.id("id_state"));
	}

	public WebElement getSecondAddressLabel() {
		return driver.findElement(By.xpath("//div[@class='addresses']/div/div[2]/ul/li/h3"));
	}

	public WebElement getDeleteSecondAddressButton() {
		return driver.findElement(By.xpath("//div[@class='addresses']/div/div[2]/ul/li[9]/a[2]"));
	}

	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.xpath("//a[@title=\"Add an address\"]"));
	}

	public WebElement getUpdateSave() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getAddressTitle() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getAddressBox() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getUbdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]/span"));
	}

	// Methods

	public void updateButtonClick() {
		this.getUbdateButton().click();
	}

	public void newAddressInsert(String address) {
		this.getAddressBox().clear();
		this.getAddressBox().sendKeys(address);
	}

	public void addressTitleInsert(String addressTitle) {
		this.getAddressTitle().clear();
		this.getAddressTitle().sendKeys(addressTitle);
	}

	public void updateSaveClick() {
		this.getUpdateSave().click();
	}

	public void addNewAddressButtonClick() {
		this.getAddNewAddressButton().click();
	}

	public void clickCityField(String city) {
		getCityField().click();
		getCityField().sendKeys(city);
	}

	public void clickZipCodeField(String zip) {
		getZipCodeField().click();
		getZipCodeField().sendKeys(zip);
	}

	public void insertMobilePhoneNumberField(String mob) {
		getMobilePhoneNumberField().click();
		getMobilePhoneNumberField().sendKeys(mob);
	}

	public void selectStateFromDropDown(int number) {
		Select stateFromDropDown = new Select(getStateDropdownSelection());
		stateFromDropDown.selectByIndex(number);
	}

	public void clickDeleteSecondAddressButton() {
		getDeleteSecondAddressButton().click();
	}

	public int currentNumberOfAddresses() {
		return this.getNumberOfAddresses().size();
	}
	
}
