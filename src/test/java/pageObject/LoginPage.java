package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id= "Email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id= "Password")
	@CacheLookup
	WebElement pswd;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement login;
	
	@FindBy(xpath= "//*[@id=\"navbarText\"]/ul/li[3]/a")
	WebElement logout;
	
	public void enterEmail(String mail)
	{
		email.clear();
		email.sendKeys(mail);
	}
	
	public void enterPassword(String pwd) {
		pswd.clear();
		pswd.sendKeys(pwd);
	}

	public void loginButton() {
		login.click();
	}
	
	public void logoutButton() {
		logout.click();
	}
	
}
