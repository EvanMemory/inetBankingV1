package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseUrl= readConfig.getApplicationUrl();
    public String username= readConfig.getUsername();
    public String password= readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br){

        logger = Logger.getLogger(BaseClass.class);
        BasicConfigurator.configure();

        if(br.equals("chrome")) {
            System.setProperty("Webdriver.chrome.driver", readConfig.getChromepath());
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            System.setProperty("Webdriver.gecko.driver", readConfig.getFirefoxpath());
            driver = new FirefoxDriver();
        } else if (br.equals("edge")) {
            System.setProperty("Webdriver.ie.driver", readConfig.getEdgepath());
            driver = new EdgeDriver();
        }
        driver.get(baseUrl);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
