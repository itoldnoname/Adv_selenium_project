package TestNG.Ex_7.Car;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testCase7 {

    @Test
    public void tesla(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tesla.com/");
    }
}
