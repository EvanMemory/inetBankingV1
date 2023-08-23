package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public String baseUrl="https://demo.guru99.com/v4/";
    public String username="mngr523420";
    public String password="yhuvYjE";
    public static WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
