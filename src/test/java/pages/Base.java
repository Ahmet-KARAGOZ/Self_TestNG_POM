package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Base {
    public Base(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

}
