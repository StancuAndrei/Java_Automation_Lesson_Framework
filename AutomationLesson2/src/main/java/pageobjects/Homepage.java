package pageobjects;


import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage extends Base {

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement drop_down_box;

    public Homepage(){
        PageFactory.initElements(driver, this);
    }


    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public boolean select_value_from_drop_downbox(int index){
        boolean flag = false;
        Select drop_box = new Select(drop_down_box);
        try{
            drop_box.selectByIndex(index);
            Thread.sleep(2000);
            flag=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }



}
