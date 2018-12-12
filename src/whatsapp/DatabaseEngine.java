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

import java.sql.*;
import java.util.ArrayList;


public class DatabaseEngine {
    private final String DATABASE_URL = "jdbc:mysql://localhost/whatsapp";;
    private final String USER = "whatsappAdmin";
    private final String PASSWORD = "1234";   


    private Connection connection;


    // Template Variables for the sql queries
    private PreparedStatement selectAllMessages = null; 
    private PreparedStatement insertNewBoarding = null; 
    private PreparedStatement deleteAllShoes = null;
     
    /**
     * DataBaseEngine constructor
     */
    public DatabaseEngine() {
        connectToDatabase();
    }
    
    
    /**
     * Connects the program to the database
     */
    private void connectToDatabase() {
        try {
            // Load the JDBC driver
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                System.out.println("Driver loaded");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Driver loaded");

            System.out.println("Establishing a Connection");
            connection = DriverManager.getConnection
            (  DATABASE_URL, USER, PASSWORD );
            System.out.println("Successful Connection");
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
    }

    ArrayList<Contact> getContacts(String contactNumber) {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        try {
            CallableStatement retrieveContacts = connection.prepareCall("{call retrieveContacts(?)}");
            //retrieveContact.
            retrieveContacts.setString(1,contactNumber);
            
            ResultSet results = retrieveContacts.executeQuery();
            ArrayList<String> contactNumberList = new ArrayList<String>();

            while (results.next()){
                java.sql.ResultSetMetaData rsmd = results.getMetaData();
                int numberOfColumns = rsmd.getColumnCount();
                for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
                    contactNumberList.add((results.getString(columnIndex)));
                }
                System.out.println(contactNumberList);
                
                for(String i:contactNumberList) {
                    contactList.add(addAdditionalContactInfo(i));
                }
            }
        } catch(SQLException E) {
            E.printStackTrace();
        }
        return contactList;
    }
    
    Contact addAdditionalContactInfo(String contactNumber){
        Contact contactInfo;
        try {
            CallableStatement retrieveContactInfo = connection.prepareCall("{call getContactInfo(?)}");
            retrieveContactInfo.setString(1, contactNumber);
            /**
             * registerOutputParameter returns as output the 
             *  1)  Phone Number
             *  2)  Name
             *  3)  Status i.e. Description
             *  4)  OnlineStatus
             * 
             */
            
            retrieveContactInfo.registerOutParameter(2, Types.VARCHAR);
            retrieveContactInfo.registerOutParameter(3, Types.VARCHAR);
            retrieveContactInfo.registerOutParameter(4, Types.BOOLEAN);
            
            retrieveContactInfo.executeQuery();
            
            contactInfo = new Contact(
                    contactNumber,
                    retrieveContactInfo.getString(2), 
                    retrieveContactInfo.getString(3), 
                    retrieveContactInfo.getBoolean(4)
                    
                ); 
            return contactInfo;
        }
        catch(Exception E) {
            return null;
        }
    }

    /**
     * getUpdatedChatList
     */
    
    public ArrayList<IndividualChat> getUpdatedIndividualChatList(String i) {
        // TODO  implement this function
        
        return null;
    }
    public ArrayList<GroupChat> getUpdatedGroupChatList(String i) {
        // TODO  implement this function
        return null;
    }    
    
    
    
    public ArrayList<IndividualChat> synchronizeIndividualChats(ArrayList<IndividualChat> chatList) {
        Contact contactInfo;
        try {
            CallableStatement retrieveContactInfo = connection.prepareCall("{call syncChat(?)}");
            
            //retrieveContactInfo.setString(1, chatList.get(i));
        } catch (Exception E) {
        }
        
        return null;
    } 
    
    
    /**
     *  Adding or removing a contact from a user's contactList
     *  
     */
    public boolean addContact (Person user, Person contact) {
        
        try {
            CallableStatement addToContactList = connection.prepareCall("{call addToContactList(?, ?)}");
            addToContactList.setString(1, user.getPhoneNumber());
            addToContactList.setString(2, contact.getPhoneNumber());
            
            addToContactList.executeQuery();
            
            return true;

        } catch(SQLException E) {
         //   E.printStackTrace();
        }
        
        return false;
    }
    
    
    /**
     * Adding a new user to the database 
     */
    public boolean addUser (Person user) {
         try {
            CallableStatement addToUserList = connection.prepareCall("{call addToUserList(?, ?, ?)}");
            addToUserList.setString(1, user.getPhoneNumber());
            addToUserList.setString(2, user.getName());
            addToUserList.setString(3, user.getStaus());
            
            addToUserList.executeQuery();
            
            return true;

        } catch(SQLException E) {
            //E.printStackTrace();
        }
        return false;
    }   
    
    /**
     * closes the databases
     */     
    public void close() {
       try 
       {
          connection.close();
       } 
       catch ( SQLException sqlException )
       {
          sqlException.printStackTrace();
       } 
    } 
}
