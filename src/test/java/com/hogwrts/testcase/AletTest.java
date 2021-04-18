package com.hogwrts.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AletTest {
    public static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        driver=new ChromeDriver();

    }

    @Test
    public void alertTest(){
        try {
            driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
            Thread.sleep(1000);
            driver.switchTo().frame("iframeResult");
            Actions actions =new Actions(driver);
            actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).perform();
            Thread.sleep(1000);
            driver.switchTo().alert().accept();
            Thread.sleep(1000);
            driver.switchTo().parentFrame();
            driver.findElement(By.id("submitBTN")).click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
}
