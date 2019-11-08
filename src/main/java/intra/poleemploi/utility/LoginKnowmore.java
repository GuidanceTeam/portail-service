package intra.poleemploi.utility;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginKnowmore {

    // http://pr051-gfpe-3upxjf0.sip91.pole-emploi.intra:22391/know/login.jsp    //prod
    // http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp    //recette
       private String jsessionId;

        public void get(){
//            CloseableHttpClient http = null;
//            CookieStore httpCookieStore = new BasicCookieStore();
//            HttpClientBuilder builder = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore);
//            http = builder.build();

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp");

            try {
                CloseableHttpResponse response = httpclient.execute(httpget);
                String responseJSON = EntityUtils.toString(response.getEntity(), "UTF8");
                Header[] headers = response.getAllHeaders();
                for (Header h : headers) {
                    System.out.println(h.getValue().toString());
                }
                response.close();
                System.out.println(responseJSON);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void post() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/servlet/LoginCheck");

        httpPost.setHeader("Content-type","application/x-www-form-urlencoded");
        httpPost.setHeader("Accept", "text/html,application/xhtml,application/xml;q=0.9,image/webp,image/png,*/;q=0.8,application/signed-exchange;v=b3");
//        httpPost.setHeader("Content-type", "application/json");
//        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
//        httpPost.setHeader("Accept-Language","fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
      //  httpPost.setHeader("Cookie",jsessionId);
    //    httpPost.setHeader("Cookie",jsessionId);

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("name", "ipco2530"));
        params.add(new BasicNameValuePair("password", "Exchange91210"));

        httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF8"));

 //       String json = "{\"name\":\"ipco2530\",\"password\": \"Exchange91210\"}";
  //      StringEntity entity = new StringEntity(json);
   //     httpPost.setEntity(entity);

        CloseableHttpResponse response = httpclient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            //throw new RuntimeException("Failed with HTTP error code : " + statusCode);
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

