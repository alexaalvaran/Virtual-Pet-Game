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
public class GameDBManager {

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

    public boolean findExistingPlayer(String playerName) {
        boolean found = false;

        try {
            ResultSet rs = statement.executeQuery("SELECT PLAYER_NAME FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");
            if (rs.next()) {
                System.out.println("Welcome back");
                found = true;
            } else {
                System.out.println("No existing player");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return found;
    }

    public void newPlayer(String playerName) {
        try {
            statement.executeUpdate("INSERT INTO SAVEDGAMES (PLAYER_NAME) VALUES(" + playerName + ")");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void newPet(String petName) {
        try {

            statement.executeUpdate("INSERT INTO SAVEDGAMES (PET_NAME) VALUES(" + petName + ")");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveGame(String playerName, String petName, int hunger, int thirst,
            int energy, int hygiene, int happiness, int friendship) {
        try {
            statement.executeUpdate("UPDATE SAVEDGAMES SET hunger = " + hunger + ", thirst = " + thirst + ", energy = " + energy + ", hygiene = " + hygiene + ", happiness = " + happiness + ", friendship = " + friendship + " WHERE PLAYER_NAME = '" + playerName + "' AND PET_NAME = '" + petName + "'");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   
    //Loading saved stats from existing game
    public int loadHunger(String playerName, String petName) {
        int hunger = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT HUNGER FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "' AND PET_NAME = '" + petName + "'");

            if (rs.next()) {
                hunger = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return hunger;
    }

    public int loadThirst(String playerName, String petName) {
        int thirst = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT THIRST FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "' AND PET_NAME = '" + petName + "'");

            if (rs.next()) {
                thirst = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return thirst;
    }

    public int loadEnergy(String playerName, String petName) {
        int energy = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT ENERGY FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "' AND PET_NAME = '" + petName + "' ");

            if (rs.next()) {
                energy = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return energy;
    }

    public int loadHygiene(String playerName, String petName) {
        int hygiene = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT HYGIENE FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "' AND PET_NAME = '" + petName + "' ");

            if (rs.next()) {
                hygiene = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return hygiene;
    }

    public int loadHappiness(String playerName, String petName) {
        int happiness = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT HAPPINESS FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "' AND PET_NAME = '" + petName + "' ");

            if (rs.next()) {
                happiness = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return happiness;
    }

    public int loadFriendship(String playerName, String petName) {
        int friendship = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT FRIENDSHIP FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "' AND PET_NAME = '" + petName + "' ");

            if (rs.next()) {
                friendship = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return friendship;
    }
    
    public String getExistingPetName(String playerName)
    {
        String petName = "";
        try
        {
            ResultSet rs = statement.executeQuery("SELECT PET_NAME FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");
            
            if(rs.next())
            {
                petName = rs.getString(1);
            }
            
         
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return petName;
        
    }

    public void closeConnections() {
        this.dbManager.closeConnections();
    }
    
    

}
