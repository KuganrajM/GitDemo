package completeFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pajeObject.LandingPage;
import pajeObject.LoginPage;
import resources.base;

public class ValidateText extends base {
	public WebDriver kugan;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void start_Driver() throws IOException {
		kugan = intializeDriver();
		log.info("Driver Intialized");
		kugan.get(prop.getProperty("url"));
		log.info("URL Opened in Browser");
	}

	@Test
	public void vali_Text() throws IOException {
		LandingPage landing = new LandingPage(kugan);
		Assert.assertEquals(landing.course().getText(), "FEATURED COURSES");
		log.info("Text Validated");
		Assert.assertTrue(false);
System.out.println("Kugan");

	}

	@AfterTest
	public void close() {
		kugan.close();
	}

	  
}