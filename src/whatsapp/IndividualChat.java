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
public class IndividualChat implements Chat {
    private Person IndividualChatPerson;
    public IndividualChat(Person toContact){
        IndividualChatPerson = toContact;
    } 
    public ArrayList<Person> getPersonsInGroup(){
        Person toAdd = IndividualChatPerson;
        ArrayList<Person> array = null;
        array.add(toAdd);
        return array;
    }
    public String getNameofContact(){
        return IndividualChatPerson.getName();
    }
}
