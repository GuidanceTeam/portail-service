package intra.poleemploi.utility;

import intra.poleemploi.entities.Appli;
import intra.poleemploi.entities.Content;
import intra.poleemploi.entities.StatistiquesParJour;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadExcel {


    public  ReadExcel() {}

    private List<List<String>> readExcelFile(String pathName) throws IOException {
        // Read XSL file
        FileInputStream inputStream = new FileInputStream(new File(pathName));
        // Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        // Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        List<List<String>> listData = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();

            List<String> listRow = new ArrayList<>();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                listRow.add(cell.getStringCellValue());
            }
            listData.add(listRow);
            //System.out.println(appliList.toString());
        }
        return listData;
    }

    public List<Appli> getAppliList() throws IOException {
        List<List<String>> listData;
        String PathName = "C:/demo/KnowMore/knowMore CoachedAppli.xlsx";
        listData = readExcelFile(PathName);

        List<Appli> appliList = new ArrayList<>();

        Appli  appli = new Appli();

        for (List<String> listString: listData) {
            if (listString.get(0) != "id") {
                appli.setIdAppliKM(listString.get(0));
                appli.setAppliName(listString.get(1));
                appli.setAppliURL(listString.get(2));
                appliList.add(appli);
            }
        }
        return appliList;
    }

    public List<Content> getContentList() throws IOException, ParseException {
        List<List<String>> listData;
        String PathName = "C:/demo/KnowMore/knowMore ContentAppli.xlsx";
        listData = readExcelFile(PathName);

        List<Content> contentList = new ArrayList<>();

        Content content = new Content();
        Appli appli = new Appli();
        for (List<String> listString: listData) {
            if (listString.get(0) != "date") {
                content.setId(Integer.valueOf(listString.get(0)));
                content.setContentName(listString.get(1));
                content.setPublished(Boolean.parseBoolean(listString.get(2)));
                content.setDescription(listString.get(3));
                content.setNbLectures(Integer.parseInt(listString.get(4)));
                content.setNbAffichages(Integer.parseInt(listString.get(5)));
                content.setIcone(listString.get(6));
                content.setContentURL(listString.get(7));
                content.setDebut(new SimpleDateFormat("dd/MM/yyyy").parse(listString.get(8)));
                content.setFin(new SimpleDateFormat("dd/MM/yyyy").parse(listString.get(9)));
                appli.setIdAppliKM(listString.get(10));
                content.setAppli(appli);
                contentList.add(content);
            }
        }

        return contentList;
    }

    public List<StatistiquesParJour> getStatistiquesParJourList() throws IOException, ParseException {
        List<List<String>> listData;
        String PathName = "C:/demo/KnowMore/dailyStatistics_pn066_2018-10-02_2019-10-02.xls";
        listData = readExcelFile(PathName);

        List<StatistiquesParJour> statistiquesParJourList = new ArrayList<>();

        StatistiquesParJour statistiquesParJour = new StatistiquesParJour();
        Content content = new Content();
        for (List<String> listString: listData) {
            if (listString.get(0) != "date") {
                statistiquesParJour.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(listString.get(0)));
                statistiquesParJour.setNbAffichage(listString.get(1));
                statistiquesParJour.setNbUsersAyantAffichesLaPastille(Long.valueOf(listString.get(2)));
                statistiquesParJour.setNbDeLectureDeLaPastille(Long.valueOf(listString.get(3)));
                statistiquesParJour.setNbUsersAyantLusLaPastille((Long.valueOf(listString.get(4))));
                statistiquesParJour.setTempsPasseSurLaPastilleMS(Long.valueOf(listString.get(5)));
                content.setId(Integer.valueOf(listString.get(6)));
                statistiquesParJour.setContent(content);
                statistiquesParJourList.add(statistiquesParJour);
            }
        }
        return statistiquesParJourList;
    }

}


