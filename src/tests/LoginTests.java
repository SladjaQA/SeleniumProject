package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	@Test
	public void loginTest() throws Exception {
		logIn();
	}

	@Test
	public void loginTestNoCredentials() throws Exception {
		eMail = excellReader.getData("login", 52, 5);
		password = excellReader.getData("login", 53, 5);
		assertMessage = excellReader.getData("login", 54, 6);
		homePage.signInButtonClick();
		authenticationPage.invalidLogIn(eMail, password);
		textForAssert = myAccountPage.getErrorMessage().getText();
		Assert.assertEquals(textForAssert, assertMessage);
	}

	@Test
	public void loginInvalidPassword() throws Exception {
		eMail = excellReader.getData("login", 20, 4);
		password = excellReader.getData("login", 21, 5);
		assertMessage = excellReader.getData("login", 22, 6);
		homePage.signInButtonClick();
		authenticationPage.invalidLogIn(eMail, password);
		textForAssert = myAccountPage.getErrorMessage().getText();
		Assert.assertEquals(textForAssert, assertMessage);
	}

	@Test
	public void loginInvalideMail() throws Exception {
		eMail = excellReader.getData("login", 32, 5);
		password = excellReader.getData("login", 33, 4);
		assertMessage = excellReader.getData("login", 34, 6);
		homePage.signInButtonClick();
		authenticationPage.invalidLogIn(eMail, password);
		textForAssert = myAccountPage.getErrorMessage().getText();
		Assert.assertEquals(textForAssert, assertMessage);
		homePage.signInButtonClick();
	}

	@Test
	public void signOut() throws Exception {
		logIn();
		myAccountPage.signOutButtonClick();
		authenticationPage.getSignInButton().isDisplayed();
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
