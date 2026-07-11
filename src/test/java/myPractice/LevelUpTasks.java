package myPractice;

import myPractice.templates.TesCases;
import org.openqa.selenium.By;
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
    public void navigateToDuckDuckGoAndAssertPageTitleTask2(){
        driver.navigate().to("https://duckduckgo.com");
        Assert.assertTrue
                (driver.findElement(By.xpath("(//a[@title='Learn about DuckDuckGo']//img)[2]"))
                        .isDisplayed(), "DuckDuckGo Logo is not displayed");
    }


}
