package TestNG.Ex_12;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex_12 {

    @DataProvider(name = "ExcelData")
    public Object[][] data(){
        Object[][] d = new Object[2][2];
        d[0][0] = "Hello";
        d[0][1] = "Hi";
        d[1][0] = "Thank";
        d[1][1] = "You";

        return d;
    }

    @Test(dataProvider = "ExcelData")
    public void m1(String Username , String Password){
        Reporter.log(Username , true);
        Reporter.log(Password , true);
    }
}
