package TestNG.Ex_9;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex_9 {

    //Read data from Excel at particular row and column like (0,0)
    @Test
    public void excelDataAccess(){
            try {
                FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\AdvancedSelenium\\src\\test\\java\\TestNG\\Ex_9\\a.xlsx");
                Workbook workbook = WorkbookFactory.create(fis);
                Sheet sheet = workbook.getSheet("Sheet1");
                String value = sheet.getRow(0).getCell(0).getStringCellValue();
                Reporter.log( "The Value inside the Excel is --> " + value, true);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}
