package TestNG.Ex_4;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ex_4 {

    /* Testcase should run or not (Enabled) */

    @Test (enabled = false)     // it will not execute this testcase
    public void test1(){
        Reporter.log("Testcase 1 is executing..", true);
    }

    @Test   //by default 'enabled = true' so it will execute this testcase
    public void test2(){
        Reporter.log("Testcase 2 is executing.." , true);
    }
}
