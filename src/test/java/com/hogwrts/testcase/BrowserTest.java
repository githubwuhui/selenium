package com.hogwrts.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest extends BaseCase{

    @Test
    public void  browserTest(){
        driver.get("https://home.testing-studio.com");
    }

}
