package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.AuthenticationPage;

public class TestBase {

	WebDriver driver;
	ExcellReader excellReader;
	HomePage homePage;
	AuthenticationPage authenticationPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
	    excellReader = new ExcellReader("Test Plan/TestCase.xlsx");
	    homePage = new HomePage(driver);
	    authenticationPage = new AuthenticationPage(driver);
	    myAccountPage = new MyAccountPage(driver);
	    myAddressesPage = new MyAddressesPage(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void posleKlase() throws IOException {
		driver.close();
		excellReader.fis.close();
		excellReader.wb.close();
	}
	
	public void logIn() {
	    homePage.signInButtonClick();
	    String eMail = excellReader.getData("login",8,4);
	    String password = excellReader.getData("login",9,4);
	    String assertMessage = excellReader.getData("login",10,6);
	    authenticationPage.eMailInsert(eMail);
	    authenticationPage.passwordInsert(password);
	    authenticationPage.signInButtonClick();
		String textForAssert = myAccountPage.getWelcomeMessage().getText();
		Assert.assertEquals(textForAssert,assertMessage);
	}
	
	public void invalidLogIn(String eMail, String password, String assertMessage ) {
	    authenticationPage.eMailInsert(eMail);
	    authenticationPage.passwordInsert(password);
	    authenticationPage.signInButtonClick();
	}
}