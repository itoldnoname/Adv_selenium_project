package TestNG.Ex_7.Bike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testCase3 {

    @Test
    public void honda(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.honda2wheelersindia.com/");
    }
}
