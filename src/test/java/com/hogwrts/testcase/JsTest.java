package com.hogwrts.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsTest {
    public static WebDriver driver;

    @BeforeAll
    public static void  beforeAll(){
        driver = new ChromeDriver();

    }

    @Test
    public void jsTest(){
        try {
            driver.get("https://www.12306.cn/index/");
            Thread.sleep(2000);

            JavascriptExecutor jsDriver= (JavascriptExecutor) driver;
            jsDriver.executeScript("document.getElementById('train_date').value='2020-12-30'");
            Thread.sleep(2000);

            Object date=jsDriver.executeScript("return document.getElementById('train_date').value");
            System.out.println(date);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @AfterAll
    public static  void afterAll(){
        driver.quit();
    }



}
