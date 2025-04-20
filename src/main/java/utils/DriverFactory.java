package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Parameters;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static void initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
        public static WebDriver getDriver() {
            return driver.get();
        }

        public static void quitDriver() {
            getDriver().quit();
            driver.remove();
        }
    }

