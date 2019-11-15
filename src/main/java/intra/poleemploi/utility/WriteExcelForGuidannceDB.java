package intra.poleemploi.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelForGuidannceDB {

    public void WriteExcelForGuidannceDB(){

    }

    XSSFWorkbook workBook = new XSSFWorkbook();
    XSSFSheet sheet = new workBook.CreateSheet("C:\demo\KMAppliDump.xlsx");
}
