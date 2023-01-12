package tests;

import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {
    @Attachment
    @Test(groups = {"Smoke"}, description = "Тест на добавление товара в корзину",retryAnalyzer = RetryAnalyzer.class)
    public void positiveShoppingCartTest() {

        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();

        Assert.assertEquals(shoppingCartPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(shoppingCartPage.getItemDescription(testItemName), expectedItemDescription);

    }
}
