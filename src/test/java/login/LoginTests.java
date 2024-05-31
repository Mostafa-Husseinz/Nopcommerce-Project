package login;

//import base.BaseTests;
import base.BaseTests;
import data.DataModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utils.UtilsTests.myAssertEquals;
import static utils.UtilsTests.myAssertTrue;

public class LoginTests extends BaseTests {


     public static String expectedResult ;
     public static String actualResult ;

    @Test
    public void successfullyLogin() throws FileNotFoundException {

     LoginPage loginPage = homePage.clickOnLoginLink();
     loginPage.loginFeature(dataModel().Login.ValidCredentials.email,
             dataModel().Login.ValidCredentials.password);
      expectedResult = dataModel().ValidationMessage;
      actualResult = loginPage.getValidationMessage();
        myAssertTrue(actualResult.contains(expectedResult));

    }
    @Test
    public void t2() throws FileNotFoundException {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredentials.email,
                dataModel().Login.ValidCredentials.password);
        myAssertEquals("hello","hello");
    }
    @Test
    public void t3() throws FileNotFoundException {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredentials.email,
                dataModel().Login.ValidCredentials.password);
    }
}
