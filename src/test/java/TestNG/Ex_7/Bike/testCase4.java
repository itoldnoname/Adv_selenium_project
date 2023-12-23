package TestNG.Ex_7.Bike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testCase4 {

    @Test
    public void hero(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.heromotocorp.com/en-in.html");
    }
}
