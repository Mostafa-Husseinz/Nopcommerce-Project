package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By loginLink = By.cssSelector(".ico-login");
    private final By computersLink = By.xpath("(//a[contains(text(),'Computers ')])[1] ");
    private final By noteBookLink =By.xpath("(//a[contains(text(),'Notebooks ')])[1] ");

    public LoginPage clickOnLoginLink(){
        click(loginLink,5);
        return new LoginPage(driver);
    }
    private void hoverOnComputers(){
        hoverOverElement(computersLink,5);
    }
    private void clickOnNotebooks(){
        click(noteBookLink,5);
    }

    public NotebooksPage navigateToNotebookPage(){
        hoverOnComputers();
        clickOnNotebooks();
        return new NotebooksPage(driver);
    }
}
