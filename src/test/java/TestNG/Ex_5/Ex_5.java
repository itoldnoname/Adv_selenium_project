package TestNG.Ex_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_5 {

    /* threadPoolSize will execute the particular testcase in parallel */

    @Test (invocationCount = 3 , threadPoolSize = 2)    //execute 3 times but 2 times parallely
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://twitter.com/");
    }
}
