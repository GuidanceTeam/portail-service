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

public class ReadExcelDemo {


    public ReadExcelDemo() {
    }

    private Iterator<Row> readExcelFile(String pathName) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(pathName));
        // Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        // Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        // Get iterator to all the rows in current sheet
        return sheet.iterator();
    }

    public List<Appli> getAppliList() throws IOException {
        String pathName = "C:/demo/KnowMore/knowMore CoachedAppli.xlsx";
        //lecture excel file
        Iterator<Row> rowIterator = readExcelFile(pathName);

        List<Appli> appliList = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();
            //List<String> listRow = new ArrayList<>();
            Appli appli = new Appli();
            if (row.getRowNum() > 0) {
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getColumnIndex()) {
                        case 0:
                            appli.setIdAppliKM(cell.getStringCellValue());
                            break;
                        case 1:
                            appli.setAppliName((cell.getStringCellValue()));
                            break;
                    }
                }
                appliList.add(appli);
            }
        }
        return appliList;
    }

    public List<Content> getContentList(List<Appli> appliList) throws IOException {
        String pathName = "C:/demo/KnowMore/knowMore ContentAppli.xlsx";
        // Read XSL file
        //lecture excel file
        Iterator<Row> rowIterator = readExcelFile(pathName);

        List<Content> contentList = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();
            //List<String> listRow = new ArrayList<>();
            Content content = new Content();
            if (row.getRowNum() > 0) {
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            content.setIdContentKM(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case 1:
                            content.setContentName(cell.getStringCellValue());
                            break;
                        case 2:
                            content.setPublished(Boolean.parseBoolean(cell.getStringCellValue()));
                            break;
                        case 3:
                            content.setTypeService(cell.getStringCellValue());
                            break;
                        case 4:
                            content.setNbLectures((int) cell.getNumericCellValue());
                            break;
                        case 5:
                            content.setNbAffichages((int) cell.getNumericCellValue());
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
                            break;
                        case 10:
                            for (Appli appli : appliList) {
                                if (appli.getIdAppliKM().equals(cell.getStringCellValue())) {
                                    content.setAppli(appli);
                                    break;
                                }
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + cell.getColumnIndex());
                    }
                }
                contentList.add(content);
            }
        }
        return contentList;
    }
}