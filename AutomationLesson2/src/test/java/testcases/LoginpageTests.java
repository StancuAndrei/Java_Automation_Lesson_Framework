package testcases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.Loginpage;
import utility.DataProviders;

public class LoginpageTests extends Base {

    Loginpage loginpage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        launchApp();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void check_login_button(){
        loginpage = new Loginpage();
        boolean check_result = loginpage.click_login_button();
        Assert.assertTrue(check_result);
    }


    @Test( dataProvider = "excelData", dataProviderClass = DataProviders.class , groups = "Smoke")
    public void check_login(String username, String password){
        loginpage = new Loginpage();
        boolean check_result = loginpage.validate_login(username, password);
        Assert.assertTrue(check_result);
    }


}
