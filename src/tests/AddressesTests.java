package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.MyAddressesPage;

public class AddressesTests extends TestBase {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
	    logIn();
	}
	
	@Test
	public void updatingAddress() throws Exception {
		myAccountPage.myAddressesButtonClick();
		myAddressesPage.updateButtonClick();
		String firstAddress = myAddressesPage.getAddressBox().getText();
		String address = excellReader.getData("My address", 8, 4);
		myAddressesPage.addressUpdate(address);
        //
		Assert.assertEquals(firstAddress , address);
	}
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
