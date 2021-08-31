package stepdefinition;





import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Data;


public class Stepdefintion {
static WebDriver driver;

JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("I have a url")
	public void i_have_a_url() {
		System.setProperty("webdriver.chrome.driver", "/Users/kansariakartik81/Downloads/chromedriver 7");
	  driver = new ChromeDriver();

				// Write code here that turns the phrase above into concrete actions
	}

	@When("I get the url")
	public void i_get_the_url() throws InterruptedException {
		Thread.sleep(7000);
driver.navigate().to("https://www.phptravels.net/login");
Thread.sleep(3000);
driver.manage().window().maximize();
	}
	
	@Then("^it should rediect and open the URL on browser$")
	public void it_should_rediect_and_open_the_URL_on_browser()
	{
		String expected_title="PHPTRAVELS - PHPTRAVELS";
		String actual_title= driver.getTitle();
		Assert.assertEquals(expected_title, actual_title);
		System.out.println("Title is matching , Url opened is correct");
	}

	
	
	
	@Given("^I navigate to login page$")
	public void i_navigate_to_login_page() throws Throwable {
driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/div/a[2]")).click();
Thread.sleep(5000);
}

	@When("^I put <Email> and <Password>$")
	public boolean i_put_Email_and_Password(DataTable credentials) throws Throwable {
		 List<List<String>> data = credentials.raw();

			js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
			
			driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
			Thread.sleep(5000);
			driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click();
		String actualurl=driver.getCurrentUrl();
		String expectedurl="https://www.phptravels.net/account/dashboard";
		if(actualurl.equalsIgnoreCase(expectedurl))
		{
			System.out.println("Login Successfully");
		}
		else
		{
			System.out.println("Please Register");
			Thread.sleep(5000);
			System.out.println(credentials);
	driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/div/div/a")).click();
		this.i_put_First_Name_Last_Name_Phone_Email1_and_Password1(null);
		
		}
		return false;  
	}

	@When("^I click on Login$")
	public void i_click_on_Login() throws Throwable {
		 String actual_title=driver.getTitle();
		    String expected_title="Login - PHPTRAVELS";
		    Assert.assertEquals(actual_title, expected_title);
		    Thread.sleep(3000);
		    System.out.println("Title is matching , login page opened succesfully");
		    Thread.sleep(5000);
	}
	
	@Then("^I should be on Dashboard page$")
	public void i_should_be_on_Dashboard_page() throws Throwable {
String expected_title="Dashboard - PHPTRAVELS";
String actual_title= driver.getTitle();
Assert.assertEquals(actual_title, expected_title);
Thread.sleep(3000);
System.out.println("Dashboard Page");
Thread.sleep(5000);
	this.i_navigate_to_hotel_page();
	}
	
	
	@Given("^I navigate to Sign up$")
	public void i_navigate_to_Sign_up() throws Throwable {
driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/div/a[1]")).click();
	}

