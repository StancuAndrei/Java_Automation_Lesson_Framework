package exceldata;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataSupplier {

    public static String[][] getData() throws IOException {

        File file = new File(System.getProperty("user.dir") + "\\src\\Resources\\TestData.xlsx");

        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowNumbers = sheet.getPhysicalNumberOfRows();

        int colNumbers = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rowNumbers-1][colNumbers];

        for ( int i = 0; i < rowNumbers-1; i++){
            for ( int j =0; j < colNumbers; j++){
                data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
            }
        }

        workbook.close();
        fis.close();

        return data;

    }




}
