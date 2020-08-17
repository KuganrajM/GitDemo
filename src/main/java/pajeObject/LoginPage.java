package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver kugan;
	private By mailId =By.xpath("//*[@id='user_email']");
	private By pass=By.cssSelector("#user_password");
	private By submit = By.xpath("//*[@type='submit']");
	public LoginPage(WebDriver kugan) {
		// TODO Auto-generated constructor stub
		this.kugan=kugan;
	}
	public WebElement mailId(){
		return kugan.findElement(mailId);
		
	}
	public WebElement pass(){
		return kugan.findElement(pass);
		
	}
	public WebElement submit(){
		return kugan.findElement(submit);
		
	}

}
