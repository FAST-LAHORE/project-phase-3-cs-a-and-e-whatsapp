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
        setUpPreparedSQLStatements();
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

    /**
     * TODO : Change this !
     * Template Functions for the queries 
     * sets the sql statements
     */
    public void setUpPreparedSQLStatements() {
        try {
            // CHANGE THIS !!
            selectAllMessages = 
            connection.prepareStatement( 
                    "SELECT pass_no, car_no , status , status_code  from Messages WHERE mID = ?" );

           insertNewBoarding = connection.prepareStatement( 
            "INSERT INTO boardinglog " + 
            "( pass_no, car_no , status, status_code) " + 
            "VALUES ( ?, ?, ? , 0)" );
           
           deleteAllShoes = connection.prepareStatement(
            "TRUNCATE table Messages");    
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
    }

    
    /**
     * loads the data from the boardinglog table
     * @param sc
     * @return 
     */
    public ArrayList<Message> getBoardings(int messageID) {
        ResultSet resultSet = null;
        ArrayList<Message> results = new ArrayList<Message>();
        try {
            selectAllMessages.setInt( 1, messageID);
            
            resultSet = selectAllMessages.executeQuery(); 

            int i=0;
            while(resultSet.next()){
                String s = resultSet.getString( "pass_no" );
                int s2 = resultSet.getInt("car_no" );
                String s3 = resultSet.getString( "status" );
            //    BoardingQueue bq = null; 
            //    results[i] = new Passenger(s, bq , "", s3 , s2);
                i++;
            }
        }
        
        catch ( SQLException sqlException )  {

        } 
        finally {
            try {
                resultSet.close();
            } 
            catch ( SQLException sqlException )  {
                sqlException.printStackTrace();         
                close();
            } 
        } 
        return results;
    } 
    


        /**
        * adds the boardings to the boarding log table
        * @param name
        * @param carNo
        * @param status
        * @return 
        */ 
//    public int addPassenger( String name, int carNo, String status )
//    {
//
//        int result = 0;
//
//        try   {
//            insertNewBoarding.setString( 1, name );
//            insertNewBoarding.setInt( 2, carNo);
//            insertNewBoarding.setString( 3, status  );
//            result = insertNewBoarding.executeUpdate(); 
//        } 
//        catch ( SQLException sqlException ) {
//         //sqlException.printStackTrace();
//         System.out.println("Passenger Already Exist");
//        } 
//        catch ( Exception dsql ){
//          //System.out.println("Shoe " + id + " Already Exists - not added" );
//        }
//        return result;
//
//    } 
//    /**
//     * deletes all the data in the boardinglog table
//     * @return 
//     */
//    public int deleteAllBoardings()
//    {
//        int result = 0;
//        try {
//            result = deleteAllShoes.executeUpdate(); 
//        } 
//        catch ( SQLException sqlException ) {
//            sqlException.printStackTrace();
//            close();
//        }  
//        return result;
//    } 

   
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