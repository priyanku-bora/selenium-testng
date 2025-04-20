package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email1']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password1']")
    WebElement passwordInput;

    @FindBy(css = ".submit-btn")
    WebElement signInButton;

    @FindBy(xpath = "//h2[@class='header']")
    public WebElement signInHeader;

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
        Assert.assertTrue(signInHeader.isDisplayed());
    }
}
