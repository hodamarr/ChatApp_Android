package com.example.chatapp.webServiceAPI;

import androidx.lifecycle.MutableLiveData;

import com.example.chatapp.MyApplication;
import com.example.chatapp.R;
import com.example.chatapp.objects.AddContactData;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.ContactDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsAPI {
    private Retrofit retrofit;
    private WebServiceAPI webServiceAPI;
    private ContactDao contactDao;

    public ContactsAPI(ContactDao contactDao){
        retrofit = new Retrofit.Builder().baseUrl(MyApplication.context.getString(R.string.BaseUrl)).
                addConverterFactory(GsonConverterFactory.create()).build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
        this.contactDao = contactDao;
        }


    public void getAllContacts(String userId){
        Call<List<Contact>> call = webServiceAPI.getContacts(userId);
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {

            new Thread(() -> {
                List<Contact> contactList = response.body();
                contactDao.deleteAll();
                contactDao.insertList(contactList);
            });
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
    }


    public void getContact(String userId, String contactId){
        Call<Contact> call = webServiceAPI.getContact(userId, contactId);
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                Contact c = response.body();
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

            }

        });
    }

    public void addContact(String userId, Contact newContact){
        AddContactData contactData = new AddContactData(newContact.getId(), newContact.getName(), newContact.getServer());
        Call<Void> call = webServiceAPI.addContact(userId, contactData);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }


}
