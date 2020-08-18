package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver kugan;
	private By log =By.linkText("Login");
	private By course = By.cssSelector("#content > div > div > h2");
	
	public LandingPage(WebDriver kugan) {
		// TODO Auto-generated constructor stub
		this.kugan=kugan;
	}
	public WebElement login(){
		System.out.println("It will return log element");
		return kugan.findElement(log);
		
	}
	public WebElement course(){
		return kugan.findElement(course);
		
	}

}
