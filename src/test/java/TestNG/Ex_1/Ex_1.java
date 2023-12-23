package TestNG.Ex_1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ex_1 {    //TestNG class (as we are using the annotation @Test in the method below)

    @Test
    public void test1(){        //Testcases
        Reporter.log("Test-1 is running.." , true);     //TestSteps
    }

}
