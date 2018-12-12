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
public class Whatsapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO Running the main JFrame here
        // MainPage thePage = new MainPage();
        
        
        /**
         * Database Testing !! DO NOT TOUCH
         */
        DatabaseEngine databaseObject = new DatabaseEngine();
        
        /**
         * Users are being added
         */
        Person user = new User("03012308193","Wahaj","",false);
        Person contact = new User("03012308192","Mani","",false);
        databaseObject.addUser(user);
        databaseObject.addUser(contact);
        
        /**
         * So are contacts
         */
        databaseObject.addContact(user, contact);
        
        // Contact list is also being retrieved 
        
        ArrayList<Contact> list = databaseObject.getContacts("03012308193");
        System.out.println(list.get(0).toString());
        ContactList lissss = new ContactList();
        lissss.load(databaseObject, user);
        
        
        /**
         * 
         * CAUTION
         * 
         */
    }
    
}
