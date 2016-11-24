package com.ciklum.workshops_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExecuteSearchInGoogle {
    @Test
    public void executeSearchInGoogle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/git_tutorial/training/tskripnik/src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("btnG")).click();

        Thread.sleep(1000);
        int countSearchResults = driver.findElements(By.xpath("//h3/a")).size();
        Assert.assertEquals(countSearchResults, 10);

        driver.close();
    }
}
