package TestNG.Ex_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_3 {

    /* Topic:- run testcases in loop (invocationCount) */

    int test1Count;
    int test2Count;
    int test3Count;

    @Test (invocationCount = 3)     //it will run 3 times
    public void test1(){
        ++test1Count;   //counting the execution time
    }

    @Test   //invocationCount is not given so it will run 1 time
    public void test2(){
        ++test2Count;   //counting the execution time
    }

    @Test (priority = 1 , invocationCount = 4)
    public void test3(){
        ++test3Count;   //counting the execution time
    }

    @Test (priority = 2)
    public void test4(){
        Reporter.log("============================" ,true);
        Reporter.log("Test1 is executed " + test1Count + " times.." , true);
        Reporter.log("Test2 is executed " + test2Count + " times.." , true);
        Reporter.log("Test3 is executed " + test3Count + " times.." , true);
        Reporter.log("============================" ,true);
    }

}
