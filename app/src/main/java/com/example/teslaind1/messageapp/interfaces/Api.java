package com.example.teslaind1.messageapp.interfaces;

import com.example.teslaind1.messageapp.model.GetMessage;
import com.example.teslaind1.messageapp.model.SmsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST(" ")
        // API's endpoints

    Call<SmsModel> insertFood(@Field("messageName") String name);

    @FormUrlEncoded
    @POST(" ")
        // API's endpoints

    Call<SmsModel> deleteFood(@Field("messageId") int messageId);

 @FormUrlEncoded
    @POST(" ")
        // API's endpoints

    Call<GetMessage> getMessage(@Field("") int messageId);


}
