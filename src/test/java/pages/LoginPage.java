package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends  BasePage{
    private final static By usernameInput = By.cssSelector("#user-name");
    private final static By passwordInput = By.cssSelector("#password");
    private final static By logInButton = By.cssSelector("#login-button");
    private final static By errorMessageContainer = By.cssSelector(".error-message-container");


    public LoginPage(WebDriver driver) {
        super(driver);

    }
    public void clickLoginButton() {

        driver.findElement(logInButton).click();
    }

    public void setUsername (String username) {

        driver.findElement(usernameInput).sendKeys(username);
    }

    public void setPassword (String password) {

        driver.findElement(passwordInput).sendKeys(password);
    }

    public String getErrorMessageText () {

        return driver.findElement(errorMessageContainer).getText();
    }
    public Boolean isLoginButtonPresent() {
        try {
            driver.findElement(logInButton);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}
