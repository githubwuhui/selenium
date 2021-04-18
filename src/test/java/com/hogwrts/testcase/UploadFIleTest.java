package com.hogwrts.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFIleTest {

    public static WebDriver driver;

    @BeforeAll
    public static void  beforeAll(){
        driver = new ChromeDriver();

    }

    @Test
    public void uploadFileTest(){
        try {
            driver.get("https://www.baidu.com");
            driver.findElement(By.xpath("//*[@id=\"form\"]/span[1]/span[1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/div[2]/input")).sendKeys("C:\\Users\\wuhui\\Pictures\\微信图片_20210418164125.png");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterAll
    public static  void afterAll(){
        driver.quit();
    }


}
