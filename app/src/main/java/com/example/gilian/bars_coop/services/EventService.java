package com.example.gilian.bars_coop.services;

import com.example.gilian.bars_coop.Entity.Establishment;
import com.example.gilian.bars_coop.Entity.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by gilian on 30/08/2017.
 */

public interface EventService {


    public static final String ENDPOINT_LOCAL = "http://localhost:8888/git/api_EverydayDrinking/web";
    public static final String ENDPOINT_SERVER = "http://192.168.1.254/git/api_EverydayDrinking/web";

    @GET("events")
    Call<List<Event>> getEvents(@Header("Authorization")String authHeader);

    @GET("event/{id}")
    Call<Event> getEvent(@Header("Authorization")String authHeader, @Path("id") int id);

    @FormUrlEncoded
    @POST("event")
    Call<Event> addEvent(@Header("Authorization")String authHeader,
                            @Field("name") String name,
                            @Field("establishment")int establishment);
    @FormUrlEncoded
    @PUT("event/{id}")
    Call<Event> editEvent(@Header("Authorization")String authHeader,
                             @Path("id") int id,
                             @Field("name") String name,
                             @Field("establishment")int establishment);


}
