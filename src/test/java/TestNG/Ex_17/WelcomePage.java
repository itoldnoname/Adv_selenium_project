package TestNG.Ex_17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    WelcomePage(WebDriver driver){     //4a- to initialize create constructor and pass the driver
        //4b- pass the driver and the current element ie. this
        PageFactory.initElements(driver , this);
    }

    @FindBy(linkText = "Register")      //1- get the element location
    private WebElement registerLink;    //2- declare a variable and make it private

    public WebElement getRegisterLink() {
        return registerLink;            //3- to access it use the getter method
    }
}
