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
public class GroupChat implements Chat{
    private ArrayList<Person> groupChatGroupMembers;
    //constructor
    GroupChat(){
        
    }
    //@override
    public String getNameofContact(){
        
        return null;
    }
    public ArrayList<Person> getPersonsInGroup(){
    
        return null;
    }
}
