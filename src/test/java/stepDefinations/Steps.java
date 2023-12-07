package stepDefinations;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps extends BaseClass {


    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }

    @When("User opens urls {string}")
    public void user_opens_urls(String url) {
        driver.get(url);
    }

    @When("I entered valid username as {string} and password as  {string}")
    public void i_entered_valid_username_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);

    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        lp.clickLogin();

    }

    @Then("adminAreaDmo Title should be {string}")
    public void admin_area_dmo_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }

    }

    @When("user click on logout link")
    public void user_click_on_logout_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);

    }

    @Then("page title should be {string}")
    public void page_title_should_be(String exptitle) throws InterruptedException {

        if (driver.getPageSource().contains("Login was unsuccessful")) {
            //     logger.info("************* Login failed *****************");
            driver.close();
            Assert.assertTrue(false);
        } else {
            //     logger.info("************* Login Passed *****************");
            Assert.assertEquals(exptitle, driver.getTitle());
        }
        Thread.sleep(3000);

    }

    @Then("close the browser")
    public void close_the_browser() {
        driver.close();

    }

    // Customer feature step definitions...
    @Then("User can view Dashboad")
    public void user_can_view_dashboad() throws InterruptedException {
        Thread.sleep(3000);
        addCust = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());

    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomersMenu();

    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomersMenuItem();

    }

    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
        addCust.clickOnAddnew();
        Thread.sleep(2000);

    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());

    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = randomString() + "@gmail.com";
        addCust.setEmail(email);
        addCust.setPassword("admin123");
        addCust.setCustomerRoles("Guest");
        Thread.sleep(2000);

        addCust.setManagerOfVendor("Vendor 2");
        addCust.setGender("Male");
        addCust.setFirstName("Yasin");
        addCust.setLastName("Davut");
        addCust.setDob("9/10/1998");
        addCust.setCompanyName("awesomeQA");
        addCust.setAdminContent("This is for awesome QA");


    }

    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
        addCust.clickOnSave();
        Thread.sleep(2000);

    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(message));


    }

    // steps for searching a customer using emailID
    @When("Enter customer Email")
    public void enter_customer_email() {
        searchCustomer = new SearchCustomerPage(driver);
         searchCustomer.setEmail("victoria_victoria@nopCommerce.com");

    }
    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCustomer.clickSearch();
        Thread.sleep(3000);

    }
    @Then("User should found Email in the serach table")
    public void user_should_found_email_in_the_serach_table() {
        boolean status=searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true, status);
    }

    // Search customer using name
    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
        searchCustomer = new SearchCustomerPage(driver);
        searchCustomer.setFirstName("Victoria");

    }
    @When("Enter customer LastName")
    public void enter_customer_last_name() {
        searchCustomer.setLastName("Terces");



    }
    @Then("User should found name in the serach table")
    public void user_should_found_name_in_the_serach_table() {
        boolean status= searchCustomer.searchCustomerByName("Victoria Terces");
        Assert.assertEquals(true, status);

    }




}
