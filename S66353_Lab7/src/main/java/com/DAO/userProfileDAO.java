/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import com.model.userProfile;
import com.util.DBConnection;

public class userProfileDAO {
    private Connection connection;
    
    public userProfileDAO() throws ClassNotFoundException{
        connection = DBConnection.getConnection();
    }
    
     public void addUser(userProfile userp) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userProfiles (username, icno, firstname) VALUES (?,?,?)");
            preparedStatement.setString(1, userp.getUsername());
            preparedStatement.setString(2, userp.getIcno());
            preparedStatement.setString(3, userp.getFirstname());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
     public List<userProfile> getAllUsers(){
         List<userProfile> userp =  new ArrayList<userProfile>();
         try{
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("select * from userprofiles");
             while (rs.next()) {
                 userProfile user = new userProfile();
                 user.setUsername(rs.getString("username"));
                 user.setIcno(rs.getString("icno"));
                 user.setFirstname(rs.getString("firstname"));
                 userp.add(user);
             }
         }
         catch(SQLException e){
             e.printStackTrace();  
         }
         return userp;
     }
     
     
}
