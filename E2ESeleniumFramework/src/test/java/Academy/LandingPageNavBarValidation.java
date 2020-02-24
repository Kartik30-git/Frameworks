package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;

public class LandingPageNavBarValidation extends Base{
	@Test
	public void navTest() throws IOException {
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage landing = new LandingPage(driver);
		Assert.assertTrue(landing.navElement().isDisplayed());
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null; //For clearing the memory occupied by driver in the Heap, before another driver opens a browser window.
	}
}
