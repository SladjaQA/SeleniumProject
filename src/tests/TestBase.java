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
import pages.MyPersonalInformationPage;
import pages.MyWishlistPage;
import pages.AuthenticationPage;

public class TestBase {

	WebDriver driver;
	ExcellReader excellReader;
	HomePage homePage;
	AuthenticationPage authenticationPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	MyPersonalInformationPage myPersonalInformationPage;
	MyWishlistPage myWishlistPage;
	String name;
	String surname;
	String eMail;
	String password;
	String currentPassword;
	String address;
	String assertMessage;
	String textForAssert;
	String textForAssert2;
	String city;
	String zip;
	String mob;
	String alias;
	String label;
	int number;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
	    excellReader = new ExcellReader("Test Plan/TestCase.xlsx");
	    homePage = new HomePage(driver);
	    authenticationPage = new AuthenticationPage(driver);
	    myAccountPage = new MyAccountPage(driver);
	    myAddressesPage = new MyAddressesPage(driver);
	    myPersonalInformationPage = new MyPersonalInformationPage(driver);
	    myWishlistPage = new MyWishlistPage(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	//Method for AuthenticationPage
	
	public void logIn() {
	    homePage.signInButtonClick();
	    authenticationPage.eMailInsert(excellReader.getData("login",8,4));
	    authenticationPage.passwordInsert(excellReader.getData("login",9,4));
	    authenticationPage.signInButtonClick();
		Assert.assertEquals(myAccountPage.getWelcomeMessage().getText(),excellReader.getData("login",10,6));
	}
	
	//Method for MyAddressesPage
	
	public void setValidAddress() {
		address = excellReader.getData("My address", 8, 4);
		assertMessage = excellReader.getData("My address", 9, 4);
		myAddressesPage.updateButtonClick();
		myAddressesPage.newAddressInsert(address);
		myAddressesPage.addressTitleInsert(assertMessage);
		myAddressesPage.updateSaveClick();
	}
	
	//Methods for MyPersonalInfoPage
	
	public void editPaswordBack() {
    	name = excellReader.getData("My personal info", 46, 4);
		surname = excellReader.getData("My personal info", 47, 4);
		eMail = excellReader.getData("My personal info", 48, 4);
		currentPassword = excellReader.getData("My personal info", 50, 5);
		password = excellReader.getData("My personal info", 49, 4);
		driver.navigate().to("http://automationpractice.com/index.php?controller=identity");
		myPersonalInformationPage.firstNameInsert(name);
		myPersonalInformationPage.lastNameInsert(surname);
		myPersonalInformationPage.eMailInsert(eMail);
		myPersonalInformationPage.validPasswordInsert(currentPassword);
		myPersonalInformationPage.newPasswordInsert(password);
		myPersonalInformationPage.newPasswordConfirmationFieldInsert(password);
		myPersonalInformationPage.savePersonalInfoButtonClick();
	}
	
	public void setValidPersonalInfo() {
		name = excellReader.getData("My personal info", 46, 4);
		surname = excellReader.getData("My personal info", 47, 4);
		eMail = excellReader.getData("My personal info", 48, 4);
		currentPassword = excellReader.getData("My personal info", 49, 4);
		driver.navigate().to("http://automationpractice.com/index.php?controller=identity");
		myPersonalInformationPage.firstNameInsert(name);
		myPersonalInformationPage.lastNameInsert(surname);
		myPersonalInformationPage.eMailInsert(eMail);
		myPersonalInformationPage.validPasswordInsert(currentPassword);
		myPersonalInformationPage.savePersonalInfoButtonClick();
	}
	
	//Method for MyWishlstPage
	public void addingWishlist(String name) {
		myAccountPage.MyWishlistsButtonClick();
		myWishlistPage.nameOfWishlistInsert(name);
		myWishlistPage.saveWishlistButtonClick();
		number = myWishlistPage.countWishlists();
	}

	@AfterClass
	public void posleKlase() throws IOException {
		driver.close();
		excellReader.fis.close();
		excellReader.wb.close();
	}

}