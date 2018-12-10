/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author wj
 */
public class User extends Person{
    
    //Attributes
    
    //Constructors
    
    public User(int personPhoneNumber, String personName, String personStatus,boolean personOnline){
        super(personPhoneNumber,personName,personStatus,personOnline);
        
    }
    //Functions
    public void changeStatus(String personStatus){
        super.setStatus(personStatus);
    }
    public void changeName(String personName){
        super.setName(personName);
    }
    public void changeProfilePicture(String userProfilePictureDir) throws java.io.IOException{
       
        super.setProfilePicture(ImageIO.read(new File(userProfilePictureDir))); 
    }
}
