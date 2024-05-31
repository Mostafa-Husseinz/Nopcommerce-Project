package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By loginButton = By.cssSelector(".button-1.login-button");
    private final By validationMessage = By.xpath("//div[@class='message-error validation-summary-errors']");

    private void insertEmail(String email){
        sendKeys(emailField,5,email);
    }
    private void insertPassword(String password){
        sendKeys(passwordField,5,password);
    }
    private void clickOnLoginButton(){
        click(loginButton,5);
    }

    public String getValidationMessage(){
        return driver.findElement(validationMessage).getText();
    }

    public void loginFeature(String email , String password){
              insertEmail(email);
              insertPassword(password);
              clickOnLoginButton();
    }
}
