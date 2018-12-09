/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsapp;

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
    
    //Constructors
    public Person(int pPN, String pN, String pS, boolean pO){
        this.personPhoneNumber=pPN;
        this.personName=pN;
        this.personStatus=pS;
        this.personOnline=pO;
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
    //
    
      
}
