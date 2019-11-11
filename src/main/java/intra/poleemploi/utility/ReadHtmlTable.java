package intra.poleemploi.utility;

import intra.poleemploi.entities.Appli;
import intra.poleemploi.entities.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadHtmlTable {

    public List<Appli> getAppliList(String html) throws IOException {
        LoginKnowMore loginKnowMore = new LoginKnowMore();

//        File html = new File("c:/demo/KnowMore/Responses/reponse liste applications.html");  //lecture fichier html
        List<Appli> listAppli = new ArrayList<Appli>();

        Document doc = Jsoup.parse(new File(html), "UTF-8", "");
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");
        int pos = 0;
        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            Attributes href = row.attributes();
            String urlAppliNonFiltrered = href.get("onclick");
            pos = urlAppliNonFiltrered.indexOf("applicationId=");
            String urlAppli = urlAppliNonFiltrered.substring(16, urlAppliNonFiltrered.length() - 1);
            pos = urlAppli.indexOf("applicationId=");
            String idApplication = urlAppli.substring(pos + 14, urlAppli.length());
            Appli appli = new Appli();
            appli.setIdAppliKM(idApplication);
            appli.setAppliName(cols.get(0).text());
            appli.setAppliURL(urlAppli);
            System.out.println("col1 " + cols.get(0).text() + " col2 " + cols.get(1).text() + " idApplication " + idApplication);
            listAppli.add(appli);
        }
        return listAppli;
    }

    List<Content> getContentsList(String html) throws IOException {

        LoginKnowMore loginKnowMore = new LoginKnowMore();
        List<Content> listContent = new ArrayList<Content>();
        // File html = new File("c:/demo/KnowMore/Responses/reponse liste des contenus competence.html");
        Document doc = Jsoup.parse(new File(html), "UTF-8", "");

        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            Attributes onClick = row.attributes();
            String urlNonFiltrered = onClick.get("onclick");

            int posLocationHref = urlNonFiltrered.indexOf("location.href="); //recherche y compris le guillement
            String url = urlNonFiltrered.substring(posLocationHref + "location.href=\'".length(), urlNonFiltrered.length() - 1);
            Content content = new Content();
            int posPubId = url.indexOf("pubId=");
            int posAmpersand = url.indexOf("&");
            String idContent = url.substring(posPubId + "pubId=".length(), posAmpersand);

            content.setContentName();
            content.setDescription();
            content.setNbAffichages();
            content.setNbLectures();
            listContent.add(content);
            System.out.println("col1 " + cols.get(0).text() + " col2 " + cols.get(1).text()
                    + " col3 " + cols.get(2).text() + " col4 " + cols.get(3).text()
                    + " col5 " + cols.get(4).text() + " col6 " + cols.get(5).text()
                    + " col7 " + cols.get(6).text());
        }
        return listContent;
    }


}