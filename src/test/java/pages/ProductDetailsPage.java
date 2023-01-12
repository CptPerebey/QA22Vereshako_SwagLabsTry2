package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final static By ITEM_NAME = By.cssSelector(".inventory_details_name.large_size");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_details_desc.large_size");
    private final static By ITEM_PRICE = By.cssSelector(".inventory_details_price");
    private final static By ADD_TO_CART_BUTTON = By.id ("add-to-cart-sauce-labs-backpack");

    @Step
    public static String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }
    @Step
    public static String getItemDesc(){
        return driver.findElement(ITEM_DESCRIPTION).getText();
    }
    @Step
    public static String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }
    public void addToCartButtonLargeSize (){
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }
}
