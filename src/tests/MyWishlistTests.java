package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		logIn();
	}

	@Test (priority = 0)
	public void addingOneWishlist() throws Exception {
		name = excellReader.getData("My wishlist", 7, 4);
        addingWishlist(name);
        Assert.assertEquals(number, 1+1); //+1 because the header of the table is also counted as a row.
	}

	@Test (priority = 5)
	public void addingMultipleWishlist() throws Exception {
		name = excellReader.getData("My wishlist", 17, 4);
        addingWishlist(name);
		name = excellReader.getData("My wishlist", 19, 4);
        addingWishlist(name);
        Assert.assertEquals(number, 3+1);
	}
	
	@Test (priority = 10)
	public void deletingWishlist() throws Exception {
		myAccountPage.MyWishlistsButtonClick();
		number = myWishlistPage.countWishlists();
	    while(number != 0) {
	    myWishlistPage.wishlistDeleteClick();
	    driver.switchTo().alert().accept();
	    number--;
	    }
	    Assert.assertEquals(number, 0);
	} 
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();	
	}
}
