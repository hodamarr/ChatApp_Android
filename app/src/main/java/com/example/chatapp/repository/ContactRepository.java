package com.example.chatapp.repository;

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
            ///maybe delete later
            contactDao.insert(new Contact("Hod", "Amar", "1.2.3.4"));
            contactDao.insert(new Contact("Ofek", "Avergil", "1.2.3.4"));
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
        contactDao.insert(contact);
        contactsAPI.addContact(userId, contact);
        contactListData.postValue(contactDao.index());
    }

    public Contact getContactByName(String name) {
        List<Contact> lc =  contactDao.index();
        for (Contact c : lc){
            if (c.getName() == name){
                return c;
            }
        }
        return null;
    }

    public void reload(){
        contactsAPI.getAllContacts(userId);
    }

}