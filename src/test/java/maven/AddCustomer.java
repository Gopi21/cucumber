package maven;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

	@When("the user enter the customer details")
	public void the_user_enter_the_customer_details(DataTable dataTable) {
	//	List<String> list = dataTable.asList();
//		driver.findElement(By.xpath("//label[text()='Done']")).click();
//		driver.findElement(By.id("fname")).sendKeys(list.get(1));
	//	driver.findElement(By.id("lname")).sendKeys(list.get(2));
//		driver.findElement(By.id("email")).sendKeys(list.get(3));
	//	driver.findElement(By.name("addr")).sendKeys(list.get(4));
//		driver.findElement(By.id("telephoneno")).sendKeys(list.get(5));
		
	Map<String, String> ma = dataTable.asMap(String.class, String.class);
	}

	@When("The user clicks the submit button")
	public void the_user_clicks_the_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("The user should see a customer id generated")
	public void the_user_should_see_a_customer_id_generated() {
		
		Assert.assertEquals("Please Note Down Your CustomerID", driver.findElement(By.xpath("//table[@class='alt access']//tr[2]")).getText());
	}

}
