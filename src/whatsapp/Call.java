/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.util.*;

/**
 *
 * @author wj
 */
public class Call {
    
    Person callSender;
    Person callReceiver;
    Date callStartTime;
    long callDuration;
    
    /* 
        The constructor takes as its arguments two Person objects, the person
        initiating the call and the person receiving the call
    */
    public Call(Person personCalling , Person personToCall ) {
        this.callReceiver = personToCall;
        this.callSender = personCalling;
    }
    public void startCall() {
        callStartTime = new Date();
    }
    public long getDuration() {
        return callDuration;
    }
}