	@When("^I put <First Name> , <Last Name> , <Phone>, < Email1> and <Password1>$")
	public void i_put_First_Name_Last_Name_Phone_Email1_and_Password1(DataTable credentials1) throws Throwable {
		 List<List<String>> data = credentials1.raw();
Thread.sleep(5000);
	
driver.findElement(By.name("first_name")).sendKeys(data.get(0).get(0));
Thread.sleep(3000);

driver.findElement(By.name("last_name")).sendKeys(data.get(0).get(1));
Thread.sleep(3000);

driver.findElement(By.name("phone")).sendKeys(data.get(0).get(2));
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,200)");

driver.findElement(By.name("email")).sendKeys(data.get(0).get(3));
Thread.sleep(3000);
driver.findElement(By.name("password")).sendKeys(data.get(0).get(4));
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[7]/button")).click();
Thread.sleep(4000);

	}

	@When("^I click on Sign up button$")
	public void i_click_on_Sign_up_button(DataTable credentials2) throws Throwable {

      System.out.println("kartik------>");
      Thread.sleep(10000);
      System.out.println("vatsal------>");
      List<List<String>> data = credentials2.raw();

		js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click();
//this.i_put_Email_and_Password(null);
this.i_should_be_on_Dashboard_page();
Thread.sleep(4000);
System.out.println("login done");

}

	@Then("^I should be on Login Page with the expected title$")
	public void i_should_be_on_Login_Page_with_the_expected_title() throws Throwable {
		
	   Thread.sleep(5000);
	 //   this.i_put_Email_and_Password(credentials);

		String actual_title=driver.getTitle();
	    String expected_title="Login - PHPTRAVELS";
	    Assert.assertEquals(actual_title, expected_title);
	    System.out.println("Title is matching , login page opened succesfully");
	}

	@Given("^I navigate to hotel page$")
	public void i_navigate_to_hotel_page() throws Throwable {
		Thread.sleep(6000);
driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div[2]/nav/ul/li[2]/a")).click();
	}

	@When("^I put city name$")
	public void i_put_city_name() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[1]/div/div/div/span/span[1]/span")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Toronto");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")).click();
	}

	@When("^I select Check in date$")
	public void i_select_Check_in_date() throws Throwable {
driver.findElement(By.id("checkin")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr/td/span[11]")).click();
Thread.sleep(5000);
	}

	@When("^I select Check out date$")
	public void i_select_Check_out_date() throws Throwable {
		Thread.sleep(5000);	System.out.println("lets go it ");
		Thread.sleep(5000);

	}

	@When("^select travellers with Rooms, Adults and Child$")
	public void select_travellers_with_Rooms_Adults_and_Child() throws Throwable {
		System.out.println("hi this is vatsal");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/a")).click();
		Thread.sleep(5000);

	driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[1]/div/div/div[3]/i")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[1]/div/div/div[3]/i")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[1]/div/div/div[3]/i")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/i")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/i")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[3]/div/div/div[2]/i")).click();
	}

	@When("^select Nationality$")
	public void select_Nationality() throws Throwable {
		Thread.sleep(5000);

		Select drpCountry = new Select(driver.findElement(By.id("nationality")));
		drpCountry.selectByVisibleText("Canada");
	}

	@When("^I click on search hotel$")
	public void i_click_on_search_hotel() throws Throwable {
		Thread.sleep(5000);

		driver.findElement(By.id("submit")).click();
	}

	@Then("^I should be on list of hotels page\\.$")
	public void i_should_be_on_list_of_hotels_page() throws Throwable {
	   String actual_title=driver.getTitle();
			   String expected_title="Hotels in toronto - PHPTRAVELS";
			 Assert.assertEquals(actual_title, expected_title);
				Thread.sleep(5000);

				 System.out.println("Hotel in toronto link is proper");
			 
	}
	@Given("^I navigate to Flight page$")
	public void i_navigate_to_Flight_page() throws Throwable {
		Thread.sleep(5000);

driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div[2]/nav/ul/li[3]/a")).click();
	}

	@When("^I put Round Trip$")
	public void i_put_Round_Trip() throws Throwable {
		Thread.sleep(5000);

WebElement radio1=driver.findElement(By.id("one-way"));
WebElement radio2= driver.findElement(By.id("round-trip"));
radio2.click();

Thread.sleep(5000);
Select dropdown = new Select(driver.findElement(By.id("flight_type")));
dropdown.selectByIndex(0);


	}

	@When("^I select Flying From$")
	public void i_select_Flying_From() throws Throwable {
		Thread.sleep(5000);

driver.findElement(By.name("from")).sendKeys("BOM");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]")).click();
}

	@When("^I select To Destination$")
	public void i_select_To_Destination() throws Throwable {
		Thread.sleep(5000);

driver.findElement(By.name("to")).sendKeys("YYZ");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div[2]/div[1]/div/div[2]/div/div/div/div/div[1]")).click();
	}

	@When("^select Departure Date$")
	public void select_Departure_Date() throws Throwable {
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div[2]/div[2]/div/div[1]/div/div/input")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr/td/span[11]")).click();
	}

	@When("^select Return Date$")
	public void select_Return_Date() throws Throwable {
		
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[2]/td[4]")).click();
		Thread.sleep(5000);

}

	@When("^select Passengers$")
	public void select_Passengers() throws Throwable {
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div[2]/div[3]/div/div/div/a")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")).click();
Thread.sleep(5000);



 System.out.println("montere");
	}

	@When("^I click on search flight$")
	public void i_click_on_search_flight() throws Throwable {
		Thread.sleep(5000);

driver.findElement(By.id("flights-search")).click();
Thread.sleep(25000);
	}

	@Then("^I should get the list of flights$")
	public void i_should_get_the_list_of_flights() throws Throwable {
		System.out.println("toronto");

String actual_title= driver.getTitle();
String expected_title="Flights - PHPTRAVELS";
Assert.assertEquals(actual_title, expected_title);
System.out.println("Flight page is opening");
Thread.sleep(5000);
	}
	
	
	
	@Given("^I select Flight$")
	public void i_select_Flight() throws Throwable {
		Thread.sleep(5000);

        js.executeScript("window.scrollBy(0,100)");

driver.findElement(By.xpath("/html/body/main/div/div[2]/section/ul/li[1]/div/form/div/div[2]/div/button")).click();;
}

	@When("^I add traveller information <First name> and  <last name>$")
	public void i_add_traveller_information_First_name_and_last_name(DataTable Credentials) throws Throwable {
      List<List<String>> data = Credentials.raw();
		js.executeScript("window.scrollBy(0,500)");
Thread.sleep(5000);
driver.findElement(By.name("firstname_1")).clear();
driver.findElement(By.name("firstname_1")).sendKeys(data.get(0).get(0));
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.name("lastname_1")).clear();
Thread.sleep(4000);
driver.findElement(By.name("lastname_1")).sendKeys(data.get(0).get(1));
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,200)");

