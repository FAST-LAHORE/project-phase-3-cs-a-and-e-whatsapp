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
public class ChatList {
    private ArrayList<Chat> chatListUserChats;
    
    //constructor
    public ChatList(){
        
    }
    //To add an element in chatList
    public Chat addPerson(Person personToAdd){
        boolean isAdded = true;
        Chat toReturn = null;
        toReturn = this.getChatOfPersonInGroup(personToAdd);
        if(toReturn == null){
            //Chat with this person is not initiated
            toReturn = new IndividualChat(personToAdd);
            chatListUserChats.add(toReturn);
        }
        return toReturn;
    }
    //To search for an element
    public boolean findElement(Chat objToFind){
        boolean isPresent = true;
        if (!chatListUserChats.contains(objToFind)){
            isPresent = false;
        }
        return isPresent;
    }
    //to get Chat of a person
    public Chat getChatOfPersonInGroup(Person personToFind){
        Chat toReturn = null;
        boolean personFound = false;
        for(int i=0;i<chatListUserChats.size()&&!personFound;i++){
            for (int j=0;j<chatListUserChats.get(i).getPersonsInGroup().size();j++){
                if ( chatListUserChats.get(i).getPersonsInGroup().get(j).getName().equals(personToFind.getName())){
                    personFound = true;
                    toReturn = chatListUserChats.get(i);
                    break;
                }
            }
        }

        return toReturn;
    }
    //deletes all messages for a given person
    public boolean deleteChat(Person personToDelete){
        boolean isDeleted = false;
        Chat chatToDelete;
        for (int i=0;i<chatListUserChats.size();i++){
            if(chatListUserChats.get(i).getNameofContact().equals(personToDelete)){
                if (chatListUserChats.remove(chatListUserChats.get(i))){
                    isDeleted = true;
                }
                break;
            }
        }
        return isDeleted;
    }
    //refreshs all chats from dataBase
    public boolean load(DBEngine myDatabase){
        //this.myDatabase.getUpdatedChatList();
        return true;
    }
    
}
