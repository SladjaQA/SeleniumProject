package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistPage {
	WebDriver driver;
	WebElement nameOfWishlist;
	WebElement saveWishlistButton;
	WebElement wishlistDelete;
	List<WebElement> Wishlist;

	public MyWishlistPage(WebDriver driver) {
		this.driver = driver;
	}
	
	List<WebElement> getWishlist() {
		return driver.findElements(By.tagName("tr"));
	}

	public WebElement getNameOfWishlist() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveWishlistButton() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public WebElement getWishlistDelete() {
		return driver.findElement(By.className("icon-remove"));
	}

	public void nameOfWishlistInsert(String name) {
		this.getNameOfWishlist().clear();
		this.getNameOfWishlist().sendKeys(name);
	}
	
	public void saveWishlistButtonClick() {
		this.getSaveWishlistButton().click();
	}
	
	public void wishlistDeleteClick() {
		this.getWishlistDelete().click();
	}
	
	public int countWishlists() {
		System.out.println(getWishlist().size());
		return getWishlist().size();
	}
	
}
