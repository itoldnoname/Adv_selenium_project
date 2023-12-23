package TestNG.Ex_7.Car;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testCase6 {

    @Test
    public void lamborghini(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lamborghini.com/en-en");
    }
}
