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
    public String getNameofContact(){
        return IndividualChatPerson.getName();
    }
}
