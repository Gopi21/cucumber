package maven;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomer {
	static WebDriver driver;

	@Given("The user is in guru telecome home page")
	public void the_user_is_in_guru_telecome_home_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Gopi\\eclipse-workspace\\cucumber\\maven\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");
	}

	@Given("The customer navigates to add customer page")
	public void the_customer_navigates_to_add_customer_page() {
		driver.findElement(By.xpath("(//a[@href='addcustomer.php'])[1]")).click();
	}

	@When("the user enter the customer details and clicks the submit button")
	public void the_user_enter_the_customer_details(DataTable dataTable) {
		List<Map<String, String>> ma = dataTable.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys(ma.get(1).get("fname"));
		driver.findElement(By.id("lname")).sendKeys(ma.get(1).get("lname"));
		driver.findElement(By.id("email")).sendKeys(ma.get(1).get("email"));
		driver.findElement(By.name("addr")).sendKeys(ma.get(1).get("addr"));
		driver.findElement(By.id("telephoneno")).sendKeys(ma.get(1).get("telephoneno"));

	}

	@When("The user navigates to home page and cliks on Add Tariff Plan to Customer")
	public void the_user_clicks_the_submit_button() throws Throwable {
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//div[@class='table-wrapper']//h3")).getText();
		driver.findElement(By.xpath("//a[@class='button']")).click();
		driver.findElement(By.xpath("//div[@class='flex-item left']//a[text()='Add Tariff Plan to Customer']")).click();
		driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement radio = driver.findElement(By.xpath("//label[@for='sele']"));
		radio.isSelected();
		driver.findElement(By.xpath("//input[@name='submit']")).click();

	}

	@Then("The user should see a customer id generated")
	public void the_user_should_see_a_customer_id_generated() {

		Assert.assertEquals("Please Note Down Your CustomerID",
				driver.findElement(By.xpath("//table[@class='alt access']//tr[2]")).getText());

	}

}
