/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author wj
 */
public class Person {
  //attributes
    private int personPhoneNumber;
    private String personName;
    private Status personStatus;
    private boolean personOnline ;
    private BufferedImage userProfilePicture;

    
    //Constructors
    public Person(int personPhoneNumber, String personName, Status personStatus,
                                                            boolean personOnline){
        this.personPhoneNumber=personPhoneNumber;
        this.personName=personName;
        this.personStatus=personStatus;
        this.personOnline=personOnline;
    }
    //Getters
    int getPhoneNumber(){
        return this.personPhoneNumber;
    }
    String getName(){
        return this.personName;
    }
    Status getStaus(){
        return this.personStatus;
    }
    BufferedImage getProfilePicture(){
        return this.userProfilePicture;
    }
    //Setters
    public void setPhoneNumber(int personPhoneNumber){
        this.personPhoneNumber=personPhoneNumber;
    }
    public void setName(String personName){
        this.personName=personName;
    }
    public void setStatus(Status personStatus){
        this.personStatus=personStatus;
    }  
    public void setProfilePicture(BufferedImage newImage){
        this.userProfilePicture=newImage;
    }
}
