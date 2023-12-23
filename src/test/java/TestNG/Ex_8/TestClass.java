package TestNG.Ex_8;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{

    //Execute this one only.. Don't execute the BaseClass
    //BaseClass will execute automatically
    //Flow of execution:- @BeforeSuite > @BeforeTest > @BeforeClass > @BeforeMethod
    //                      > @Test
    //                      > @AfterMethod > @AfterClass > @AfterTest > @AfterSuite

    @Test
    public void printTheUserName(){
        String userName = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']")).getText();
        Reporter.log("UserName is --> " + userName , true);
    }
}
