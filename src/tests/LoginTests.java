package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@Test
	public void loginTest() throws Exception {
		driver.navigate().to("https://www.youtube.com/watch?v=ejhsfSh9pdU&ab_channel=MetropolisMusicSerbia");
	}

}
