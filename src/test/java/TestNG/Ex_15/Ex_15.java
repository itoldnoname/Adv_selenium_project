package TestNG.Ex_15;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Ex_15 {

    WebDriver driver;

    @Test (priority = 1)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
    }

    @DataProvider (name = "ExcelData")
    public Object[][] value() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\AdvancedSelenium\\src\\test\\java\\TestNG\\Ex_15\\a.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        int row = sheet.getPhysicalNumberOfRows();
        int column = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] obj = new Object[row][column];

        for (int i = 0 ; i<row ; i++){
            for (int j = 0 ; j<column ; j++){
                if (sheet.getRow(i) != null && sheet.getRow(i).getCell(j) != null){
                    switch (sheet.getRow(i).getCell(j).getCellType()){
                        case STRING :
                            obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                            break;
                        case NUMERIC :
                            obj[i][j] = sheet.getRow(i).getCell(j).getNumericCellValue();
                            break;
                        default :
                            obj[i][j] = "";
                            break;
                    }
                }else {
                    obj[i][j] = "";
                }
            }
        }

        return obj;
    }

    @Test (dataProvider = "ExcelData" , priority = 2)
    public void register(String firstName , String lastName , String email , String password) {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
        //logout
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
        //Status
        Reporter.log("User Created Successfully.." , true);
    }

    @Test (dataProvider = "ExcelData" , priority = 3)
    public void logIn(String firstName , String lastName , String email , String password){
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        //logout
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
        //Status
        Reporter.log("User LogIn Successful.." , true);
    }

}
