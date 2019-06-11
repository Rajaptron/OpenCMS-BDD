package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefination {
	
	
	WebDriver driver;
	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page() throws Throwable {
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
	      driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(" https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
	}

	@When("^title of login page is Username or Email Address$")
	public void title_of_login_page_is_Username_or_Email_Address() throws Throwable {
		Thread.sleep(1000);
		String title = driver.findElement(By.xpath("//form[@id='loginform']/p[1]/label")).getText();
		Assert.assertTrue(title.contains(("Username or Email Address")));
		
		
	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
		Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
	  
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		Thread.sleep(1000);
	   String hompagetitile = driver.findElement(By.xpath("//div[@class='wrap']/h1")).getText();
	   Thread.sleep(1000);
	   Assert.assertEquals("Dashboard",hompagetitile);
	}
	
	

	@Then("^click on users link at left side of website$")
	public void click_on_users_link_at_left_side_of_website() throws Throwable {
		Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@id='wp-toolbar']/ul[1]/li[3]/a")).click();
	}

	@Then("^user moves to new user page and click on Add new button$")
	public void user_moves_to_new_user_page_and_click_on_Add_new_button() throws Throwable {
		
		/* Actions action =    new Actions(driver);
	        action.moveToElement(driver.findElement(By.xpath("//div[@id='wp-toolbar']/ul[1]/li[6]/a"))).perform();
	        Thread.sleep(500);
	        action.click(driver.findElement(By.xpath("//div[@id='wp-toolbar']/ul[1]/li[6]/div/ul/li[7]/a"))).perform();
		
		*/
		driver.findElement(By.xpath("//div[@id='adminmenuwrap']/ul/li[10]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='wpbody-content']/div[3]/a")).click();
		
	}

	@Then("^user enters new user details \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_new_user_details_and_and_and(String username, String email, String firstname, String lastname,String role) throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
		Thread.sleep(500);
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(firstname);
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(lastname);
	    Thread.sleep(500);
	    Select Role = new Select(driver.findElement(By.xpath("//select[@id='role']")));
	    Role.selectByVisibleText(role);
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//input[@id='createusersub']")).click();
	    
	}

	@Then("^verify user is created\"([^\"]*)\"$")
	public void verify_user_is_created(String username) throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='user-search-input']")).sendKeys(username);
		Thread.sleep(500);
		String realusername =driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped users']/tbody/tr[1]/td[1]/strong/a")).getText();
		Assert.assertEquals(username, realusername);
	}
	
	
	@Then("^verify user is created$")
	public void verify_user_is_created() throws Throwable {
	   
	}
	
	



	@Then("^click on page link at left side of website$")
	public void click_on_page_link_at_left_side_of_website() throws Throwable {
		driver.findElement(By.xpath("//div[@id='adminmenuwrap']/ul/li[5]/a")).click();
	}

	@Then("^user moves to create page and enter your page name in text area$")
	public void user_moves_to_create_page_and_enter_your_page_name_in_text_area() throws Throwable {
	    Thread.sleep(1000);	
		driver.findElement(By.xpath("//div[@class='wrap']/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='post-title-0']")).sendKeys("transility");
	}

	@Then("^click on publish$")
	public void click_on_publish() throws Throwable {
	    driver.findElement(By.xpath("//div[@class='edit-post-header__settings']/button")).click();
        Thread.sleep(1000);
	}

	@Then("^confirm on publish$")
	public void confirm_on_publish() throws Throwable {
		 driver.findElement(By.xpath("//div[@class='editor-post-publish-panel__header']/div/button")).click();
	        Thread.sleep(1000);
	}

	@Then("^verify your new create page with user name$")
	public void verify_your_new_create_page_with_user_name() throws Throwable {
		driver.findElement(By.xpath("//div[@id='adminmenuwrap']/ul/li[5]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='post-search-input']")).sendKeys("transility");
	    driver.findElement(By.xpath("//input[@id='search-submit']")).click();
	    Thread.sleep(1000);
	    String Pagetile= driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped pages']/tbody/tr/td[1]/strong")).getText().trim();
		Thread.sleep(1000);
		Assert.assertEquals("transility", Pagetile);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

@Given("^a book exists with an isbn of (\\d+)$")
public void a_book_exists_with_an_isbn_of(int arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
}

@When("^a user retrieves the book by isbn$")
public void a_user_retrieves_the_book_by_isbn() throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
}

@Then("^the status code is (\\d+)$")
public void the_status_code_is(int arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
}

@Then("^The Response body contains an object in JSON format$")
public void The_Response_body_contains_an_object_in_JSON_format() throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
}

@Then("^close the browser$")
public void close_the_browser() {
	driver.close();
}
	

}
