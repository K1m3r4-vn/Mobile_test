package com.example.aaaaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        token = getIntent().getStringExtra("token");
    }
    //call api user
    //call api asset
    private void callApiUser(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://uiot.ixxc.dev/api/master/user/user")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + token).build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            Gson gson = new Gson();
            User user = gson.fromJson(responseBody, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void callApiAsset(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://uiot.ixxc.dev/api/master/asset/20Jgh2JaDojzObTMxUSfGL")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + token).build();
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            Gson gson = new Gson();
            Asset asset = gson.fromJson(responseBody, Asset.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}