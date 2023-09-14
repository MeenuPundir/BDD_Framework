package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class StepDef {

	WebDriver driver;

	LoginPage lp;
	//LoginPage lp = new LoginPage(driver);

	@Given("user Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		lp = new LoginPage(driver);
	}

	@When("User opens url {string}")
	public void openUrl(String url) {
		driver.get(url);
	}

	@When("User enter Email as {string} and Password as {string}")
	public void EnterEmailAndPassword(String mail, String pwd) {
		lp.enterEmail(mail);
		lp.enterPassword(pwd);

	}

	@When("Click on Login")
	public void clickLogin() {
		lp.loginButton();
	}

	@Then("Page Title should be {string}")
	public void pageTitleShouldBe(String exptitle) {

		String actualtitle = driver.getTitle();

		if (actualtitle.equals(exptitle)) {

			System.out.println("True");
		} else {
			System.out.println("False");

		}
	}

	@When("User click on the log out link")
	public void clickLogoutLink() {
		lp.getClass();
	}

	@When("Close the Browser")
	public void closeBrowser() {
		driver.close();
	}

}

