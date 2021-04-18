package com.hogwrts.testcase;

public class MyTest {
    public static void main(String[] args) {

//        System.out.println(System.getenv("browser"));
//        if("chrome".equals("chrome")){
//            System.out.println("true");
//        }else{
//            System.out.println("false");
//        }
        System.out.println(System.getProperty("webdriver.chrome.driver"));
    }
}
