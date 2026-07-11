package myPractice.templates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Collections;

public class TesScenario {
    public WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        driver = new ChromeDriver(getChromeOptions());
    }
    @AfterClass
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
