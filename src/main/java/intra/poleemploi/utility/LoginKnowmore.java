package intra.poleemploi.utility;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
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

            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp");

            try {
                HttpResponse response = httpclient.execute(httpget);
                String responseJSON = EntityUtils.toString(response.getEntity(), "UTF8");
                Header[] headers = response.getAllHeaders();
                for (Header h : headers) {
                    System.out.println(h.getValue().toString());
                }
                CookieStore cookieStore = new CookieStore()
               // response.close();
               // httpclient.close();
                System.out.println(responseJSON);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void post() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/servlet/LoginCheck");

        httpPost.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/png,*/*;q=0.8,application/signed-exchange;v=b3");
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Mobile Safari/537.36");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        httpPost.setHeader("Accept-Language","fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
        httpPost.setHeader("Upgrade-Insecure-Requests","1");
        httpPost.setHeader("cache-control", "no-cache");
        httpPost.setHeader("Connection","keep-alive");
        httpPost.setHeader("Referer","http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/servlet/LoginCheck");
       // httpPost.setHeader("Postman-Token","9612f8ee-d007-4379-93bd-ace210154b73");
      //  httpPost.setHeader(HttpHeaders.COOKIE,"JSESSIONID=C9FCECECAB577D815DAA62368D339A58");

//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//
//        params.add(new BasicNameValuePair("name", "ipco2530"));
//        params.add(new BasicNameValuePair("password", "Exchange91210"));
//
//        httpPost.setEntity(new UrlEncodedFormEntity(params));

        String entityData = "name=ipco2530&password=Exchange91210";
        StringEntity entity = new StringEntity(entityData,"UTF8");


//        String json = "{\"id\":1,\"name\":\"ipco2530\",\"password\": \"Exchange91210\"}";
//        StringEntity entity = new StringEntity(json);
         httpPost.setEntity(entity);

        HttpResponse response = httpclient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            //throw new RuntimeException("Failed with HTTP error code : " + statusCode);
        }
        if (statusCode == 302 ){
            httpPost = new HttpPost("http://kmore-gfpe-fkqt507.sii24.pole-emploi.intra:15071/know/index.jsp;jsessionid=D8FC3E922F408DC70A7BF7C77AACF8D3");
            httpPost.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/png,*/*;q=0.8,application/signed-exchange;v=b3");
            httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            httpPost.setHeader("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Mobile Safari/537.36");
            httpPost.setHeader("Accept-Encoding", "gzip, deflate");
            httpPost.setHeader("Accept-Language","fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
            httpPost.setHeader("Upgrade-Insecure-Requests","1");
            httpPost.setHeader("cache-control", "no-cache");
            httpPost.setHeader("Connection","keep-alive");
            httpPost.setHeader(HttpHeaders.COOKIE,"JSESSIONID=C9FCECECAB577D815DAA62368D339A58");
            httpPost.setEntity(entity);
        }
        String responseJSON = EntityUtils.toString(response.getEntity(), "UTF8");
       // response.close();
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

