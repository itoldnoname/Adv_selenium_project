package TestNG.Ex_16;

import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Ex_16 {

    @Test
    public void m1() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\AdvancedSelenium\\src\\test\\java\\TestNG\\Ex_16\\data.properties");
        Properties p = new Properties();
        p.load(fis);
        String value = p.getProperty("url");
        Reporter.log("The URL is --> " + value , true);
    }

}
