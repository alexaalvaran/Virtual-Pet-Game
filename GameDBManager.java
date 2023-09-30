/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author alei
 */
public class GameDBManager 
{
    
    private PetGameDBManager dbManager;
    private Connection conn;
    private Statement statement;

    public GameDBManager() {
        dbManager = new PetGameDBManager();
        conn = dbManager.getConnection();

        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    public boolean findExistingPlayer(String playerName)
    {
        boolean found = false;
        
       try
       {
      ResultSet rs = statement.executeQuery( "SELECT PLAYER_NAME FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");
      if(rs.next())
      {
          System.out.println("Welcome back");
          found = true;
      }
      else
      {
          System.out.println("No existing player");
      }
       
       }catch(SQLException ex)
       {
           System.out.println(ex.getMessage());
       }
       
     return found;
    }
    
    public void newPlayer(String playerName)
    {
        try
        {  
        statement.executeUpdate("INSERT INTO SAVEDGAMES (PLAYER_NAME) VALUES(" + playerName + ")");
        
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void newPet(String petName)
    {
        try
        {
        
        statement.executeUpdate("INSERT INTO SAVEDGAMES (PET_NAME) VALUES(" + petName + ")");
        
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void saveGame(String playerName, String petName, int hunger, int thirst,
            int energy, int hygiene, int happiness,int friendship)
    {
        
    }
    
    {
        
    }

    
    public void closeConnections()
    {
        this.dbManager.closeConnections();
    }
    
}
