package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ItemPage extends MethodHandles {
    public ItemPage(WebDriver driver) {
        super(driver);
    }
    private final By addToCart = By.cssSelector("#add-to-cart-button-9");

   private final By cartQuantity = By.xpath("//span[@class='cart-qty']");
    public void clickOnAddToCart(){
        click(addToCart,5);
    }

    public String getCartQuantity(){
        return driver.findElement(cartQuantity).getText();
    }
}
