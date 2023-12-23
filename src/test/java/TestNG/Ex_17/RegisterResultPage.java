package TestNG.Ex_17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterResultPage {

    RegisterResultPage(WebDriver driver){
        PageFactory.initElements(driver , this);
    }

    @FindBy (css = "[class='header-links'] [class='account']")
    private WebElement userName;

    @FindBy (css = "[value='Continue']")
    private WebElement continueBtn;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }
}
