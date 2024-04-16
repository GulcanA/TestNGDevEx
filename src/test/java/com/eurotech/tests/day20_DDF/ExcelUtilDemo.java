package com.eurotech.tests.day20_DDF;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    // Create an object from ExcelUtil class - it accepts two argument
    // Argument 1: location of the Excel file (path)
    // Argument 2: sheet that we want to open (sheetName)


    @Test
    public void readExcelFile() {
        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest.xlsx", "Test Data");

        // How many rows in the sheet?
        System.out.println("testData.rowCount() = " + testData.rowCount());

        // How many columns in the sheet?
        System.out.println("testData.columnCount() = " + testData.columnCount());

        // get all column names
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames());

        // get all data in List of String
        List<Map<String, String>> dataList = testData.getDataList();
        for(Map<String, String> oneRow : dataList){
            System.out.println("oneRow = " + oneRow);
        }

        // get 3rd row
        System.out.println("dataList.get(2) = " + dataList.get(2));

        // get Coskun's title
        System.out.println("dataList.get(6).get(\"Title\") = " + dataList.get(6).get("Title"));

        // get Keti's company
        System.out.println("dataList.get(10).get(\"Company\") = " + dataList.get(10).get("Company"));

        // get array
        String[][] dataArray = testData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));
    }

}