driver.findElement(By.name("firstname_2")).clear();
driver.findElement(By.name("firstname_2")).sendKeys(data.get(1).get(0));
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.name("lastname_2")).clear();
Thread.sleep(4000);
driver.findElement(By.name("lastname_2")).sendKeys(data.get(1).get(1));

Thread.sleep(5000);
driver.findElement(By.name("firstname_3")).clear();
driver.findElement(By.name("firstname_3")).sendKeys(data.get(2).get(0));
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.name("lastname_3")).clear();
Thread.sleep(4000);
driver.findElement(By.name("lastname_3")).sendKeys(data.get(2).get(1));

js.executeScript("window.scrollBy(0,100)");


	}

	@When("^I select the nationality$")
	public void i_select_the_nationality() throws Throwable {
		js.executeScript("window.scrollBy(0,-400)");

Select drpCountry1 = new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/select")));
drpCountry1.selectByVisibleText("India");
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,100)");

Select drpCountry2 = new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/select")));
drpCountry2.selectByVisibleText("India");
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,100)");

Select drpCountry3 = new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/select")));
drpCountry3.selectByVisibleText("India");
Thread.sleep(4000);



	}

	@When("^I select the date of birth for month , <date> and <year>$")
	public void i_select_the_date_of_birth_for_month_date_and_year(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    List <List<String>> data = arg1.raw();
	    js.executeScript("window.scrollBy(0,-300)");

	    Select drpmonth= new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/select")));
	    drpmonth.selectByVisibleText("May");
	    Thread.sleep(5000);
	    driver.findElement(By.name("dob_day_1")).clear();
	    Thread.sleep(3000);
	    driver.findElement(By.name("dob_day_1")).sendKeys(data.get(0).get(0));
	    Thread.sleep(5000);
driver.findElement(By.name("dob_year_1")).clear();
Thread.sleep(5000);
driver.findElement(By.name("dob_year_1")).sendKeys(data.get(0).get(1));
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");

Select drpmonth3= new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/select")));
drpmonth3.selectByVisibleText("June");
Thread.sleep(5000);
driver.findElement(By.name("dob_day_2")).clear();
Thread.sleep(3000);
driver.findElement(By.name("dob_day_2")).sendKeys(data.get(1).get(0));
Thread.sleep(3000);
driver.findElement(By.name("dob_year_2")).clear();
Thread.sleep(5000);
driver.findElement(By.name("dob_year_2")).sendKeys(data.get(1).get(1));
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,100)");

