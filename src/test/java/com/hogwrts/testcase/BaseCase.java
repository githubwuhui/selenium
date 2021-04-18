package com.hogwrts.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WBufferStrategy;

public class BaseCase {
    public static WebDriver driver ;

   @BeforeAll
    public static void  initData(){
       String browserName=System.getenv("browser");
        if(browserName.equals("chrome")){
            System.out.println(browserName);
            System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
            driver=new ChromeDriver();
        }else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
   }


   @AfterAll
   public static void tearDown(){
       driver.quit();
   }

}
