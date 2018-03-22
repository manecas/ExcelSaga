/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class DatabaseHelper {
    
    public static void createTables(){
        dropTables();
        createUserTable();
        createFileTable();
        createUsesTable();
    }
    
    private static void dropTables(){
        
        try{
            Statement statement = Session.getInstance()
                       .getConnection()
                       .createStatement();

            String dropUsesQuery = "drop table if exists USES";
            String dropUserQuery = "drop table if exists USER";
            String dropFileQuery = "drop table if exists FILE";

            statement.executeUpdate(dropUsesQuery);
            statement.executeUpdate(dropUserQuery);
            statement.executeUpdate(dropFileQuery);   
        }catch(SQLException ex){
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private static void createUserTable(){
        try {
            Statement statement = Session.getInstance()
                    .getConnection()
                    .createStatement();
            
            String createUserQuery = 
                    "create table USER " +
                    "("+
                        "ID_USER INTEGER not null AUTO_INCREMENT UNIQUE, " +
                        "NAME VARCHAR2(255) not null, " +
                        "constraint PK_USER primary key (ID_USER)" +
                    ")";
                    
            statement.executeUpdate(createUserQuery);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    
    private static void createFileTable(){
        try {
            Statement statement = Session.getInstance()
                    .getConnection()
                    .createStatement();
            
            String createFileQuery = 
                    "create table FILE " +
                    "("+
                        "ID_FILE INTEGER not null AUTO_INCREMENT, " +
                        "PATH VARCHAR2(255) not null, " +
                        "OPEN_DATE TIMESTAMP not null, " +
                        "constraint PK_FILE primary key (ID_FILE)" +
                    ")";
                    
            statement.executeUpdate(createFileQuery);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    
    private static void createUsesTable(){
        try {
            Statement statement = Session.getInstance()
                    .getConnection()
                    .createStatement();
            
            String createUsesQuery = 
                    "create table USES " +
                    "("+
                        "ID_USES INTEGER not null AUTO_INCREMENT, " +
                        "ID_USER INTEGER not null, "+
                        "ID_FILE INTEGER not null, "+
                        "constraint PK_USES primary key (ID_USES), "+
                        "constraint FK_USER foreign key (ID_USER) references USER (ID_USER), " +
                        "constraint FK_FILE foreign key (ID_FILE) references FILE (ID_FILE)" +
                    ")";
                    
            
            statement.executeUpdate(createUsesQuery);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    
}
