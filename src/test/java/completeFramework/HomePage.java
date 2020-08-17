package completeFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pajeObject.LandingPage;
import pajeObject.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver kugan;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void start_Driver() throws IOException {
		kugan = intializeDriver();
		log.info("Driver Intialized");

	}

	@Test(dataProvider = "getdata")
	public void open_browser(String mailId, String pass) throws IOException {
		kugan.get(prop.getProperty("url"));
		log.info("URL Opened in Browser");
		LandingPage landing = new LandingPage(kugan);
		landing.login().click();
		LoginPage login = new LoginPage(kugan);
		login.mailId().sendKeys(mailId);
		login.pass().sendKeys(pass);
		login.submit().click();
		log.info("Submit button clicked");
	}

	@AfterTest
	public void close() {
		kugan.close();
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[2][2];
		data[0][0] = "123@gmail.com";
		data[0][1] = "zxcv";
		data[1][0] = "456@gmail.com";
		data[1][1] = "zxcv";
		return data;

	}
}
