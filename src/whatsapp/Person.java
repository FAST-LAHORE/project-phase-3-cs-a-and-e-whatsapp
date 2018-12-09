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
    private String personStatus;
    private boolean personOnline ;
    private BufferedImage userProfilePicture;

    
    //Constructors
    public Person(int pPN, String pN, String personStatus, boolean personOnline,  String userProfilePictureDir)throws java.io.IOException{
        this.personPhoneNumber=personPhoneNumber;
        this.personName=personName;
        this.personStatus=personStatus;
        this.personOnline=personOnline;
        this.userProfilePicture = ImageIO.read(new File(userProfilePictureDir + ".png"));
    }
    public Person(int pPN, String pN, String personStatus, boolean personOnline,  BufferedImage userProfilePicture)throws java.io.IOException{
        this.personPhoneNumber=personPhoneNumber;
        this.personName=personName;
        this.personStatus=personStatus;
        this.personOnline=personOnline;
        this.userProfilePicture = ImageIO.read(new File(userProfilePicture + ".png"));
    }
    //Getters
    
    int getPhoneNumber(){
        return this.personPhoneNumber;
    }
    String getName(){
        return this.personName;
    }
    String getStaus(){
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
    public void setStatus(String personStatus){
        this.personStatus=personStatus;
    }  
    
}
