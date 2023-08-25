package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class TC_AddCustomerTest_003 extends BaseClass {

    @Test
    public void addNewCustomer() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        logger.info("Username is provided");
        loginPage.setPassword(password);
        logger.info("Password is provided");
        loginPage.clickSubmit();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.clickAddNewCustomer();

        logger.info("providing customer details...");
        addCustomerPage.custName("Evan");
        addCustomerPage.custGender("male");
        addCustomerPage.custDob("01", "01", "1992");
        addCustomerPage.custAddress("USA");
        addCustomerPage.custCity("Watertown");
        addCustomerPage.custState("MA");
        addCustomerPage.custpinno("123456789");
        addCustomerPage.custTelephoneNo("8675309");
        String email = randomString()+"@gmail.com";
        addCustomerPage.custEmailId(email);
        addCustomerPage.custPassword("abcdefg");
        addCustomerPage.custSubmit();

        logger.info("validation started...");
        if (driver.getPageSource().contains("Customer Registered Successfully!!!")) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "addNewCustomer");
            Assert.assertTrue(false);
        }
    }
}
