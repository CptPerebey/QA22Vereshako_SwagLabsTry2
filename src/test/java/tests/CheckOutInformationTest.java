package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutInformationTest extends BaseTest {
    @Test(groups = {"Smoke"},
            description = "Тест на добавление товара и переход на следующую страницу",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkOutSendKeys(){
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();

        shoppingCartPage.clickCheckOutButton();

        checkOutInformationPage.setFirstNameInput("Alexandr");
        checkOutInformationPage.setLastNameInput("Vereshako");
        checkOutInformationPage.setZipCodeInput("11111");
        checkOutInformationPage.clickContinueButton();

        Assert.assertTrue(checkoutOverview.isFinishButtonPresent());



    }
}
