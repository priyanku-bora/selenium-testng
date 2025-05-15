package tests;

import dataproviders.TestDataProvider;
import listeners.RetryAnalyzer;
import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.DriverFactory;

@Listeners(TestListeners.class)
public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginTestData",dataProviderClass = TestDataProvider.class)
    public void testValidLogin(String username,String password){
        DriverFactory.getDriver().get("https://freelance-learn-automation.vercel.app/login");
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(username,password);
    }

    @Test(dataProvider = "loginData",dataProviderClass = TestDataProvider.class)
    public void testExcelLogin(String username,String password){
        DriverFactory.getDriver().get("https://freelance-learn-automation.vercel.app/login");
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(username,password);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testInvalidLogin(){
        DriverFactory.getDriver().get("https://freelance-learn-automation.vercel.app/login");
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login("admin@email.com","invalidPassword");
        Assert.assertTrue(false);
    }
}
