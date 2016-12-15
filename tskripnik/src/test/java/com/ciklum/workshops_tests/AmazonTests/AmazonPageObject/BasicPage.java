package com.ciklum.workshops_tests.AmazonTests.AmazonPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {
    public WebDriver driver;

    public BasicPage(WebDriver driver){
        this.driver = driver;
    }

    public BasicPage open(){
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        return this;
    }

    public void basicSearch(String criteria){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(criteria);
        driver.findElement(By.xpath(".//div[2]/div/input")).click();
    }

    public void openShoppingCart() {
        WebDriverWait waitLoaded = new WebDriverWait(driver, 3000);
        waitLoaded.until(ExpectedConditions.elementToBeClickable(By.id("nav-cart")));
        driver.findElement(By.id("nav-cart")).click();
    }
}
