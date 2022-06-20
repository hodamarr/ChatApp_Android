package com.example.chatapp.webService;

import android.telecom.Call;

import androidx.room.Query;

import com.example.chatapp.objects.Contact;
import com.example.chatapp.objects.User;

import java.util.List;

public interface ServiceAPI {

    ///// users-
    @GET("user")
    Call<List<User>> getUsers();

    @GET("user/{id}")
    Call<User> getUser(@Path("id") String id);

    @POST("user")
    Call<Void> addUser(@Body User u);

    @DELETE("user/{id}")
    Call<Void> deleteUser(@Path("id") String id);

    @GET("contacts")
    Call<List<Contact>> getContacts(@Query("users") String id);

    @GET("contacts/{contact}/messages?user={id}")
    Call<List<Contact>> getChat(@Path("id") String id, @Path("contact") String con);

    @POST("contacts/{contact}/messages?user={id}")
    Call<Void> addMsg(@Path("id") String id, @Path("contact") String contact, @Body String content);

    @Post("contacts")
    Call<Void> addContact(@Query("user") String usr, @Body Contact contact);



}
