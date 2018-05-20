package step.definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	WebDriver driver;

	@Given("^User on Mercury Tours home page$")
	public void user_on_Mercury_Tours_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^User entered valid \"(.*)\" and \"(.*)\"$")
	public void user_entered_valid_and(String username, String password) throws Throwable {

		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();

	}

	@Then("^Flight reservation page should open$")
	public void flight_reservation_page_should_open() throws Throwable {

		if (driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
			System.out.println("LOGIN DONE");
		} else
			System.out.println("FAILED LOGIN");
		driver.close();

	}

}
