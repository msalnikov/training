package com.ciklum.workshops_tests.AmazonTests.AmazonPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasicPage{
    private WebDriverWait waitLoaded = new WebDriverWait(driver, 3000);

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void selectCountryOfUse (){
        waitLoaded.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ods-cp-select.a-declarative")));
        Select dropdown = new Select (driver.findElement(By.cssSelector(".ods-cp-select.a-declarative")));
        dropdown.selectByValue("UA");
    }

    public void addProductToCart (){
        waitLoaded.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".a-button.a-spacing-small.a-button-primary.a-button-icon")));
        driver.findElement(By.cssSelector(".a-button.a-spacing-small.a-button-primary.a-button-icon")).click();
    }
}
