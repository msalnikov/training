package com.ciklum.workshops_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenGoogleInBrowsers {
    @Test
    public void openGoogleInChrome(){
        System.setProperty("webdriver.chrome.driver", "D:/git_tutorial/training/tskripnik/src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.close();
    }

    @Test
    public void openGoogleInFirefox(){
        System.setProperty("webdriver.gecko.driver", "D:/git_tutorial/training/tskripnik/src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://google.com");
        driver.quit();
    }
}