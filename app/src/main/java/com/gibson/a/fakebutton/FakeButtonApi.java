package com.gibson.a.fakebutton;

import com.gibson.a.fakebutton.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Asia on 3/5/2018.
 */

public interface FakeButtonApi {

    //root url
    String BASE_URL = "http://fake-button.herokuapp.com";

    @POST("/user")
    Call<User> createUser(@Body User userCreated);

    @GET("/user")
    Call<List<User>>getUser(@Query("candidate")String candidate);

//    @GET("/user")
//    Call<List<User>>getUser();



}
