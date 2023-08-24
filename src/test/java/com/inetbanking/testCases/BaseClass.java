package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseUrl= readConfig.getApplicationUrl();
    public String username= readConfig.getUsername();
    public String password= readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setup(){
        System.setProperty("Webdriver.chrome.driver", readConfig.getChromepath());
        driver = new ChromeDriver();

        logger = Logger.getLogger(BaseClass.class);
        BasicConfigurator.configure();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
