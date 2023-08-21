package pageobjects;

import actionmethods.ActionMethods;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Base {

    ActionMethods actionMethods;

    @FindBy(id = "user-name")
    WebElement username_input_box;

    @FindBy(id = "password")
    WebElement pasasword_input_box;

    @FindBy(id = "login-button")
    WebElement login_button;

    public Loginpage(){
        PageFactory.initElements(driver, this);
    }

    public boolean click_login_button(){
        boolean flag=false;
        try{
            login_button.click();
            flag=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public boolean validate_login(String username, String password){
        boolean flag = false;
        actionMethods = new ActionMethods();
        try{

            actionMethods.type(username_input_box, username);
            actionMethods.type(pasasword_input_box, password);

            Thread.sleep(2000);
            login_button.click();
            flag=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public Homepage go_to_homepage(){
        try{
            username_input_box.sendKeys("standard_user");
            pasasword_input_box.sendKeys("secret_sauce");

            Thread.sleep(2000);
            login_button.click();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new Homepage();
    }





}
