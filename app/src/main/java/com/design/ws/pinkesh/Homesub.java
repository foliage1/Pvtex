package com.design.ws.pinkesh;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class Homesub extends Activity implements IServiceRequest {


    String responseData = "";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ProgressDialog dialog;
    IServiceRequest serviceRequest;

    private List<User_closed_sub> usersList;
    String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_sub);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }


        serviceRequest = Homesub.this;
        usersList = new ArrayList<User_closed_sub>();


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
       recyclerView.addItemDecoration(new DividerItemDecoration(Homesub.this,
                DividerItemDecoration.VERTICAL));
        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // create an Object for Adapter
        mAdapter = new UsersclosedAdaptersub(this, usersList);
        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);


        callService();
    }


    public void callService() {
        dialog = new ProgressDialog(Homesub.this);
        dialog.getWindow().setBackgroundDrawable(new
                ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();
        dialog.setContentView(R.layout.my_progress);

        ServiceHandler.get("http://foliagetech.96.lt/Tally/subcategorylist.php?category="+newString, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                responseData = "No internet Connection";
                serviceRequest.onError(responseData);
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {

                    if (response.isSuccessful()) {

                        responseData = response.body().string();
                        Log.i("Response", responseData);
                        JSONObject jsnobject = new JSONObject(responseData);

                        JSONArray jsonArray = jsnobject.getJSONArray("msg");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject users = jsonArray.getJSONObject(i);



                            String firstName = users.getString("subcategory");
                            String count=users.getString("count");
                           /* String pic = users.getString("product_img");
                            String endtime=users.getString("endtime");
                            String bitprice=users.getString("bidrate");
                            String mrp=users.getString("mrp");

                            String realpic="http://www.bidshop.in/upload/product/small/"+pic;*/




                            User_closed_sub user = new User_closed_sub(firstName,count);

                            usersList.add(user);


                        }


                        serviceRequest.onResponse(responseData);
                        Log.i("Response", responseData);
                    } else {

                        responseData = "Something went Wrong";
                        serviceRequest.onError(responseData);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    responseData = "IO Error";
                    serviceRequest.onError(responseData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    responseData = "Parsing Error";
                    serviceRequest.onError(responseData);
                }
            }
        });
    }


    @Override
    public void onResponse(String response) {
dialog.dismiss();
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onError(String errorResponse) {


        Toast toast = Toast.makeText(this, errorResponse, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }


}