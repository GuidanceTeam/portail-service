package intra.poleemploi.utility;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

public class ReadHtmlTableMain {

        public static void main(String[] args) throws IOException, URISyntaxException {
//            ReadHtmlTable readHtmlTable = new ReadHtmlTable();
//            readHtmlTable.listApplication();
//            readHtmlTable.listContents();
//            String firstCallBeforeLoginURL = "http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp";
//            CompletableFuture<String> response = new CompletableFuture<>();
//            FirstCallBeforeLogin firstCallKM = new FirstCallBeforeLogin();
//            response = firstCallKM.firstCallBeforeLogging(firstCallBeforeLoginURL);
//            System.out.println("response " + response.toString());

            LoginKnowmore firstCallBeforeLogin = new LoginKnowmore();
            firstCallBeforeLogin.get();
            firstCallBeforeLogin.post();
        }


}

