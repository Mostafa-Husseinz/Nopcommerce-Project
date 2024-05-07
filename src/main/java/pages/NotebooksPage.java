package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class NotebooksPage extends MethodHandles {
    public NotebooksPage(WebDriver driver) {
        super(driver);
    }
    private  By productLink(String text) {
      return By.xpath("//a[contains(text(),'"+text+"')]");
    }
    public ItemPage clickOnProductLink(String text){
        click(productLink(text),5);
        return new  ItemPage(driver);
    }

}
