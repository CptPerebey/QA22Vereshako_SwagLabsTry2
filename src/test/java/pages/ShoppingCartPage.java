package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    private final static By CHECKOUT_BUTTON = By.id("checkout");
    private final static By CONTINUE_SHOPPING_BUTTON = By.cssSelector("#continue-shopping");
    private final static By ITEM_PRICE_TEXT = By.cssSelector(".inventory_item_price");
    private final static By ITEM_DESRRIPTION_DESC = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_NAME_TEXT = By.cssSelector(".inventory_item_name");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    public  void  clickCheckOutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public static String getItemPrice(String testItemName) {
        return driver.findElement(ITEM_PRICE_TEXT).getText();
    }

    public static String getItemDescription(String testItemName) {
        return driver.findElement(ITEM_DESRRIPTION_DESC).getText();
    }

    public String getItemName() {
        return driver.findElement(ITEM_NAME_TEXT).getText();
    }
}
