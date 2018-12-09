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
    //constructor
    public GroupChat(int groupIdToAssign){
        super();
        this.groupID = groupIdToAssign;
        this.groupChatGroupMembers = new ArrayList<Person>();
    }
    public GroupChat(int groupIdToAssign,ArrayList<Person> personsToAdd){
        super();
        this.groupID = groupIdToAssign;
        this.groupChatGroupMembers = new ArrayList<Person>();
        this.groupChatGroupMembers.addAll(personsToAdd);
    }
    public int getGroupID(){
        return groupID;
    }
    public boolean addMemberInGroup(Person personToAdd){
        boolean toReturn = false;
        if (groupChatGroupMembers.add(personToAdd)){
            toReturn = true;
        }
        return toReturn;
    }
    public ArrayList<Person> getPersonsInGroup(){
        return this.groupChatGroupMembers;
    }
}
