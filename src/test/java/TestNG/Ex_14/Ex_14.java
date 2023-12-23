package TestNG.Ex_14;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex_14 {

    @DataProvider(name = "ExcelData")
    public Object[][] data() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\AdvancedSelenium\\src\\test\\java\\TestNG\\Ex_13\\a.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        int row = sheet.getPhysicalNumberOfRows();
        int column = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] d = new Object[row-1][column];

        for (int i = 0 ; i<row-1 ; i++){
            for (int j = 0 ; j<column ; j++){
                 d[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
            }
        }

        return d;
    }

    @Test(dataProvider = "ExcelData")
    public void m1(String value1 , String value2){
        Reporter.log(value1 , true);
        Reporter.log(value2 , true);
    }
}
