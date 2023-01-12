package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutInformationPage extends BasePage{
    private final static By FIRST_NAME_INPUT = By.id("first-name");
    private final static By LAST_NAME_INPUT = By.id("last-name");
    private  final static By ZIP_CODE_INPUT = By.id("postal-code");
    private final static By CONTINUE_BUTTON = By.id ("continue");


    public CheckOutInformationPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public void setFirstNameInput (String firstName){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);

    }
    @Step
    public void setLastNameInput (String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
    }
    @Step
    public void setZipCodeInput (String zipCode) {
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
    }
    @Step
    public void clickContinueButton(){
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
