package com.ciklum.workshops_tests.AmazonTests;

import com.ciklum.workshops_tests.AmazonTests.AmazonPageObject.BasicPage;
import com.ciklum.workshops_tests.AmazonTests.AmazonPageObject.ProductPage;
import com.ciklum.workshops_tests.AmazonTests.AmazonPageObject.SearchPage;
import com.ciklum.workshops_tests.AmazonTests.AmazonPageObject.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchAndPutIntoShoppingCart {
    public static WebDriver driver;
    public static BasicPage basicPage;
    public static SearchPage searchPage;
    public static ProductPage productPage;
    public static ShoppingCart shoppingCart;

    @BeforeTest
    public static void openAmazonInChrome() {
        System.setProperty("webdriver.chrome.driver", "D:/git_tutorial/training/tskripnik/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        basicPage = new BasicPage(driver);
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        shoppingCart = new ShoppingCart(driver);
    }

    @Test
    public void SearchAndPutIntoShoppingCart() throws InterruptedException {
        basicPage.open();
        basicPage.basicSearch("kindle paperwhite");

        searchPage.filterByInternationalShipping();
        searchPage.openFirstResult();

        productPage.selectCountryOfUse();
        productPage.addProductToCart();

        basicPage.openShoppingCart();
        Assert.assertEquals(shoppingCart.getCartSubtotal(), "$119.99");
    }

    @AfterClass
    public static void closeChrome() {
        driver.quit();
    }
}
