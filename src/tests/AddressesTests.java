package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AddressesTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		logIn();
	}

	@Test(priority = 0)
	public void updatingAddress() throws Exception {
		address = excellReader.getData("My address", 8, 5);
		assertMessage = excellReader.getData("My address", 9, 5);
		myAccountPage.myAddressesButtonClick();
		myAddressesPage.updateButtonClick();
		textForAssert = myAddressesPage.getAddressBox().getAttribute("value");// readig previous address
		myAddressesPage.newAddressInsert(address);
		textForAssert2 = myAddressesPage.getAddressTitle().getAttribute("value");// reading previous address title
		myAddressesPage.addressTitleInsert(assertMessage);
		myAddressesPage.updateSaveClick();
		Assert.assertNotEquals(textForAssert, address);
		Assert.assertNotEquals(textForAssert2, assertMessage);
		setValidAddress();
	}

	@Test(priority = 5)
	public void addingAdditionalAddress() throws Exception {
		address = excellReader.getData("My address", 20, 4);
		city = excellReader.getData("My address", 21, 4);
		zip = excellReader.getData("My address", 24, 4);
		mob = excellReader.getData("My address", 27, 4);
		alias = excellReader.getData("My address", 28, 4);
		myAccountPage.myAddressesButtonClick();
		myAddressesPage.addNewAddressButtonClick();
		myAddressesPage.newAddressInsert(address);
		myAddressesPage.clickCityField(city);
		myAddressesPage.selectStateFromDropDown(6);
		myAddressesPage.clickZipCodeField(zip);
		myAddressesPage.insertMobilePhoneNumberField(mob);
		myAddressesPage.addressTitleInsert(alias);
		myAddressesPage.updateSaveClick();
		label = myAddressesPage.getSecondAddressLabel().getText();
		Assert.assertEquals(label, alias);

	}

	@Test(priority = 10)
	public void deletingAdditionalAddress() throws Exception {
		myAccountPage.myAddressesButtonClick();
		myAddressesPage.clickDeleteSecondAddressButton();
		driver.switchTo().alert().accept();
		number = myAddressesPage.currentNumberOfAddresses();
		Assert.assertEquals(0, number);

	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
