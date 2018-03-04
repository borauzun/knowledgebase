package nmfs.gen.adapter.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


    // Later projects : -
    public List<String> readAll(FileInputStream inputStream, String excelFilePath,int noOfColumns,int[] columnsToIgnore) {
        try {
            Workbook workbook= getWorkbook(inputStream, excelFilePath);
            Sheet excelTab=workbook.getSheetAt(0);
            Iterator<Row> iterator = excelTab.iterator();
            Row firstRow = iterator.next(); // ilk row basliklar

            String[] str=new String[noOfColumns];


            while (iterator.hasNext())
            {
                Row nextRow = iterator.next();
                for(int i=0;i<noOfColumns;i++)
                {
                    if(!(Arrays.binarySearch(columnsToIgnore, i)>=0)) { // if index is not to ignore


                    }
                }
                String open=getCellValueString(nextRow.getCell(2));
            }

            } catch (Exception ex) {
                           new Exception("nmfs.gen.adapter.excel.ExcelReader:"+ex.getMessage());
                       }

     return null;
    }

    // sample usage
    private void sample(String excelFilePath) throws Exception {
        //URL resource = classLoader.getResource(excelFilePath);  // this is to get it from resources
        //File file = new File(resource.toURI());
        //FileInputStream inputStream = new FileInputStream(file);
        // Workbook workbook= getWorkbook(inputStream, resource.toURI().toString());
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook= getWorkbook(inputStream, excelFilePath);

        //int nos=workbook.getNumberOfSheets();
        Sheet firstSheet=workbook.getSheetAt(0);
        // Iterable<Row> iterable=workbook.getSheetAt(0);       maybe we can replace iterator with stream ?
       // List<Row> result=StreamSupport.stream(iterable.spliterator()<Row>,false);

        Iterator<Row> iterator = firstSheet.iterator();
        Row firstRow = iterator.next(); // ilk row basliklar

        while (iterator.hasNext())
        {
            Row nextRow = iterator.next();

            String open=getCellValueString(nextRow.getCell(2));
        }


    }

    // +++ creates the workbook based on extension
    private  Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
            throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    //+++ returns the cell as String
    private  String getCellValueString(Cell cell) {
        String value="";
        if(cell!=null) {
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_BOOLEAN:
                    value=String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    value= BigDecimal.valueOf(
                            cell.getNumericCellValue()).toPlainString();
                    break;
                case Cell.CELL_TYPE_STRING:
                    value=String.valueOf(cell.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    value=String.valueOf(cell.getCellFormula());
                    break;
                case Cell.CELL_TYPE_BLANK:
                    value="";
                    break;
            }
        } else {
            // value is null
        }
        return value.trim();
    }
}
