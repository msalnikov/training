package com.ciklum.workshops_tests.AmazonTests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchAndFilterInAmazon {
    public static WebDriver driver;
    int countResults = 0;

    @BeforeTest
    public static void openAmazonInChrome() {
        System.setProperty("webdriver.chrome.driver", "D:/git_tutorial/training/tskripnik/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void searchAndFilterBooks () throws InterruptedException {
        searchWithCategoryFor("Books", "Agile");
        applyFilter(".//ul[1]/li[3]/a/span[1]", 3);
        applyFilter("ref_2944662011", 1);
        applyFilter(".//ul[4]/li[2]/a/span[1]", 3);

        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pagnLA1")));
        int resultPages = driver.findElements(By.className("pagnLink")).size() + 1;

        for (int i = 0; i < resultPages; i++){
            countResultsOnPage();
        }
        Assert.assertEquals(countResults, 23);
        driver.quit();
    }


    public static void searchWithCategoryFor(String category, String searchItem) throws InterruptedException {
        Select dropdown = new Select (driver.findElement(By.id("searchDropdownBox")));
        dropdown.selectByVisibleText(category);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);
        driver.findElement(By.xpath(".//div[2]/div/input")).click();
    }

    public void applyFilter (String locator, int locatorType){
        WebDriverWait waitLoaded = new WebDriverWait(driver, 3000);
        switch (locatorType){
            case 1: waitLoaded.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    driver.findElement(By.id(locator)).click();
                    break;
            case 2: waitLoaded.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
                    driver.findElement(By.className(locator)).click();
                    break;
            case 3: waitLoaded.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    driver.findElement(By.xpath(locator)).click();
                    break;
        }
    }

    public void scrollToGetElementVisible(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    public void countResultsOnPage () throws InterruptedException {
        countResults += driver.findElements(By.className("s-item-container")).size();
        if (driver.findElements(By.xpath(".//li[12]/div")).size() != 0) {
            scrollToGetElementVisible(driver.findElement(By.xpath(".//li[12]/div")));
            driver.findElement(By.id("pagnNextString")).click();
            Thread.sleep(2000);
        }
    }
}