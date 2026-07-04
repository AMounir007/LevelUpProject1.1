package coursePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

@Test
public class FirstClassTest {

    WebDriver driver = null;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(getOptimizedChromeOptions());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        // String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Test
    public void secondTest() {
        driver.get("https://www.youtube.com/");
    }

    private ChromeOptions getOptimizedChromeOptions() {
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
