package com.hogwrts.testcase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UploadTest {
    @Test
    public void uploadTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.className(""));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
    }

}
