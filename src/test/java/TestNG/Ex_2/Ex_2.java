package TestNG.Ex_2;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ex_2 {

    /* Topic :- priority */

    @Test                  //Not giving any pririty means its TestNG.priority = 0
    public void test1(){
        Reporter.log("Test-1 is running.." , true);
    }

    @Test (priority = 2)  //TestNG.priority is 2
    public void test2(){
        Reporter.log("Test-2 is running.." , true);
    }

    @Test (priority = 1)  //TestNG.priority is 1
    public void test3(){
        Reporter.log("Test-3 is running..", true);
    }

}