Select drpmonth2= new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/select")));
drpmonth2 .selectByVisibleText("August");
Thread.sleep(5000);
driver.findElement(By.name("dob_day_3")).clear();
Thread.sleep(3000);
driver.findElement(By.name("dob_day_3")).sendKeys(data.get(2).get(0));
Thread.sleep(3000);
driver.findElement(By.name("dob_year_3")).clear();
Thread.sleep(5000);
driver.findElement(By.name("dob_year_3")).sendKeys(data.get(2).get(1));
Thread.sleep(3000);
	}
	

	@When("^I select the <passport number>$")
	public void i_select_the_passport_number(DataTable arg1) throws Throwable {
		 List <List<String>> data = arg1.raw();
		 js.executeScript("window.scrollBy(0,-500)");

		 Thread.sleep(3000);
		 driver.findElement(By.name("passport_1")).clear();
		   driver.findElement(By.name("passport_1")).sendKeys(data.get(0).get(0));
		   Thread.sleep(4000);
			 js.executeScript("window.scrollBy(0,100)");

		   driver.findElement(By.name("passport_2")).clear();
		   Thread.sleep(3000);
		     driver.findElement(By.name("passport_2")).sendKeys(data.get(1).get(0));
		     Thread.sleep(3000);
			 js.executeScript("window.scrollBy(0,100)");
			 Thread.sleep(3000);
			 driver.findElement(By.name("passport_3")).clear();
				Thread.sleep(3000);
				  driver.findElement(By.name("passport_3")).sendKeys(data.get(2).get(0));
				  Thread.sleep(3000);

		   
		    
	}

	@When("^I select expiry date the month, <date> and <year>$")
	public void i_select_expiry_date_the_month_date_and_year(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,-500)");

		Select drpmonth1=new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[1]/select")));
		drpmonth1.selectByIndex(3);
		
Thread.sleep(3000);
driver.findElement(By.name("passport_day_1")).clear();
Thread.sleep(3000);
driver.findElement(By.name("passport_day_1")).sendKeys(data.get(0).get(0));
Thread.sleep(3000);
driver.findElement(By.name("passport_year_1")).clear();
Thread.sleep(3000);
driver.findElement(By.name("passport_year_1")).sendKeys(data.get(0).get(1));
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,200)");

Select drpmonth4=new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[1]/select")));
drpmonth4.selectByIndex(3);
Thread.sleep(3000);
driver.findElement(By.name("passport_day_2")).clear();
Thread.sleep(3000);
driver.findElement(By.name("passport_day_2")).sendKeys(data.get(1).get(0));
Thread.sleep(3000);
driver.findElement(By.name("passport_year_2")).clear();
Thread.sleep(3000);
driver.findElement(By.name("passport_year_2")).sendKeys(data.get(1).get(1));

js.executeScript("window.scrollBy(0,100)");

Select drpmonth5=new Select(driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[1]/select")));
drpmonth5.selectByIndex(3);
Thread.sleep(3000);
driver.findElement(By.name("passport_day_3")).clear();
Thread.sleep(3000);
driver.findElement(By.name("passport_day_3")).sendKeys(data.get(2).get(0));
Thread.sleep(3000);
driver.findElement(By.name("passport_year_3")).clear();
Thread.sleep(3000);
driver.findElement(By.name("passport_year_3")).sendKeys(data.get(2).get(1));
Thread.sleep(5000);

  
js.executeScript("window.scrollBy(0,600)");

  
  
 
	  
	  Thread.sleep(4000);
driver.findElement(By.id("gateway_pay-later")).click();
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,300)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[5]/div/button")).click();
Thread.sleep(6000);
js.executeScript("window.scrollBy(0,200)");

	} 
	
	
	
 

	@Given("^I navigte to Tour page$")
	public void i_navigte_to_Tour_page() throws Throwable {
driver.navigate().to("https://www.phptravels.net/tours");
	Thread.sleep(5000);
	}

	@When("^I select City$")
	public void i_select_City() throws Throwable {
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[1]/div/div/div/span/span[1]/span")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Mumbai");
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")).click();
Thread.sleep(5000);
	
	}

	@When("^I select date$")
	public void i_select_date() throws Throwable {
		driver.findElement(By.id("date")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr/td/span[9]")).click();
Thread.sleep(3000);

	}

	@When("^I select the number of travellers$")
	public void i_select_the_number_of_travellers() throws Throwable {
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/a")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/i")).click();
	Thread.sleep(3000);
	
	}

	@When("^I click on search Tour$")
	public void i_click_on_search_Tour() throws Throwable {
		WebElement s1=driver.findElement(By.id("submit"));
		s1.click();
		Thread.sleep(10000);
		}

	@Then("^I should get list of tours$")
	public void i_should_get_list_of_tours() throws Throwable {
String actualtitle=driver.getTitle();
String expectedtitle="Tours in mumbai - PHPTRAVELS";
Assert.assertEquals(actualtitle, expectedtitle);

	}

	@Given("^I select one tour$")
	public void i_select_one_tour() throws Throwable {
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,900)");
Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/section/ul/li[9]/div/div[2]/div/div[2]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/button[2]")).click();
		Thread.sleep(35000);
