package intra.poleemploi.utility;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginKnowmore {

    // http://pr051-gfpe-3upxjf0.sip91.pole-emploi.intra:22391/know/login.jsp    //prod
    // http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp    //recette
       private String jsessionId;

        public void get(){
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp");

            try {
                CloseableHttpResponse response = httpclient.execute(httpget);
                String responseJSON = EntityUtils.toString(response.getEntity(), "UTF8");
                response.close();
                System.out.println(responseJSON);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void post() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/login.check");

        httpPost.setHeader("User-Agent","application/x-www-form-urlencoded");
        httpPost.setHeader("Accept", "text/html,application/xhtml,application/xml;q=0.9,image/webp,image/png,*/;q=0.8,application/signed-exchange;v=b3");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        httpPost.setHeader("Accept-Language","fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
        httpPost.setHeader("Cookie",jsessionId);

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("name", "ipco2530"));
        params.add(new BasicNameValuePair("password", "Exchange91210"));

        httpPost.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse response = httpclient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
        }
        String responseJSON = EntityUtils.toString(response.getEntity(), "UTF8");
        response.close();
        System.out.println(responseJSON);
        httpclient.close();

        //        try {
//            CloseableHttpResponse response = httpclient.execute(httpget);
//            String responseJSON = EntityUtils.toString(response.getEntity(), "UTF8");
//            response.close();
//            System.out.println(responseJSON);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    }

