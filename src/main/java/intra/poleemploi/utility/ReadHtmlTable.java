package intra.poleemploi.utility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReadHtmlTable {

    public static void main(String[] args) throws IOException {

        File html = new File("c:/demo/KnowMore/Responses/reponse liste applications.html");
        Document doc = Jsoup.parse(html,"UTF-8","");

        ArrayList<String> downServers = new ArrayList<>();
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");

            System.out.println(cols.get(0).text()+" "+ cols.get(1).text());
        }


    }

}
