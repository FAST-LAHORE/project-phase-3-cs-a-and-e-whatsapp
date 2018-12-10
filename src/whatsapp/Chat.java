/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author wj
 */
public class Chat {
    protected ArrayList<MessageDescription> chatConversation;
    public Chat(){
        this.chatConversation = new ArrayList<MessageDescription>();
    }
    //add message in chat by a given person
    public Chat addMessage(Person sender,Message message,Date timeOfSending,int messageID){
        MessageDescription messageToAdd = new MessageDescription(sender, message, timeOfSending, messageID);
        chatConversation.add(messageToAdd);
        return this;
    }
    //to check if given person is sender of a specified message
    public boolean isSender(Person personToCheck,int messageID){
        boolean toReturn = false;
        for (int i=0;i<chatConversation.size();i++){
            if ((personToCheck.getPhoneNumber() == chatConversation.get(i).getSender().getPhoneNumber())&& (chatConversation.get(i).getMessageID() == messageID)){
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }
    //to delete a specific message by a person
    public boolean deleteMessage(Person whoWantsToDelete,int messageID){
        boolean toReturn = false;
        for (int i=0;i<chatConversation.size();i++){
            if ((whoWantsToDelete.getPhoneNumber() == chatConversation.get(i).getSender().getPhoneNumber())&& (chatConversation.get(i).getMessageID() == messageID)){
                this.chatConversation.remove(i);
                toReturn = true;
                break;
            }
        }
        
        return toReturn;
    }
}