driver.navigate().back();		
Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div/div[1]/div/div[1]/div[5]/a")).click();
		
	}

	@When("^I add date$")
	public void i_add_date() throws Throwable {
driver.findElement(By.name("date")).click();	
Thread.sleep(3000);



	}

	@When("^I select number of adults$")
	public void i_select_number_of_adults() throws Throwable {
		Select dropdown3= new Select(driver.findElement(By.id("adults")));
		dropdown3.selectByIndex(1);
		Thread.sleep(3000);	}

	@When("^I select number of child$")
	public void i_select_number_of_child() throws Throwable {
		Select dropdown4=new Select(driver.findElement(By.id("childs")));
		dropdown4.selectByIndex(1);
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div/div[2]/div/div/div/form/div[1]/div/div/div/input")).click();
	}

	@When("^I book now$")
	public void i_book_now() throws Throwable {
driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div/div[2]/div/div/div/form/div[3]/button")).click();

}

	@Then("^I should be redirected to Traveller information$")
	public void i_should_be_redirected_to_Traveller_information() throws Throwable {
String expectedtitle="Booking Unplugged Mumbai by Night - PHPTRAVELS";
String actualtitle= driver.getTitle();

Assert.assertEquals(actualtitle, expectedtitle);

}

	@Given("^I navigate to traveller information for tours$")
	public void i_navigate_to_traveller_information_for_tours() throws Throwable 
	{
		String actualurl= driver.getCurrentUrl();
		String expectedurl="https://www.phptravels.net/tours/booking";
		Assert.assertEquals(actualurl, expectedurl);
		
	}

	@When("^I add Traveller information <First name> and <last name>$")
	public void i_add_Traveller_information_First_name_and_last_name(DataTable arg1) throws Throwable {
	    js.executeScript("window.scrollBy(0,200)");

		List<List<String>> data = arg1.raw();
		
Thread.sleep(5000);
driver.findElement(By.name("firstname_1")).clear();
driver.findElement(By.name("firstname_1")).sendKeys(data.get(0).get(0));
Thread.sleep(3000);
driver.findElement(By.name("lastname_1")).clear();
driver.findElement(By.name("lastname_1")).sendKeys(data.get(0).get(1));
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,200)");
Thread.sleep(3000);
driver.findElement(By.name("firstname_2")).clear();
Thread.sleep(2000);

driver.findElement(By.name("firstname_2")).sendKeys(data.get(1).get(0));
Thread.sleep(2000);
js.executeScript("window.scrollBy(0,300)");

driver.findElement(By.name("lastname_2")).clear();
Thread.sleep(2000);

driver.findElement(By.name("lastname_2")).sendKeys(data.get(1).get(1));
Thread.sleep(3000);
driver.findElement(By.name("firstname_3")).clear();
Thread.sleep(4000);

driver.findElement(By.name("firstname_3")).sendKeys(data.get(2).get(0));
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,400)");

driver.findElement(By.name("lastname_3")).clear();
Thread.sleep(2000);

