package com.ciklum.workshops_tests.AmazonTests.AmazonPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasicPage{
    private WebDriverWait waitLoaded = new WebDriverWait(driver, 3000);

    public SearchPage(WebDriver driver){
        super(driver);
    }

    public void filterByInternationalShipping(){
        waitLoaded.until(ExpectedConditions.visibilityOfElementLocated(By.id("ref_2944662011")));
        driver.findElement(By.id("ref_2944662011")).click();
    }

    public void openFirstResult(){
        waitLoaded.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".a-size-medium.a-color-null.s-inline.s-access-title.a-text-normal")));
        driver.findElement(By.cssSelector(".a-size-medium.a-color-null.s-inline.s-access-title.a-text-normal")).click();
    }
}
