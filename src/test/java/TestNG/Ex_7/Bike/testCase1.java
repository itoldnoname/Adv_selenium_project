package TestNG.Ex_7.Bike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testCase1 {

    @Test
    public void yamaha(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yamaha-motor-india.com/");
    }
}
