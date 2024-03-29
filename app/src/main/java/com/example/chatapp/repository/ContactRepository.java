package com.example.chatapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.chatapp.MyApplication;
import com.example.chatapp.room.AppDB;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.ContactDao;
import com.example.chatapp.webServiceAPI.ContactsAPI;
import java.util.List;

public class ContactRepository {
    private ContactDao contactDao;
    private ContactListData contactListData;
    private ContactsAPI contactsAPI;
    private String userId;

    public ContactRepository(String userId){
        AppDB appDB = AppDB.getInstance(MyApplication.context);
        contactDao = appDB.contactDao();
        this.userId = userId;
        this.contactListData = new ContactListData();
        this.contactsAPI = new ContactsAPI(contactDao);

    }

    public class ContactListData extends MutableLiveData<List<Contact>>{

        public ContactListData(){
            super();
            contactDao.deleteAll();
            List<Contact> contactList = contactDao.index();
            setValue(contactList);
        }

        @Override
        protected void onActive() {
            super.onActive();

            contactListData.postValue(contactDao.index());
            new Thread(() -> {
                contactsAPI.getAllContacts(userId);
            }).start();
        }
    }
    public LiveData<List<Contact>> getAll(){

        reload();
        contactListData.postValue(contactDao.index());
        return contactListData;
    }

    public void get(String contactId){
       contactsAPI.getContact(userId, contactId);
    }

    public void add(Contact contact){
        contactsAPI.addContact(userId, contact);
        contactListData.postValue(contactDao.index());
    }


    public void reload(){
        contactsAPI.getAllContacts(userId);
    }

}