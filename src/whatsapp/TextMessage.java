/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

/**
 *
 * @author Mani
 */
public class TextMessage implements Message {
    private String textMessageText;
    public TextMessage(String messageToSend){
        this.textMessageText = messageToSend;
    }
}
