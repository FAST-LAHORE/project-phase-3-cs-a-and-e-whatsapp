/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.awt.image.BufferedImage;

/**
 *
 * @author wj
 */
public class Contact extends Person{
    
    //Constructors
    public Contact(int personPhoneNumber, String personName, String personStatus,
                    boolean personOnline)
                        throws java.io.IOException{
        super(personPhoneNumber,personName,personStatus,personOnline);
    }
    
    
}
