package StepDefns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Steps {
	public ExcelReader er = new ExcelReader();
	private HomePage hPage = new HomePage(DriverFactory.getDriver());
	public String value;

	@Given("user navigate to home page")
	public void i_navigate_to_home_page() {
		hPage.launchURL(System.getProperty("user.dir")+"/QE-index.html");
	}

	@Then("user verify and enter {string} in username field")
	public void i_verify_and_enter_in_username_field(String string) {
		Assert.assertTrue(hPage.EnterUsername(string));
	}

	@Then("user verify and enter {string} in password field")
	public void i_verify_and_enter_in_password_field(String string) {
		Assert.assertTrue(hPage.EnterPassword(string));

	}

	@Then("user verify and click on login button")
	public void i_verify_and_click_on_login_button() {
		Assert.assertTrue(hPage.ClickSignIn());
	}


	@When("user is on home page")
	public void user_is_on_home_page() {
		Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Home");
	}

	@Then("user verify {int} values in listgroup")
	public void user_verify_values_in_listgroup(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(hPage.verifyListgroupNumber() == int1);

	}

	@Then("user verify second list item is {string}")
	public void user_verify_second_list_item_is(String string) {
		Assert.assertTrue(hPage.verifySecondListValue().contains(string));
	}

	@Then("user verify second list item badge value is {string}")
	public void user_verify_second_list_item_badge_value_is(String str) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(hPage.verifySecondListBadge().equals(str));
	}

	@Then("user verify {string} is the default selected value")
	public void user_verify_is_the_default_selected_value(String string) {
		Assert.assertTrue(hPage.verifydropdownvalue().contains(string));
	}

	@Then("user selects {string} from the select list")
	public void user_selects_from_the_select_list(String string) {
		// Write code here that turns the phrase above into concrete actions
		hPage.selectdropdownvalue(string);
	}


	@Then("user verify the first button is enabled")
	public void user_verify_the_first_button_is_enabled() {
		Assert.assertTrue(hPage.verifyStatusofFirstButton());
	}



	@Then("user verify the second button is disabled")
	public void user_verify_the_second_button_is_disabled() {
		Assert.assertTrue(hPage.verifyStatusofSecondButton());
	}


	@Then("user clicks on button")
	public void user_clicks_on_button() {
		hPage.clickonFifthCaseButton();
	}



	@Then("user verify success message is displayed")
	public void user_verify_success_message_is_displayed() {
		Assert.assertTrue(hPage.verifySuccessMessage());
	}
	@Then("user verify the button is disabled")
	public void user_verify_the_button_is_disabled() {
		Assert.assertTrue(hPage.verifyStatusofFifthButton());
	}


	@Then("user provides {int} as row and {int} as column number")
	public void user_provides_row_and_column_number(int row, int col) {
		int colNum = col+1;
		int RowNum = row+1;
		
		value = DriverFactory.getDriver().findElement(By.xpath("//table//tr["+RowNum+"]/td["+colNum+"]")).getText();
		System.out.println(value);
	}



	@Then("verifies the value {string}")
	public void verifies_the_value(String string) {
		Assert.assertEquals(value, string);
	}




}
