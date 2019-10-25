package intra.poleemploi.utility;

import intra.poleemploi.entities.Appli;
import intra.poleemploi.entities.Content;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadExcel {

    public  ReadExcel() throws IOException {}

    public List<Appli> getAppliList(String pathName) throws IOException {
        // Read XSL file
        FileInputStream inputStream = new FileInputStream(new File(pathName));

        // Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();


        List<Appli> appliList = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();


            Appli appli = new Appli();
            String temp;
            List<String> listString = new ArrayList<>();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                listString.add(cell.getStringCellValue());
                   // Change to getCellType() if using POI 4.x
//                CellType cellType = cell.getCellType();
//
//                switch (cellType) {
//                    case _NONE:
//                        System.out.print("");
//                        System.out.print("\t");
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        System.out.print("\t");
//                        break;
//                    case BLANK:
//                        System.out.print("");
//                        System.out.print("\t");
//                        break;
//                    case FORMULA:
//                        // Formula
//                        System.out.print(cell.getCellFormula());
//                        System.out.print("\t");
//
//                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//                        // Print out value evaluated by formula
//                        System.out.print(evaluator.evaluate(cell).getNumberValue());
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        System.out.print("\t");
//                        break;
//                    case STRING:
//                        System.out.print(cell.getStringCellValue());
//                        System.out.print("\t");
//                        break;
//                    case ERROR:
//                        System.out.print("!");
//                        System.out.print("\t");
//                        break;
//                }
//
            }
            listString.forEach(System.out::println);
            appli.setIdAppliKM(listString.get(0));
            appli.setAppliName(listString.get(1));
            appli.setURL(listString.get(2));
            appliList.add(appli);
            //System.out.println(appliList.toString());
        }
    return appliList;
    }

    public List<Content> getContentList(String pathName) throws IOException {
        // Read XSL file
        FileInputStream inputStream = new FileInputStream(new File(pathName));

        // Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();


        List<Content> getListData = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();


            Content content = new Content();
            String temp;
            List<String> listString = new ArrayList<>();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                listString.add(cell.getStringCellValue());

            }
            listString.forEach(System.out::println);
            content..setIdAppliKM(listString.get(0));
            content.setAppliName(listString.get(1));
            content.setURL(listString.get(2));
            getListData.add(appli);
            //System.out.println(appliList.toString());
        }
        return getListData;
    }

}
