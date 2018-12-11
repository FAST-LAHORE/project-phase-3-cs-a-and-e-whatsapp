/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.util.Date;
/**
 *
 * @author Mani
 */
public class MessageDescription {
    private Message MessageDescriptionMessage;
    private Date MessageDescriptionTime;
    private int MessageDescriptionID;
    private Person MessageDescriptionSender;
    public MessageDescription(Person sender,Message messageToStore,Date timeOfSending,int id){
        this.MessageDescriptionMessage = messageToStore;
        this.MessageDescriptionTime = timeOfSending;
        this.MessageDescriptionID = id;
        this.MessageDescriptionSender = sender;
    }
    public Person getSender(){
        return this.MessageDescriptionSender;
    }
    public int getMessageID(){
        return this.MessageDescriptionID;
    }
    public Date getDate(){
        return this.MessageDescriptionTime;
    }
}
