package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(groups = {"Smoke"}, description = "Тест регистрации на сайте",retryAnalyzer = RetryAnalyzer.class)
    public void positiveLoginTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }

@DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"qwe", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test(groups = {"Smoke"}, description = "Тест регистрации на сайте", dataProvider = "negativeLoginTestData")
    public void negativeLoginTest(String userName, String password, String errorMessage) {
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage);
    }

}