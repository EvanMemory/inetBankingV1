package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest(){

        logger.info("URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        logger.info("Entered username");
        loginPage.setPassword(password);
        logger.info("Entered password");
        loginPage.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        } else
        {
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }
}
