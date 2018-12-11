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
public class Services {
    ChatList serviceUserChats;
    CallList serviceCallLog;
    ContactList serviceContactList;
    
    
    Services() {
        serviceUserChats = new ChatList();
        serviceCallLog = new CallList();
        serviceContactList = new ContactList();
    }
    int refresh(DatabaseEngine databaseObject , User myself, ContactList contactList ) {
        try {
            serviceUserChats.load(databaseObject, myself);
            serviceCallLog.load(databaseObject);
            serviceContactList.load(databaseObject,myself);
        } catch(Exception E){
            return -1;
        }
        return 1;
    }
    ChatList getChatList() {
        return serviceUserChats;
    }
    CallList getCallList() {
        return serviceCallLog;
    }
    
}
