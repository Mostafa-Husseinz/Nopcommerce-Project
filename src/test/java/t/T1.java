package t;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class T1 extends BaseTests {

    @DataProvider
    public Object[][] testDate() throws FileNotFoundException {
        return dataModel().Login1;

    }

    @Test (dataProvider = "testDate")
    public void tes1(String username , String password)  {
        System.out.println(username);
        System.out.println(password);
    }
}
