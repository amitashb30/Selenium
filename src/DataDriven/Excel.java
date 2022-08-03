package DataDriven;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Excel
{

    public void readexcel(String filepath,String filename,String sheetname)
    {
        try {

        File fl = new File(filepath+"\\"+filename);
        FileInputStream is = new FileInputStream(fl);
        Workbook wb = null;
        String exten = filename.substring(filename.indexOf("."));

        if(exten.equals(".xlsx"))
        {
            wb = new XSSFWorkbook(is);
        }

            Sheet sheet = wb.getSheet(sheetname);
            int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum(); // for row its RowNum() or getFirstRowNum to get the size of the row

        for(int i=0;i<rowcount+1;i++)
        {
            Row row = sheet.getRow(i);
            for(int j=0;j<row.getLastCellNum();j++) // for column values it is getLastCellNum()
            {
                System.out.println(row.getCell(j).getStringCellValue()+"| |");

            }
            System.out.println();


        }




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    public static void main(String args[])
    {

        Excel xl = new Excel();
        xl.readexcel("C:\\Users\\abhat357\\Automation\\ODS-QA-Automation-serenity-framework\\Selenium\\resource","TestExcel.xlsx","Test1");


    }


}



