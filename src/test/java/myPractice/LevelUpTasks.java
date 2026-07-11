package myPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

public class LevelUpTasks {
    private WebDriver driver;

    @Test
    public void navigateToGoogole(){
        driver.navigate().to("https://google.com");
        String pageTitle= driver.getTitle();
        System.out.println("Page Title is: "+pageTitle);
        Assert.assertEquals(pageTitle,"Google");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver(getChromeOptions());
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }



    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // Hides the "Chrome is being controlled by automated test software" banner
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--disable-dev-shm-usage");
        options.setAcceptInsecureCerts(true);
// Disables browser extensions to speed up loading
        options.addArguments("--disable-extensions");
// mutes audio so your tests don't make noise during execution
        options.addArguments("--mute-audio");
// Starts Chrome maximized for consistent element positioning
        options.addArguments("--start-maximized");
// Reduces console noise from Chrome internal errors
        options.addArguments("--log-level=3");
        return options;
    }
}
