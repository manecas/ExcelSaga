/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class User {
    
    private int id;
    private String name;
    private List<MyFile> pathToRecentFiles;
    
    public User() {
        this.pathToRecentFiles = new ArrayList<>();
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.pathToRecentFiles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyFile> getPathToRecentFiles() {
        return pathToRecentFiles;
    }

    public void setPathToRecentFiles(List<MyFile> pathToRecentFiles) {
        this.pathToRecentFiles = pathToRecentFiles;
    }

    public String toStringFiles(){
        String s = "";
        
        for (MyFile file : pathToRecentFiles) {
            s += file.getOpenedDate()+ "  " + file.getPath() + "\n";
        }
        
        return s;
    }
    
    @Override
    public String toString() {
        return id + "\n" + name + "\n" + pathToRecentFiles.toString() + "\n";
    }
    
    public int create(){
        int result = -1;
        
        try {
            
            Connection conn = Session.getInstance().getConnection();
            
            String insertQuery =
                    "INSERT INTO USER " +
                    "(NAME) " +
                    "VALUES(?)";
            
            PreparedStatement preparedS = conn.prepareStatement(insertQuery,
                    Statement.RETURN_GENERATED_KEYS);
            preparedS.setString(1, name);
            result = preparedS.executeUpdate();
            
            ResultSet resultSet = preparedS.getGeneratedKeys();
            
            if(resultSet.next()){
                id = resultSet.getInt(1);
                System.out.println("User with name: '" + name + "' added..");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public static List<User> readAllUsers(){
        
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        
        try {
            Connection conn = Session.getInstance().getConnection();
                
            String selectQuery = 
                    "SELECT * " +
                    "FROM USER ";
            
            PreparedStatement preparedS = conn.prepareStatement(selectQuery);
            resultSet = preparedS.executeQuery();
            
            while(resultSet.next()) {                
                users.add(new User(resultSet.getInt(1), resultSet.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }
    
    public static User read(String name){
        
        ResultSet resultSet = null;
        User user = null;
        
        try {
            
            Connection conn = Session.getInstance().getConnection();
                
            String selectQuery = 
                    "SELECT * " +
                    "FROM USER " +
                    "WHERE USER.NAME = ?";           
            
            PreparedStatement preparedS = conn.prepareStatement(selectQuery);
            preparedS.setString(1, name);
            resultSet = preparedS.executeQuery();
            
            if(resultSet.next()){
                user = new User(resultSet.getInt(1), resultSet.getString(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    public static User readWithFiles(String name){
        
        ResultSet resultSet = null;
        User user = null;
        
        try {
            
            Connection conn = Session.getInstance().getConnection();
                
            String selectQuery = 
                    "SELECT * " +
                    "FROM USER " +
                    "WHERE USER.NAME = ?";           
            
            PreparedStatement preparedS = conn.prepareStatement(selectQuery);
            preparedS.setString(1, name);
            resultSet = preparedS.executeQuery();
            
            if(resultSet.next()){
                user = new User(resultSet.getInt(1), resultSet.getString(2));
                user.setPathToRecentFiles(MyFile.readAllFilesFromId(user.getId()));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
}
