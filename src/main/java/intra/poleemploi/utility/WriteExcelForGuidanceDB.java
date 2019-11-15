package intra.poleemploi.utility;

import intra.poleemploi.dao.AppliRepository;
import intra.poleemploi.entities.Appli;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteExcelForGuidanceDB {
    @Autowired
    private AppliRepository appliRepository;

    public WriteExcelForGuidanceDB() throws IOException {
    }

    public void WriteExcelForGuidanceDB() {

    }

    String pathName = "C:/demo/KnowMore/knowMore CoachedAppli.xlsx";
    XSSFWorkbook workBook = new XSSFWorkbook(pathName);
    XSSFSheet sheet = workBook.createSheet("Applications");

    List<Appli> listAppli = new ArrayList<>();
    appliRepository.findAll().forEach(System.out::println);

}