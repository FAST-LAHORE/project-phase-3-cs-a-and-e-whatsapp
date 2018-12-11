/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

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
        DatabaseEngine databaseObject = new DatabaseEngine();
        ContactList lissss = new ContactList();
        Person user = new User("03012308193","","",false);
        lissss.load(databaseObject, user);
    }
    
}
