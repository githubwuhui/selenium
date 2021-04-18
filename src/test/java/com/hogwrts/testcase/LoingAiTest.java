package com.hogwrts.testcase;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.Element;
import java.util.concurrent.TimeUnit;

public class LoingAiTest {
    public  static  WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
//        隐式等待
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        显示等待
        wait= new WebDriverWait(driver,5);
    }

    @Test
    public void login(){
        driver.get("https://home.testing-studio.com");


        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("details-button")));

        ele.click();

        WebElement qianwang = wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-link")));

        qianwang.click();



        driver.findElement(By.xpath("//*[@id=\"ember5\"]/header/div/div/div[2]/span/button[2]/span")).click();

        driver.findElement(By.id("login-account-name")).clear();
        driver.findElement(By.id("login-account-name")).sendKeys("931294084@qq.com");

        driver.findElement(By.id("login-account-password")).clear();
        driver.findElement(By.id("login-account-password")).sendKeys("lzywuhui147258");

        driver.findElement(By.id("login-button")).click();


    }

    @Test
    public void threadSleepTest(){
        driver.get("https://home.testing-studio.com");
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("details-button")));

        ele.click();

        WebElement qianwang = wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-link")));

        qianwang.click();

        try {
//            直接等待
            Thread.sleep(100);
            driver.findElement(By.xpath("//*[@id=\"ember5\"]/header/div/div/div[2]/span/button[2]/span")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void waitTest(){
        driver.get("https://home.testing-studio.com");

        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("details-button")));
        ele.click();

        WebElement qianwang = wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-link")));

        qianwang.click();

//      第一种方法：显示等待第一种方式，如果内部要做一些操作可以采用该方法
//        WebElement denglu = wait.until(new ExpectedCondition<WebElement>() {
//            @NullableDecl
//            @Override
//            public WebElement apply(@NullableDecl WebDriver driver) {
//                return driver.findElement(By.xpath("//*[@id=\"ember5\"]/header/div/div/div[2]/span/button[2]/span"));
//            }
//        });
//
//        denglu.click();

//      第二种方法：显示等待第二种方法，如果不需要做额外的操作可以采用该方法
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ember5\"]/header/div/div/div[2]/span/button[2]/span"))).click();

    }


    @AfterAll
    public static void after(){
//        driver.close();
    }
}
