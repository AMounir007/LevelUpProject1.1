package myPractice;

import myPractice.templates.TesCases;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LevelUpTasks extends TesCases {

    @Test
    public void navigateToGoogoleAndAssertPageTitleTask1(){
        driver.navigate().to("https://google.com");
        String pageTitle= driver.getTitle();
        System.out.println("Page Title is: "+pageTitle);
        Assert.assertEquals(pageTitle,"Google");
    }
    @Test
    public void navigateToDuckDuckGoAndAssertLogoIsDisplayedTask2(){
        driver.navigate().to("https://duckduckgo.com");
        Assert.assertTrue
                (driver.findElement(By.xpath("(//a[@title='Learn about DuckDuckGo']//img)[2]"))
                        .isDisplayed(), "DuckDuckGo Logo is not displayed");
    }
    @Test
    public void navigateToDuckDuckGoAndAssertTheFirstLinkResultTask3(){
       driver.navigate().to("https://duckduckgo.com");
       By searchText=By.id("searchbox_input");
       driver.findElement(searchText).sendKeys("Selenium WebDriver", Keys.ENTER);
       String expectedUrl = "https://www.selenium.dev/documentation/webdriver/";
       Assert.assertTrue(
               driver.findElement(By.xpath("(//a[@data-testid=\"result-extras-url-link\"])[1]"))
                       .getAttribute("href")
                       .equals(expectedUrl), "The first link result is not correct");
    }


}
