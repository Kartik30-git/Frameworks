package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;

public class HomePageTest extends Base {
	@Test(dataProvider="getData")
	public void basePageNavigation(String userId, String pass, String text) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage landing = new LandingPage(driver);
		landing.loginElement().click();
		LoginPage login = new LoginPage(driver);
		login.emailElement().sendKeys(userId);
		login.passwordElement().sendKeys(pass);
		login.submitElement().click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null; //For clearing the memory occupied by driver in the Heap, before another driver opens a browser window.
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		//1st Set
		data[0][0]="nbisht30@gmail.com";
		data[0][1]="riders123";
		data[0][2]="something";
		
		//2nd set
		data[1][0]="nbisht30@yahoo.com";
		data[1][1]="riders123";
		data[1][2]="something";
		
		return data;

	}

}
