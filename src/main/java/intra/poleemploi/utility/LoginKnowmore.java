package intra.poleemploi.utility;


import intra.poleemploi.entities.Appli;
import intra.poleemploi.entities.Content;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.List;

class LoginKnowMore {

    // http://pr051-gfpe-3upxjf0.sip91.pole-emploi.intra:22391/know/login.jsp    //prod
    // http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp    //recette

    List<Content> get(List<Appli> listAppli) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<Content> listcontentToBeReturned = null;
        for (Appli appli : listAppli) {

            HttpGet httpget = new HttpGet(appli.getAppliURL());
            CloseableHttpResponse response = httpclient.execute(httpget);
            int statusCode = response.getStatusLine().getStatusCode();
            ReadHtmlTable readHtmlTable = new ReadHtmlTable();
            if (statusCode == 200) {
                //A faire traitement de la réponse

                String responseKM = EntityUtils.toString( response.getEntity(), "UTF8");
                httpclient.close();
                List<Content> listContents = readHtmlTable.getContentsList(responseKM);
                for( Content content : listContents) {
                    listcontentToBeReturned.add(content);
                }
            }
            else {throw new RuntimeException("Failed with HTTP error code : " + statusCode);}
        }
        return listcontentToBeReturned;



//        try {
//            String responseJSON = EntityUtils.toString(response.getEntity(), "UTF8");
//            Header[] headers = response.getAllHeaders();
//            for (Header h : headers) {
//                System.out.println(h.getValue());
//            }
//            System.out.println(responseJSON);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {

        // }
    }

    List<Appli> post() throws IOException {
        String url = "http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/servlet/LoginCheck";

        HttpResponse response = httpPostResponse(url);

        int statusCode = response.getStatusLine().getStatusCode();
        ReadHtmlTable readHtmlTable = new ReadHtmlTable();
        String location;
        String responseKM;
        if (statusCode == 200) {
            responseKM = EntityUtils.toString(response.getEntity(), "UTF8");
            return readHtmlTable.getAppliList(responseKM);
        }
        if (statusCode == 302) {
            Header[] headers = response.getHeaders("Location");
            location = headers[0].getValue();
            responseKM = httpGetResponse(location);
            return readHtmlTable.getAppliList(responseKM);

        }
        throw new RuntimeException("Failed with HTTP error code : " + statusCode);
    }

    CloseableHttpResponse httpPostResponse(String url) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        httpPost.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/png,*/*;q=0.8,application/signed-exchange;v=b3");
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Mobile Safari/537.36");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        httpPost.setHeader("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
        httpPost.setHeader("Upgrade-Insecure-Requests", "1");
        httpPost.setHeader("cache-control", "no-cache");
        httpPost.setHeader("Connection", "keep-alive");

        String entityData = "name=ipco2530&password=Exchange91210";
        StringEntity entity = new StringEntity(entityData, "UTF8");

        httpPost.setEntity(entity);

        CloseableHttpResponse response = httpclient.execute(httpPost);
        httpclient.close();
        return response;
    }

    String httpGetResponse(String url) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        httpGet.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/png,*/*;q=0.8,application/signed-exchange;v=b3");
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Mobile Safari/537.36");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        httpGet.setHeader("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        httpGet.setHeader("cache-control", "no-cache");
        httpGet.setHeader("Connection", "keep-alive");

       // String entityData = "name=ipco2530&password=Exchange91210";
        //StringEntity entity = new StringEntity(entityData, "UTF8");

        //httpGet.(entity);

        CloseableHttpResponse response = httpclient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        String responseKM;
        if (statusCode == 200) {
            responseKM = EntityUtils.toString(response.getEntity(), "UTF8");
        }
        else {throw new RuntimeException("Failed with HTTP error code : " + statusCode);}
        httpclient.close();
        return responseKM;
    }
}