driver.findElement(By.name("lastname_3")).sendKeys(data.get(2).get(1));
Thread.sleep(3000);

	}

	@When("^add payment method$")
	public void add_payment_method() throws Throwable {
		driver.findElement(By.name("payment_gateway")).click();
		Thread.sleep(3000);
	}

	@When("^I confirm the booking$")
	public void i_confirm_the_booking() throws Throwable {
Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[5]/div/button")).click();
		Thread.sleep(3000);
	  	}

	@Then("^I should get the confirmation$")
	public void i_should_get_the_confirmation() throws Throwable {
		String actualtitle=driver.getTitle();
		String expectedtitle="Mumbai Street Food Tour";
		Assert.assertEquals(actualtitle, expectedtitle);
		Thread.sleep(3000);
	  	}

	@Given("^I navigate to car page$")
	public void i_navigate_to_car_page() throws Throwable 
	{
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
		driver.navigate().to("https://www.phptravels.net/cars");

String actualtitle= driver.getTitle();
String expectedtitle="Search Cars - PHPTRAVELS";
Assert.assertEquals(actualtitle, expectedtitle);
}

	@When("^I select Return$")
	public void i_select_Return() throws Throwable {
Thread.sleep(4000);	
WebElement radio1= driver.findElement(By.id("cars_oneway"));
WebElement radio2= driver.findElement(By.id("cars_return"));
radio2.click();


	
	}

	@When("^I select origin$")
	public void i_select_origin() throws Throwable {
Thread.sleep(5000);	
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div[2]/div[1]/div/div[1]/div/div/div/span/span[1]/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Mumbai");
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")).click();
	Thread.sleep(4000);
	
	}

	@When("^I select Destination$")
	public void i_select_Destination() throws Throwable {
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div[2]/div[1]/div/div[2]/div/div/div/span/span[1]/span")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("delhi");
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
Thread.sleep(3000);
	}

	@When("^I select From Date$")
	public void i_select_From_Date() throws Throwable {
	}

	@When("^I select End Date$")
	public void i_select_End_Date() throws Throwable {
	}

	@When("^I select traveller$")
	public void i_select_traveller() throws Throwable {
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div[2]/div[3]/div/div/div/a")).click();
Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div[2]/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")).click();
Thread.sleep(3000);	
	}

	@When("^I click on search cars$")
	public void i_click_on_search_cars() throws Throwable {
driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div/div[2]/div[4]/div")).click();
}

	@Then("^I should be able to get the cars$")
	public void i_should_be_able_to_get_the_cars() throws Throwable {
		Thread.sleep(4000);
driver.findElement(By.xpath("")).click();
	
	}
	
	@Given("^I navigate to dashboard page$")
	public void i_navigate_to_dashboard_page() throws Throwable {
		driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/div/div[2]/div/button")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/div/div[2]/div/ul/li[1]/a")).click();
	Thread.sleep(4000);
	
	}
	
	@When("^I select mybookings$")
	public void i_select_mybookings() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/ul/li[2]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/div/table/tbody/tr[2]/td[4]/div/a")).click();
	Thread.sleep(4000);
	js.executeScript("window.scrollBy(0,200)");
Thread.sleep(3000);
ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(tabs2.get(1));
driver.close();
driver.switchTo().window(tabs2.get(0));
Thread.sleep(4000);

	}

	@When("^add funds$")
	public void add_funds() throws Throwable {
	
	driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/ul/li[3]/a")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("gateway_bank-transfer")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/button")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div/div[2]/div[2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/a")).click();
	}

	@When("^I click on myprofile$")
	public void i_click_on_myprofile() throws Throwable {
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/ul/li[4]/a")).click();
	Thread.sleep(4000);
	js.executeScript("window.scrollBy(0,350)");
	driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[1]/table/tbody/tr[6]/td[3]/div/div/span")).click();
	
	Thread.sleep(4000);
	driver.findElement(By.id("select2-from_country-result-kjoc-IN")).click();
Thread.sleep(5000);
driver.findElement(By.name("state")).sendKeys("Maharashtra");
Thread.sleep(3000);
driver.findElement(By.name("city")).sendKeys("Mumbai");
Thread.sleep(5000);
driver.findElement(By.name("zip")).sendKeys("4098900");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");

driver.findElement(By.name("address1")).sendKeys("Mahalaxmi area");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[3]/button")).click();

	}

	@When("^I Click on logout$")
	public void i_Click_on_logout() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/ul/li[5]/a")).click();
		
	 }

	@Then("^I should be back on home page$")
	public void i_should_be_back_on_home_page() throws Throwable {
		
		String actualurl=driver.getCurrentUrl();
		String expectedurl="https://www.phptravels.net/login";
		Assert.assertEquals(actualurl, expectedurl);
		driver.close();
	    	}
}

