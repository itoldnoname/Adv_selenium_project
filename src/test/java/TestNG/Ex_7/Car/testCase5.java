package TestNG.Ex_7.Car;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class testCase5 {

    @Test
    public void ferrari(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ferrari.com/en-IN");
    }
}
