package testcases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Homepage;
import pageobjects.Loginpage;


public class HomepageTests extends Base {

    Loginpage loginpage;
    Homepage homepage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        launchApp();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test(groups = "Smoke")
    public void check_homepage_url(){
        loginpage = new Loginpage();
        homepage = loginpage.go_to_homepage();
        String actualURL = homepage.getCurrentURL();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void check_drop_down_box(){
        loginpage = new Loginpage();
        homepage = loginpage.go_to_homepage();
        boolean check_result = homepage.select_value_from_drop_downbox(3);
        Assert.assertTrue(check_result);
    }


}
