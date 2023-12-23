package TestNG.Ex_10;

import org.apache.poi.ss.usermodel.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex_10 {

    //Read data from Excel at any row and column (0,0) , (0,1) , (0,2) ... etc.
    @Test
    public void excelDataAccess(){
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\AdvancedSelenium\\src\\test\\java\\TestNG\\Ex_10\\a.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            for (Row r : sheet){
                for (Cell c : r){
                    String value = c.getStringCellValue();
                    Reporter.log("(" + r.getRowNum() + "," + c.getColumnIndex() + ") --> " + value , true);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
