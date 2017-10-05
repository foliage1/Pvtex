package com.design.ws.pinkesh;

/**
 * Created by praveen on 6/29/2017.
 */
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by pratap.kesaboyina on 09-12-2016.
 */

public class ServiceHandler {


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static OkHttpClient client=new OkHttpClient();


    public static Call post(String url, String json, Callback callback) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()

                .url(url)
                .post(body)
                .build();


        Call call = client.newCall(request);
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        call.enqueue(callback);

        return call;
    }

    public static Call get(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }


}