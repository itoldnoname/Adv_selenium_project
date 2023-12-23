package TestNG.Ex_7.Bike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testCase2 {

    @Test
    public void tvs(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tvsmotor.com/");
    }
}
