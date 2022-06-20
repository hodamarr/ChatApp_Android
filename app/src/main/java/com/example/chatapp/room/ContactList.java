package com.example.chatapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.chatapp.objects.Contact;
@Entity
public class ContactList {
    @PrimaryKey(autoGenerate=true)
    private Contact c;

    public ContactList(Contact c) {
        this.c = c;
    }

    public Contact getContact() {
        return c;
    }
}
