package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;

public class LandingPageTitleValidation extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized. ");
	}

	@Test
	public void titleTest() throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage. ");
		LandingPage landing = new LandingPage(driver);
		Assert.assertEquals(landing.titleElement().getText(), "FEATURED COURSESs");
		log.info("Text message validated. ");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null; //For clearing the memory occupied by driver in the Heap, before another driver opens a browser window.
	}
	
}
