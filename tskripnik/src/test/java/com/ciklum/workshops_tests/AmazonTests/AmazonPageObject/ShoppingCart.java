package com.ciklum.workshops_tests.AmazonTests.AmazonPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart extends BasicPage {
    private WebDriverWait waitLoaded = new WebDriverWait(driver, 3000);

    public ShoppingCart (WebDriver driver){
        super(driver);
    }

    public String getCartSubtotal(){
        waitLoaded.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".a-size-medium.a-color-price.sc-price.sc-white-space-nowrap.sc-price-sign")));
        WebElement subtotal = driver.findElement(By.cssSelector(".a-size-medium.a-color-price.sc-price.sc-white-space-nowrap.sc-price-sign"));
        return subtotal.getText();
    }
}
