package com.hogwrts.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InteractiveTest {

    public static WebDriver driver;
    public static Actions actions;

    @BeforeAll
    public  static void initData(){
        driver =new ChromeDriver();
//        driver =new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        actions = new Actions(driver);

    }

    @Test
    public  void clickTest(){
        try {
        driver.get("http://sahitest.com/demo/clicks.htm");

        actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
        actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
        actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));
        actions.perform();

        Thread.sleep(3000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    @Test
    public void moveTest(){
        try {
            driver.get("http://www.baidu.com");
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void dragTest(){
        try {
            driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("/html/body/div[5]"))).perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void keyBoardTest(){
        try {
            driver.get("http://sahitest.com/demo/label.htm");
            driver.findElements(By.xpath("/html/body/label[1]/input")).get(0).sendKeys("wuhui");
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
//            driver.findElements(By.xpath("/html/body/label[1]/input")).get(1).keys;
            actions.keyDown(driver.findElements(By.xpath("/html/body/label[2]/table/tbody/tr/td[2]/input")).get(0),Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void scrollTest(){
        try {
            driver.get("https://www.baidu.com");
            driver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");

            TouchActions touchActions=new TouchActions(driver);
            touchActions.click(driver.findElement(By.id("su")));

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//a[@class='n']")).click();

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void switchTest() throws Exception{
        driver.get("https://www.baidu.com");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"s-top-loginbtn\"]")).click();

//        获取百度首页的窗口
        String baiduwin = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@id=\"passport-login-pop-dialog\"]/div/div/div/div[3]/a")).click();


        Thread.sleep(3000);
        for(String win: driver.getWindowHandles()){
            if (!win.equals(baiduwin)){
                driver.switchTo().window(win);
                driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_4__userName\"]")).sendKeys("testhogwarts");
                driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_4__phone\"]")).sendKeys("18758080064");

//                driver.switchTo().window(baiduwin);

                driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();

                driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("18758080064");
                driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("18758080064");
                Thread.sleep(3000);
            }
        }
    }


    @Test
    public void frameTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");

        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"droppable\"]")).getText());

        driver.switchTo().parentFrame();

        System.out.println(driver.findElement(By.id("submitBTN")).getText());
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }


}
