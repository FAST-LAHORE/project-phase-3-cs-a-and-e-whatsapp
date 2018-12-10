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
public class GroupChat extends Chat{
    private int groupID;
    private ArrayList<Person> groupChatGroupMembers;
    private ArrayList<Integer> groupChatIndexOfAdmin;
    private int groupChatIndexOfCreator;
    //constructor
    public GroupChat(int groupIdToAssign,Person Creator){
        super();
        this.groupID = groupIdToAssign;
        this.groupChatGroupMembers = new ArrayList<Person>();
        this.groupChatGroupMembers.add(Creator);
        this.groupChatIndexOfCreator = 0;
        this.groupChatIndexOfAdmin = new ArrayList<Integer>();
    }
//    public GroupChat(int groupIdToAssign,ArrayList<Person> personsToAdd){
//        super();
//        this.groupID = groupIdToAssign;
//        this.groupChatGroupMembers = new ArrayList<Person>();
//        this.groupChatGroupMembers.addAll(personsToAdd);
//    }
    public int getGroupID(){
        return groupID;
    }
    public Person getCreator(){
        return this.groupChatGroupMembers.get(0);
    }
    public boolean isAdminIndex(int index){
        boolean toReturn = false;
        for(int i=0;i<this.groupChatIndexOfAdmin.size();i++){
            if(index == this.groupChatIndexOfAdmin.get(i)){
                toReturn = true;
            }
        }
        return toReturn;
    }
    public boolean isAdmin(Person personToCheck){
        boolean toReturn = false;
        for(int i=0;i<this.groupChatGroupMembers.size();i++){
            if (personToCheck.getPhoneNumber() == this.groupChatGroupMembers.get(i).getPhoneNumber()){
                if (isAdminIndex(i)){
                    toReturn =true;
                }
            }
        }
        return toReturn;
    }
    private int adminIndex(Person personToCheck){
        int toReturn = -1;
        for(int i=0;i<this.groupChatGroupMembers.size();i++){
            if (personToCheck.getPhoneNumber() == this.groupChatGroupMembers.get(i).getPhoneNumber()){
                if (isAdminIndex(i)){
                    toReturn =i;
                }
            }
        }
        return toReturn;
    }
    public boolean removeMember(Person removing,Person toRemove){
        boolean toReturn = false;
        if (getCreator().getPhoneNumber() != toRemove.getPhoneNumber()){
            if(isAdmin(toRemove)){
                if (getCreator().getPhoneNumber() == removing.getPhoneNumber()){
                    
                    toReturn = this.groupChatGroupMembers.remove(toRemove);
                    this.groupChatIndexOfAdmin.remove(adminIndex(toRemove));
                }
            }
            else {
                if (isAdmin(removing)){
                    toReturn = this.groupChatGroupMembers.remove(toRemove);
                }
            }
        }
        return toReturn;
    }
    public boolean addMemberInGroup(Person personToAdd){
        boolean toReturn = false;
        if (groupChatGroupMembers.add(personToAdd)){
            toReturn = true;
        }
        return toReturn;
    }
    public ArrayList<Person> getReceivers(int messageID){
        ArrayList<Person> toReturn = null;
        for (int i=0;i<chatConversation.size();i++){
            if(messageID == chatConversation.get(i).getMessageID()){
                 toReturn = new ArrayList<Person>(groupChatGroupMembers);
                toReturn.remove(chatConversation.get(i).getSender());
            }
        }
        return toReturn;
    }
    public ArrayList<Person> getPersonsInGroup(){
        return this.groupChatGroupMembers;
    }
}
