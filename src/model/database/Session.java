/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class Session {
    
    private static Session instance;
    private Connection connection;
    private User user;

    private Session() {
        try {
            Class.forName("org.h2.Driver");
            
            //user:sa pass:""
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized Session getInstance() {
        
        if(instance == null){
            instance = new Session();
        }
        
        return instance;
        
    }
    
    public Connection getConnection(){
        return connection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
