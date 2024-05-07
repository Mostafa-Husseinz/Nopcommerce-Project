package login;

//import base.BaseTests;
import base.BaseTests;
import data.DataModel;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests extends BaseTests {


    @Test
    public void successfullyLogin() throws FileNotFoundException {

     LoginPage loginPage = homePage.clickOnLoginLink();
     loginPage.loginFeature(dataModel().Login.ValidCredentials.email,
             dataModel().Login.ValidCredentials.password);
    }
}
