package com.example.chatapp.webServiceAPI;

import androidx.room.Delete;


import com.example.chatapp.objects.Contact;
import com.example.chatapp.objects.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServiceAPI {
    @GET("uesr")
    Call<List<User>> getUsers();

    @GET("uesr/{id}")
    Call<List<User>> getUser(@Path("id") String id);

    @POST("user")
    Call<Void> createUser(@Body User user);

    @DELETE("user/{id}")
    Call<Void> deleteUser(@Path("id") String id);

    @GET("contacts")
    Call<List<Contact>> getContacts(@Query("user") String usr);

    @GET("contacts/{contact}/messages?user={id}")
    Call<List<Contact>> getChat(@Path("id") String id, @Path("contact") String Contact);

    @POST("contacts/{contact}/messagrs?user={id}")
    Call<Void> addMsg(@Path("id") String id, @Path("contact") String contact);

    @POST("contacts")
    Call<Void> addContact(@Query("user") String userID, @Body Contact contact);


}
