package intra.poleemploi.utility;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;


public class LoginKnowmore {

    // http://pr051-gfpe-3upxjf0.sip91.pole-emploi.intra:22391/know/login.jsp    //prod
    // http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp    //recette

    public void get() throws URISyntaxException, IOException {
      //  HttpGet httpget = new HttpGet(
       //         "http://www.google.com/search?hl=en&q=httpclient&btnG=Google+Search&aq=f&oq=");

        //HttpClient provides URIBuilder utility class to simplify creation and modification of request URIs.

//        URI uri = new URIBuilder()
//                .setScheme("http")
//                .setHost("www.google.com")
//                .setPath("/search")
//                .setParameter("q", "httpclient")
//                .setParameter("btnG", "Google Search")
//                .setParameter("aq", "f")
//                .setParameter("oq", "")
//                .build();
//        HttpGet httpget = new HttpGet(uri);
//        System.out.println(httpget.getURI());

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp ");
        CloseableHttpResponse response = httpclient.execute(httpget);
        String responseJSON = EntityUtils.toString(response.getEntity(),"UTF8");
        System.out.println(responseJSON);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                int byteOne = instream.read();
                int byteTwo = instream.read();
                // Do not need the rest
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
    }
    

}
