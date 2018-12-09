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
    private ArrayList<IndividualChat> chatListUserChats;
    private ArrayList<GroupChat> chatListGroupChats;
    
    //constructor
    public ChatList(){
        
    }
    //To add a Person in specific Group
    public GroupChat addPersonInGroup(Person personToAdd,int groupID){
        GroupChat toReturn = null;
        toReturn = this.getChatOfPersonInGroup(personToAdd,groupID);
        if(toReturn == null){
            //Group Chat with this person is not initiated
            toReturn = getChatOfGroup(groupID);
            if (toReturn == null){
                toReturn = new GroupChat(groupID);
            }
            toReturn.addMemberInGroup(personToAdd);
        }
        return toReturn;
    }
    //create Group with specified members and groupID
    public GroupChat createGroup(int groupID,ArrayList<Person> personsToAdd){
        GroupChat toReturn = null;
        toReturn = this.getChatOfGroup(groupID);
        if (!(toReturn == null)){
            toReturn = new GroupChat(groupID,personsToAdd);
        }
        return toReturn;
    }
    //to add Individual Chat of a person
    public IndividualChat addPersonIndividualy(Person personToAdd){
        IndividualChat toReturn = null;
        toReturn = this.getChatOfPersonIndividual(personToAdd);
        if (toReturn == null){
            toReturn = new IndividualChat(personToAdd);
        }
        return toReturn;
    }
    //to get groupChat for a specific group
    public GroupChat getChatOfGroup(int groupID){
        GroupChat toReturn = null;
        for (int i=0;i<chatListGroupChats.size();i++){
            if (chatListGroupChats.get(i).getGroupID() == groupID){
                toReturn = chatListGroupChats.get(i);
            }
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
    public GroupChat getChatOfPersonInGroup(Person personToFind,int groupID){
        GroupChat toReturn = null;
        boolean personFound = false;
        for(int i=0;i<chatListGroupChats.size()&&!personFound;i++){
            for (int j=0;j<chatListGroupChats.get(i).getPersonsInGroup().size();j++){
                if ( (chatListGroupChats.get(i).getGroupID() == groupID)&&chatListGroupChats.get(i).getPersonsInGroup().get(j).getName().equals(personToFind.getName())){
                    personFound = true;
                    toReturn = chatListGroupChats.get(i);
                    break;
                }
            }
        }

        return toReturn;
    }
        public IndividualChat getChatOfPersonIndividual(Person personToFind){
        IndividualChat toReturn = null;
        boolean personFound = false;
        for(int i=0;i<chatListUserChats.size()&&!personFound;i++){
                if (chatListUserChats.get(i).getPerson().getPhoneNumber()==(personToFind.getPhoneNumber())){
                    personFound = true;
                    toReturn = chatListUserChats.get(i);
                    break;
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
