package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInfoTests extends TestBase {

	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		logIn();
	}

	@Test
	public void editFirstNamePersonalInfo() throws InterruptedException {
		name = excellReader.getData("My personal info", 7, 5);
		surname = excellReader.getData("My personal info", 8, 4);
		eMail = excellReader.getData("My personal info", 9, 4);
		currentPassword = excellReader.getData("My personal info", 10, 4);
		assertMessage = excellReader.getData("My personal info", 11, 6);
		myAccountPage.MyPersonalInfoButtonClick();
		myPersonalInformationPage.changingPersonalInfo(name, surname, eMail, currentPassword);
		myPersonalInformationPage.savePersonalInfoButtonClick();
		textForAssert = myPersonalInformationPage.getSuccessMessage().getText();
		Assert.assertEquals(textForAssert, assertMessage);
	}

	@Test
	public void editLastNamePersonalInfo() {
		name = excellReader.getData("My personal info", 20, 4);
		surname = excellReader.getData("My personal info", 21, 5);
		eMail = excellReader.getData("My personal info", 22, 4);
		currentPassword = excellReader.getData("My personal info", 23, 4);
		assertMessage = excellReader.getData("My personal info", 24, 6);
		myAccountPage.MyPersonalInfoButtonClick();
		myPersonalInformationPage.changingPersonalInfo(name, surname, eMail, currentPassword);
		myPersonalInformationPage.savePersonalInfoButtonClick();
		textForAssert = myPersonalInformationPage.getSuccessMessage().getText();
		Assert.assertEquals(textForAssert, assertMessage);
	}

	@Test
	public void editeMailPersonalInfo() {
		myAccountPage.MyPersonalInfoButtonClick();
		name = excellReader.getData("My personal info", 33, 4);
		surname = excellReader.getData("My personal info", 34, 4);
		eMail = excellReader.getData("My personal info", 35, 5);
		currentPassword = excellReader.getData("My personal info", 36, 4);
		assertMessage = excellReader.getData("My personal info", 37, 6);
		myPersonalInformationPage.changingPersonalInfo(name, surname, eMail, currentPassword);
		myPersonalInformationPage.savePersonalInfoButtonClick();
		textForAssert = myPersonalInformationPage.getSuccessMessage().getText();
		Assert.assertEquals(textForAssert, assertMessage);

	}
	
	@Test
	public void editPasswordPersonalInfo() {
		name = excellReader.getData("My personal info", 46, 4);
		surname = excellReader.getData("My personal info", 47, 4);
		eMail = excellReader.getData("My personal info", 48, 4);
		currentPassword = excellReader.getData("My personal info", 49, 4);
		password = excellReader.getData("My personal info", 50, 5);
		assertMessage = excellReader.getData("My personal info", 51, 6);
		myAccountPage.MyPersonalInfoButtonClick();
		myPersonalInformationPage.changingPersonalInfo(name, surname, eMail, currentPassword);
		myPersonalInformationPage.setingSecondPassword(password);
		myPersonalInformationPage.savePersonalInfoButtonClick();
		textForAssert = myPersonalInformationPage.getSuccessMessage().getText();
		Assert.assertEquals(textForAssert, assertMessage);	
        editPaswordBack(); 
	}

	@AfterMethod
	public void clearRefresh() {
		setValidPersonalInfo();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
