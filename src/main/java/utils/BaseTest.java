package utils;

import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome")String browser) {
        DriverFactory.initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }



}
