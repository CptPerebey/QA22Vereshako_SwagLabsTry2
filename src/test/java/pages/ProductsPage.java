package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    private final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By ITEM_PRICE_TEXT = By.cssSelector(".inventory_item_price");
    private final static By ITEM_DESRRIPTION_DESC = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_NAME_LINK = By.cssSelector(".inventory_item_name");
    private  final static By BURGER_MENU_BUTTON = By.cssSelector("#react-burger-menu-btn");
    private  final static By LOGOUT_BUTTON = By.cssSelector("#logout_sidebar_link");
    private final static By DROPDOWN_BUTTON = By.cssSelector(".product_sort_container");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartButtonPresent() {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public void clickShoppingCartButton() {

        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    public void clickAddToCartButton(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE_TEXT).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESRRIPTION_DESC).getText();
    }

    public void openItem(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_NAME_LINK).click();
    }

    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }
    public void clickBurgerMenuButton() {
        driver.findElement(BURGER_MENU_BUTTON).click();
    }
    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
    public void clickDropdownButton (){
        driver.findElement(DROPDOWN_BUTTON).click();
    }


    public List<String> getSortingListItemName (){
        List<WebElement> listItemName = driver.findElements(ITEM_NAME_LINK);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).collect(Collectors.toList());
        return allListItemName;
    }
    public void selectSortingOrderOption (String optionName) {
        Select select = new Select(driver.findElement(DROPDOWN_BUTTON));
        select.selectByVisibleText(optionName);
    }

}

