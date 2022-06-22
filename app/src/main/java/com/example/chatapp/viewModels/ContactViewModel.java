package com.example.chatapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.repository.ContactRepository;
import com.example.chatapp.room.Contact;

import java.util.List;


public class ContactViewModel extends ViewModel {
    private LiveData<List<Contact>> contactLiveData;
    private MutableLiveData<Contact> contactLV;
    private ContactRepository contactRepository;
    private String userId;
    private Contact returnedContact;

    public ContactViewModel(){
        userId = LoggedInUsr.getLoggedInUsr().getLoggedin();
        contactRepository = new ContactRepository(userId);
        contactLiveData = contactRepository.getAll();

    }

    public LiveData<List<Contact>> getAll() {
        return contactRepository.getAll();
    }

    public void getContactById(String id){
        contactRepository.get(id);
    }

    public void add(Contact contact) {
        contactRepository.add(contact);
    }

    public void reload() {
        contactRepository.reload();
    }

    public MutableLiveData<Contact> getContactByName(String name) {
        contactLV.postValue(contactRepository.getContactByName(name));
        return contactLV;
    }

}
