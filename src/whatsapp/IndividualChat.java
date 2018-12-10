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
public class IndividualChat extends Chat {
    private Person IndividualChatPerson;
    
    public IndividualChat(Person toContact){
        super();
        IndividualChatPerson = toContact;
    } 
    public Person getPerson(){
        return this.IndividualChatPerson;
    }
    public Person getReceiver(Person whoIsChecking,int messageID){
        Person toReturn = null;
        for (int i=0;i< chatConversation.size();i++){
            if (chatConversation.get(i).getMessageID()==messageID && chatConversation.get(i).getSender().getPhoneNumber()==whoIsChecking.getPhoneNumber()){
                toReturn = IndividualChatPerson;
                break;
            }
            if (chatConversation.get(i).getMessageID()==messageID && chatConversation.get(i).getSender().getPhoneNumber()==IndividualChatPerson.getPhoneNumber()){
                toReturn = whoIsChecking;
                break;
            }
        }
        return toReturn;
    }
    public String getNameofContact(){
        return IndividualChatPerson.getName();
    }
}
