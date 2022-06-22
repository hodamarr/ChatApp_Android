package com.example.chatapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.chatapp.MyApplication;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.ContactDao;
import com.example.chatapp.room.MsgDao;
import com.example.chatapp.webServiceAPI.ContactsAPI;
import android.app.Application;
import android.content.Context;

import java.util.LinkedList;
import java.util.List;

public class ContactRepository {
    private ContactDao contactDao;
    private ContactListData contactListData;
    private ContactsAPI contactsAPI;
    private String userId;

    public ContactRepository(String userId){
        //// localDB db = singleton.
        AppDB appDB = AppDB.getInstance(MyApplication.context);
        contactDao = appDB.contactDao();
        this.userId = userId;
        this.contactListData = new ContactListData();
        this.contactsAPI = new ContactsAPI(contactListData, contactDao);

    }

    public class ContactListData extends MutableLiveData<List<Contact>>{

        public ContactListData(){
            super();
            ///maybe delete later
            List<Contact> contactList = contactDao.index(userId);
            setValue(contactList);
        }

        @Override
        protected void onActive() {
            super.onActive();

            contactListData.postValue(contactDao.index(userId));
            new Thread(() -> {
                contactsAPI.getAllContacts(userId);
            }).start();
        }
    }
    public LiveData<List<Contact>> getAll(){
        return contactListData;
    }

    public void get(String contactId){
       contactsAPI.getContact(userId, contactId);
    }

    public void add(Contact contact){
        contactDao.insert(contact);
        contactsAPI.addContact(userId, contact);
    }



    public void reload(Contact contact){
        contactsAPI.getAllContacts(userId);
    }

}