package TestNG.Ex_11;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex_11 {

    //Read data from the Excel and print all the details except 1st row..
    @Test
    public void trainerName(){

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\AdvancedSelenium\\src\\test\\java\\TestNG\\Ex_11\\a.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            for (int i = 1 ; i<=sheet.getPhysicalNumberOfRows() ; i++){
                for (int j = 0 ; j<=sheet.getRow(i).getPhysicalNumberOfCells() ; j++){
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    Reporter.log("(" + sheet.getRow(i).getRowNum() + "," + sheet.getRow(i).getCell(j).getColumnIndex() + ") --> " + value , true);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
