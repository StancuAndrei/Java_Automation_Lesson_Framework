package utility;

import exceldata.ExcelDataSupplier;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider( name = "getCredentials")
    public Object[][] getCredentials(){
        return new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"}
        };
    }

    @DataProvider(name = "excelData")
    public Object[][] excelData() throws IOException {
        String[][] testData = ExcelDataSupplier.getData();
        Object[][] data = new Object[testData.length][testData[0].length];

        for ( int i = 0; i< testData.length; i++){
            for (int j = 0; j < testData[0].length; j++){
                data[i][j] = testData[i][j];
            }
        }
        return data;
    }




}
