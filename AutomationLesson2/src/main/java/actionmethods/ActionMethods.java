package actionmethods;

import actioninterface.ActionInterface;
import org.openqa.selenium.WebElement;

public class ActionMethods implements ActionInterface {
    @Override
    public boolean type(WebElement element, String text) {
        boolean flag = false;
        try{
            element.clear();
            element.sendKeys(text);
            flag=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally{
            if(flag){
                System.out.println("Successfully entered value");
            }else{
                System.out.println("Unable to enter value");
            }
        }

        return flag;
    }
}
