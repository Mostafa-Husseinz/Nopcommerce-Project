package login;

//import base.BaseTests;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

public class LoginTests2 extends BaseTests {


    @Test
    public void successfullyLogin() throws FileNotFoundException {

     LoginPage loginPage = homePage.clickOnLoginLink();
     loginPage.loginFeature(dataModel().Login.ValidCredentials.email,
             dataModel().Login.ValidCredentials.password);
    }
    @Test
    public void t2() throws FileNotFoundException {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredentials.email,
                dataModel().Login.ValidCredentials.password);
    }
    @Test
    public void t3() throws FileNotFoundException {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredentials.email,
                dataModel().Login.ValidCredentials.password);
    }
}
