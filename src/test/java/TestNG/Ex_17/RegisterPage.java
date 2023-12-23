package TestNG.Ex_17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    RegisterPage(WebDriver driver){
        PageFactory.initElements(driver , this);
    }

    @FindBy (id = "gender-male")
    private WebElement maleRadioBtn;

    @FindBy (id = "gender-female")
    private WebElement femaleRadioBtn;

    @FindBy (id = "FirstName")
    private WebElement firstName;

    @FindBy (id = "LastName")
    private WebElement lastName;

    @FindBy (id = "Email")
    private WebElement email;

    @FindBy (id = "Password")
    private WebElement password;

    @FindBy (id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy (id = "register-button")
    private WebElement registerBtn;

    public WebElement getMaleRadioBtn() {
        return maleRadioBtn;
    }

    public WebElement getFemaleRadioBtn() {
        return femaleRadioBtn;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }
}
