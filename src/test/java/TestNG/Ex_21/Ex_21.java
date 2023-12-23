package TestNG.Ex_21;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex_21 {
    //Extent Report

    @Test
    public void report(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);

        ExtentSparkReporter esr = new ExtentSparkReporter("C:\\Users\\hp\\IdeaProjects\\AdvancedSelenium\\src\\test\\java\\TestNG\\Ex_21\\Report.html");
        ExtentReports er = new ExtentReports();
        er.attachReporter(esr);

        ExtentTest et = er.createTest("Ex_21");
        et.log(Status.INFO , "Report created Successfully");
        et.addScreenCaptureFromBase64String(source);

        er.flush();
    }
}
