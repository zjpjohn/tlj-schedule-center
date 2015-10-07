package com.taolijie.schedule.test;

import com.taolijie.schedule.http.HttpClientFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by whf on 10/7/15.
 */
public class HttpTest {
    @Test
    public void test() throws Exception {

        HttpClientBuilder builder = HttpClientBuilder.create();
        for (int ix = 0 ; ix < 1 ; ++ix) {
            sendOneQuest(HttpClientFactory.getClient());
            //sendOneQuest(builder.build());
        }
    }

    private void sendOneQuest(HttpClient client) throws Exception {
        HttpPost post = new HttpPost("http://api.weimi.cc/2/sms/send.html");

        List<NameValuePair> parmList = new ArrayList<>();
        parmList.add(new BasicNameValuePair("uid", "Ctpc2fjQKMq3"));
        parmList.add(new BasicNameValuePair("pas", "7yaz2zeb"));
        parmList.add(new BasicNameValuePair("mob", "18518369058"));
        parmList.add(new BasicNameValuePair("cid", "d9Z7uIKCYqhQ"));
        parmList.add(new BasicNameValuePair("p1", "wanghongfei"));
        parmList.add(new BasicNameValuePair("type", "json"));

        post.setEntity(new UrlEncodedFormEntity(parmList, HTTP.UTF_8));

        HttpResponse resp = client.execute(post);
        InputStream in = resp.getEntity().getContent();

        InputStreamReader inReader = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(inReader);

        String line = null;
        while ( (line = reader.readLine()) != null ) {
            System.out.println(line);
        }

    }
}