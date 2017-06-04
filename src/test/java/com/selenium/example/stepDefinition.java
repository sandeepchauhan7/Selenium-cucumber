package test.java.com.selenium.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {

	ProfilesIni allProfiles = null;
	FirefoxProfile profile = null;
	WebDriver driver = null;	
	WebElement enter=null;
	String OS = System.getProperty("os.name").toLowerCase();
	
	@Given("^I navigate to \"([^\"]*)\" in firefox$")
	public void i_navigate_to(String url) throws Throwable {
		if(OS.contains("windows")){
			System.setProperty("webdriver.gecko.driver", "src/test/resources/com/selenium/example/windows/geckodriver.exe");
		}else if(OS.contains("linux")){
			System.setProperty("webdriver.gecko.driver", "src/test/resources/com/selenium/example/linux/geckodriver");
		}
		allProfiles =new ProfilesIni();
		profile = allProfiles.getProfile("skipssl");		
		driver = new FirefoxDriver(profile); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	@Given("^I navigate to \"([^\"]*)\" in headless browser$")
	public void i_navigate_to_in_headless_browser(String url) throws Throwable {
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	    throw new PendingException();
	}

	
	@Given("^I enter \"([^\"]*)\" into input field having id \"([^\"]*)\"$")
	public void i_enter_into_input_field_having_id(String fname, String fname_id) throws Throwable {
	    driver.findElement(By.id(fname_id)).sendKeys(fname);
	   // throw new PendingException();
	}
	@When("^I press enter$")
	public void i_press_enter() throws Throwable {	  
	    enter = driver.findElement(By.xpath("//*[@id='registerForm']/div[11]/button"));
	    enter.sendKeys(Keys.RETURN);
	    //throw new PendingException();
	}
	@When("^I press Login$")
	public void i_press_Login() throws Throwable {
		System.out.println("hi");
		 enter = driver.findElement(By.xpath("//*[@id='loginForm']/button"));
		 enter.sendKeys(Keys.RETURN);
	    throw new PendingException();
	}
	@When("^I wait for (\\d+) sec$")
	public void i_wait_for_sec(int sec) throws Throwable {
	    Thread.sleep(sec*1000);
	    //throw new PendingException();
	}
	@When("^take screenshot with filename \"([^\"]*)\"$")
	public void take_screenshot_with_filename(String fileName) throws Throwable {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrFile, new File("src/Screenshot/"+fileName));
	    throw new PendingException();
	}
	@Then("^I close browser$")
	public void i_close_browser() throws Throwable {
	    driver.quit();
	}
 }
