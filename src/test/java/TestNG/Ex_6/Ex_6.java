package TestNG.Ex_6;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ex_6 {

    /* dependsOnMethod will make one method dependent on another method
       that means if that particular method is not executing..
       then the dependent method also will not execute */

    @Test (dependsOnMethods = "test2")
    public void test1(){
        Reporter.log("Test1 is executing.." , true);
    }

    @Test
    public void test2(){
        Reporter.log("Test2 is executing.." , true);
    }

    @Test
    public void test3(){
        Reporter.log("Test3 is executing.." , true);
    }
}
