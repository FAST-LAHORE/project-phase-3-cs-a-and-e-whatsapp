/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.util.ArrayList;

/**
 *
 * @author wj
 */
public class ContactList {
    ArrayList<Contact> contactList;
    public ContactList() {
        
    }
    public void load(DatabaseEngine databaseObject, Person user) {
        contactList = databaseObject.getContacts(user.getPhoneNumber());
    
    } 
}
