package com.example.chatapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.chatapp.repository.ContactRepository;
import com.example.chatapp.room.Contact;
import com.example.chatapp.room.Msg;

import java.util.List;


public class ContactViewModel extends ViewModel {
    private LiveData<List<Contact>> contactLiveData;
    private ContactRepository contactRepository;

    public ContactViewModel(String userId){
        contactRepository = new ContactRepository(userId);
        contactLiveData = contactRepository.getAll();
    }

    public LiveData<List<Contact>> get() {
        return contactLiveData;
    }

    public void add(Contact contact) {
        contactRepository.add(contact);
    }

//    public void reload() {
//        contactRepository.reload();
//    }

}
