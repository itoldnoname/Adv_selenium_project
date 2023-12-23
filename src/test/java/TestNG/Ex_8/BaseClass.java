package TestNG.Ex_8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v119.indexeddb.model.Key;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {

    WebDriver driver;

    @BeforeSuite
    public void connectServer(){
        Reporter.log("Connected to Server.." , true);
    }
    @BeforeTest
    public void connectDatabase(){
        Reporter.log("Connected to Database.." , true);
    }
    @BeforeClass
    public void openBrowser(){
        Reporter.log("Open Browser.." , true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
    }
    @BeforeMethod
    public void logIn(){
        Reporter.log("Doing Login.." , true);
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("abcd@ef.gh" , Keys.TAB , "123456");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }
    @AfterMethod
    public void logOut(){
        Reporter.log("Doing Logout.." , true);
        driver.findElement(By.className("ico-logout")).click();
    }
    @AfterClass
    public void closeBrowser(){
        Reporter.log("Close Browser.." , true);
        driver.quit();
    }
    @AfterTest
    public void disconnectDatabase(){
        Reporter.log("Database Disconnected.." , true);
    }
    @AfterSuite
    public void disconnectServer(){
        Reporter.log("Server Disconnected.." , true);
    }

}
