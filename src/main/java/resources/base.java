package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public static WebDriver kugan;
	public Properties prop;

	public WebDriver intializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir")
						+ "\\src\\main\\java\\resources\\Data.properties");

		prop.load(file);
		// String browsername = prop.getProperty("browser");
		String browsername = System.getProperty("browser");

		if (browsername.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Automation\\chromedriver.exe");
			// ChromeOptions option = new ChromeOptions();
			// if (browsername.contains("headless")){
			// option.addArguments("headless");
			// }
			// kugan = new ChromeDriver(option);
			kugan = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Automation\\geckodriver.exe");
			kugan = new FirefoxDriver();

		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Automation\\Microsoftwebdriver.exe");
			kugan = new InternetExplorerDriver();

		}
		kugan.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return kugan;
	}

	public String screenshot(String testcaseName, WebDriver kugan)
			throws IOException {
		File src = ((TakesScreenshot) kugan).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("User.Dir") + "\\reports\\"
				+ testcaseName + ".png";
		FileUtils.copyFile(src, new File(destination));
		return destination;
	}
}
