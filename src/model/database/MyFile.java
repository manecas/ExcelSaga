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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class MyFile {
    
    private int id;
    private String path;
    private Timestamp openDate;

    public MyFile() {
    }

    public MyFile(int id, String path, Timestamp openDate) {
        this.id = id;
        this.path = path;
        this.openDate = openDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getOpenedDate() {
        return openDate;
    }

    public void setOpenedDate(Timestamp openedDate) {
        this.openDate = openedDate;
    }

    @Override
    public String toString() {
        return id + "\n" + path + "\n" + openDate + "\n";
    }

    public int create(){
        int result = -1;
        
        try {
            Connection conn = Session.getInstance().getConnection();
            
            String insertQuery =
                    "INSERT INTO FILE " +
                    "(PATH, OPEN_DATE) " +
                    "VALUES(?,?)";
            
            PreparedStatement preparedS = conn.prepareStatement(insertQuery,
                    Statement.RETURN_GENERATED_KEYS);
            preparedS.setString(1, path);
            preparedS.setTimestamp(2, openDate);
            result = preparedS.executeUpdate();
            
            ResultSet resultSet = preparedS.getGeneratedKeys();
            
            if(resultSet.next()){
                id = resultSet.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public static int createUses(int idUser, int idFile){
        int result = -1;
        
        try {
            Connection conn = Session.getInstance().getConnection();
            
            String insertQuery =
                    "INSERT INTO USES " +
                    "(ID_USER, ID_FILE) " +
                    "VALUES(?,?)";
            
            PreparedStatement preparedS = conn.prepareStatement(insertQuery,
                    Statement.RETURN_GENERATED_KEYS);
            preparedS.setInt(1, idUser);
            preparedS.setInt(2, idFile);
            result = preparedS.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public static List<MyFile> readAllFiles(){
        
        List<MyFile> files = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            Connection conn = Session.getInstance().getConnection();
                
            String selectQuery = 
                    "SELECT * " +
                    "FROM FILE ";          
            
            PreparedStatement preparedS = conn.prepareStatement(selectQuery);
            resultSet = preparedS.executeQuery();
            
            while(resultSet.next()){
                files.add(new MyFile(resultSet.getInt(1), 
                        resultSet.getString(2), resultSet.getTimestamp(3)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return files;
    }
    
    public static MyFile read(int idFile){
        
        ResultSet resultSet = null;
        MyFile file = null;
        
        try {
            Connection conn = Session.getInstance().getConnection();
                
            String selectQuery = 
                    "SELECT PATH, OPEN_DATE " +
                    "FROM FILE " +
                    "WHERE ID_FILE = ?";          
            
            PreparedStatement preparedS = conn.prepareStatement(selectQuery);
            preparedS.setInt(1, idFile);
            resultSet = preparedS.executeQuery();
            
            if(resultSet.next()){
                file = new MyFile();
                file.setPath(resultSet.getString(1));
                file.setOpenedDate(resultSet.getTimestamp(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return file;
    }
    
    public static List<MyFile> readAllFilesFromId(int userId){
        
        List<MyFile> files = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            
            Connection conn = Session.getInstance().getConnection();
                
            String selectQuery = 
                    "SELECT U.ID_FILE " +
                    "FROM USES U " +
                    "WHERE U.ID_USER = ?";   
            
            PreparedStatement preparedS = conn.prepareStatement(selectQuery);
            preparedS.setInt(1, userId);
            resultSet = preparedS.executeQuery();
            
            while(resultSet.next()){
                files.add(MyFile.read(resultSet.getInt(1)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return files;
    }
    
}
