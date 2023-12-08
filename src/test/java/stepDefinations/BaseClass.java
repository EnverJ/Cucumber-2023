package stepDefinations;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addCust;
    public SearchCustomerPage searchCustomer;
    public Logger logger;
    public Properties configProp;


    // generate random string for unique email id
    public static String randomString() {
        String generateString1 = RandomStringUtils.randomAlphabetic(5);
        return generateString1;
    }


}
