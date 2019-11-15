package intra.poleemploi.utility;

import intra.poleemploi.entities.Appli;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteExcelForGuidanceDB {

//    @Autowired
//    private RepositoryRestConfiguration repositoryRestConfiguration;
//    @Autowired
//    AppliRepository appliRepository;

    public WriteExcelForGuidanceDB() {
      //  repositoryRestConfiguration.exposeIdsFor(Appli.class);
    }

    public void appliInsertIntoExcelFile(List<Appli> listAppli) throws IOException {

        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("Applications");

  //      List<Appli> listAppli;
 //       listAppli = appliRepository.findAll();

        int rowCount = 0;

        for (Appli appli : listAppli) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            Cell cell = row.createCell(++columnCount);
            cell.setCellValue((String) appli.getIdAppliKM());
            cell = row.createCell(++columnCount);
            cell.setCellValue((String) appli.getAppliName());
            cell = row.createCell(++columnCount);
            cell.setCellValue((String) appli.getAppliURL());

        }
        try (FileOutputStream outputStream = new FileOutputStream("C:/demo/KnowMore/knowMore CoachedAppli.xlsx")) {
            workBook.write(outputStream);
        }
    }
}

