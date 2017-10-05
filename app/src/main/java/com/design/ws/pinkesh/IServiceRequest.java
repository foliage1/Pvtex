package com.design.ws.pinkesh;

/**
 * Created by praveen on 6/29/2017.
 */
public interface IServiceRequest {

    void onResponse(String response);

    void onError(String errorResponse);


}