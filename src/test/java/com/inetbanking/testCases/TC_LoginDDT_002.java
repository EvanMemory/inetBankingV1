package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginDDT(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        logger.info("username is provided");
        loginPage.setPassword(password);
        logger.info("password is provided");
        loginPage.clickSubmit();
        if (isAlertPresent()) {
            driver.switchTo().alert().accept(); // close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
            logger.info("Login passed");
            loginPage.clickLogout();
            driver.switchTo().alert().accept(); // close logout alert
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }

    }

    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";

        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }

}
