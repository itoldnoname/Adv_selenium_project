package TestNG.Ex_17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    HomePage(WebDriver driver){
        PageFactory.initElements(driver , this);
    }

    @FindBy (css = "[class='ico-logout']")
    private WebElement logout;

    public WebElement getLogout() {
        return logout;
    }
}
