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
import com.model.User;
import com.util.DBConnection;

public class userDAO {
    private Connection connection;
    
    public userDAO() throws ClassNotFoundException{
        connection = DBConnection.getConnection();
    }
    
    public void addUser(User user) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (userid, firstname, lastname) VALUES (?,?,?)");
            preparedStatement.setString(1, user.getUserid());
            preparedStatement.setString(2, user.getFirstname());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
        
     public void deleteUser(String userid){
         try{
             PreparedStatement preparedStatement = connection.prepareStatement("delete from users where userid=?");
             preparedStatement.setString(1, userid);
             preparedStatement.executeUpdate();
         }
         catch(SQLException e){
             e.printStackTrace();
         }    
    }
     
     public void updateUser(User user){
         try{
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET firstname=?, lastname=? WHERE userid = ?");
             preparedStatement.setString(1, user.getFirstname());
             preparedStatement.setString(2, user.getLastname());
             preparedStatement.setString(3, user.getUserid());
             preparedStatement.executeUpdate();
         }
         catch(SQLException e){
             e.printStackTrace();
         }
     }
     
     public List<User> getAllUsers(){
         List<User> users =  new ArrayList<User>();
         try{
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM users");
             while (rs.next()) {
                 User user = new User();
                 user.setUserid(rs.getString("userid"));
                 user.setFirstname(rs.getString("firstname"));
                 user.setLastname(rs.getString("lastname"));
                 users.add(user);
             }
         }
         catch(SQLException e){
             e.printStackTrace();  
         }
         return users;
     }
     
     public User getUserById(String userid){
         User user = new User();
         try{
             
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE userid = ?");
             preparedStatement.setString(1, userid);
             ResultSet rs = preparedStatement.executeQuery();
             
             while(rs.next()){
                 user.setUserid(rs.getString("userid"));
                 user.setFirstname(rs.getString("firstname"));
                 user.setLastname(rs.getString("lastname"));
             }
         }
         catch (SQLException e){
             e.printStackTrace();
         }
         return user;
     }
     
     
}
