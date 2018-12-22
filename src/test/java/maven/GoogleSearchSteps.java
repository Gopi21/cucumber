package maven;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
	static WebDriver driver;

	@Given("The user is in google home page")
	public void The_user_is_in_google_home_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Gopi\\eclipse-workspace\\cucumber\\maven\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
	}

	@When("The user search for a text")
	public void The_user_search_for_a_text() {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium", Keys.ENTER);

	}

	@Then("The user should be in search result page")
	public void The_user_should_be_in_search_result_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("search"));

	}

}
