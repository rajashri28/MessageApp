package com.example.teslaind1.messageapp.apiclass;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClass {


    public static final String URL  = "http://192.168.2.7/MessageApp/insert.php/";
    public static final String URL2  = "http://192.168.2.7/MessageApp/getallmessages.php/";
    public static Retrofit RETROFIT = null;
    public static Retrofit RETROFIT1 = null;
    public static Retrofit RETROFIT2 = null;


    public static Retrofit addingMessage(String URL){

        if(RETROFIT2==null){

            RETROFIT2 = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT2;
    }


    public static Retrofit getClient(String URL){

        if(RETROFIT1==null){

            RETROFIT1= new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT1;
    }


    public static Retrofit getClientForViewMessage(){

        if(RETROFIT==null){

            RETROFIT = new Retrofit.Builder()
                    .baseUrl(URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }





}
