package TestNG.Ex_17;

import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MainTask extends Base{

    @Test (priority = 1)
    public void registerUser() throws IOException {

        //WELCOME PAGE --> REGISTER PAGE
        //To make use of RegisterPage we have to create an object for that class as its non-static
        WelcomePage wp = new WelcomePage(driver);
        //though get() access the element and click on the link
        wp.getRegisterLink().click();

        //To get the data from properties file
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\AdvancedSelenium\\src\\test\\java\\TestNG\\Ex_17\\data.properties");
        Properties p = new Properties();
        p.load(fis);
        String firstName = p.getProperty("FirstName");
        String lastName = p.getProperty("LastName");
        String email = p.getProperty("Email");
        String password = p.getProperty("Password");
        String confirmPassword = p.getProperty("ConfirmPassword");

        //REGISTER PAGE
        RegisterPage rp = new RegisterPage(driver);
        rp.getMaleRadioBtn().click();
        rp.getFemaleRadioBtn().click();
        rp.getFirstName().sendKeys(firstName);
        rp.getLastName().sendKeys(lastName);
        rp.getEmail().sendKeys(email);
        rp.getPassword().sendKeys(password);
        rp.getConfirmPassword().sendKeys(confirmPassword);
        rp.getRegisterBtn().click();

        //REGISTER-RESULT PAGE
        RegisterResultPage rr = new RegisterResultPage(driver);
        String loggedInEmail = rr.getUserName().getText();
        Reporter.log("Logged into --> " + loggedInEmail , true);
        rr.getContinueBtn().click();

        //Logout
        HomePage hp = new HomePage(driver);
        hp.getLogout().click();
        Reporter.log("Logout Succeessful" , true);
    }

}
