package intra.poleemploi.utility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.accessibility.AccessibleStateSet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReadHtmlTableMain {

        public static void main(String[] args) throws IOException {
            ReadHtmlTable readHtmlTable = new ReadHtmlTable();
            readHtmlTable.listApplication();
            readHtmlTable.listContents();

        }


}

