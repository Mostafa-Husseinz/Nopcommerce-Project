package shoppingCart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemPage;
import pages.NotebooksPage;

import java.io.FileNotFoundException;

public class ShoppingCartTests extends BaseTests {

    @Test
    public void notificationBarTests() throws FileNotFoundException {
        NotebooksPage notebooksPage =homePage.navigateToNotebookPage();
       ItemPage itemPage = notebooksPage.clickOnProductLink(dataModel().NotebookType);
       itemPage.clickOnAddToCart();

       String expectedNotificationMessage = "The product has been added to your shopping cart";
       String actualNotificationMessage=notebooksPage.getNotificationMessage();
        Assert.assertTrue(notebooksPage.barNotificationsDisplayed());
        Assert.assertTrue(expectedNotificationMessage.contains(actualNotificationMessage));

        String actualCartCount = itemPage.getCartQuantity();
        Assert.assertEquals(actualCartCount,"(1)");
    }
}
