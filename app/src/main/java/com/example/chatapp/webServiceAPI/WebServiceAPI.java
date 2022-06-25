package com.example.chatapp.webServiceAPI;

import android.media.session.MediaSession;

import com.example.chatapp.objects.AddContactData;
import com.example.chatapp.objects.InvitationData;
import com.example.chatapp.objects.TransferData;
import com.example.chatapp.objects.tokenData;
import com.example.chatapp.room.User;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.Msg;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServiceAPI {
    // ---------- Users -----------
    @GET("users/")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    Call<User> getUser(@Path("id") String id);

    @POST("users/")
    Call<Void> createUser(@Body User user);

    // ---------- contacts -----------

    @GET("{userName}/contacts/")
    Call<List<Contact>> getContacts(@Path("userName") String userName);

    @GET("{userName}/contacts/{id}")
    Call<Contact> getContact(@Path("userName") String userName, @Path("id") String id);

    @POST("{userName}/contacts")
    Call<Void> addContact(@Path("userName") String userName, @Body AddContactData data);

    @POST("invitations/")
    Call<Void> invite(@Body InvitationData data);

    // ---------- messages -----------

    @GET("{userId}/contacts/{id}/messages/")
    Call<List<Msg>> getMessages(@Path("userId") String userId, @Path("id") String id);

    @GET("{userId}/contacts/{id}/messages/{msgId}")
    Call<Msg> getMsg(@Path("userId") String userId, @Path("id") String id, @Path("msgId") int msgId);

    @POST("{userId}/contacts/{id}/messages/")
    Call<Void> addMsg(@Path("userId") String userId, @Path("id") String id, @Body String content);

    @POST("transfer/")
    Call<Void> transferMsg(@Body TransferData data);

    ////// ------- token ------
    @POST("firebaseToken/")
    Call<Void> createToken(@Body tokenData td);

}

