/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author alei
 */

//GameDBManager manages any interactions the game needs with the embedded data base
public class GameDBManager {

    //Variables
    private PetGameDBManager dbManager;
    private Connection conn;
    private Statement statement;

    //Default Constructor
    public GameDBManager() {
        dbManager = new PetGameDBManager();
        conn = dbManager.getConnection();

        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Checks if there is a player name in the database that matches the name passed to the function 
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

    //Checks if there is a pet name in the database that matches the name passed to the function
    public boolean findExistingPet(String petName) {
        boolean found = false;

        try {
            ResultSet rs = statement.executeQuery("SELECT PET_NAME FROM SAVEDGAMES WHERE PET_NAME ='" + petName + "'");
            if (rs.next()) {
                System.out.println("Existing pet");
                found = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return found;
    }

    //Writes a new player to the database
    public void newPlayer(String playerName) {
        try {
            statement.executeUpdate("INSERT INTO SAVEDGAMES (PLAYER_NAME) VALUES(" + playerName + ")");
            System.out.println("new player added");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Write a new pet to the database
    public void newPet(String petName) {
        try {

            statement.executeUpdate("INSERT INTO SAVEDGAMES (PET_NAME) VALUES(" + petName + ")");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Writes the stats to the database
    public void saveGame(String playerName, String petName, int hunger, int thirst,
            int energy, int hygiene, int happiness, int friendship) {
        try {
            statement.executeUpdate("UPDATE SAVEDGAMES SET hunger = " + hunger + ", thirst = " + thirst + ", energy = " + energy + ", hygiene = " + hygiene + ", happiness = " + happiness + ", friendship = " + friendship + " WHERE PLAYER_NAME = '" + playerName + "' AND PET_NAME = '" + petName + "'");
            System.out.println("Game saved! See you soon :)");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Loading saved stats from existing game
    
    public int loadHunger(String playerName) {
        int hunger = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT HUNGER FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");

            if (rs.next()) {
                hunger = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return hunger;
    }

    public int loadThirst(String playerName) {
        int thirst = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT THIRST FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");

            if (rs.next()) {
                thirst = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return thirst;
    }

    public int loadEnergy(String playerName) {
        int energy = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT ENERGY FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");

            if (rs.next()) {
                energy = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return energy;
    }

    public int loadHygiene(String playerName) {
        int hygiene = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT HYGIENE FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");

            if (rs.next()) {
                hygiene = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return hygiene;
    }

    public int loadHappiness(String playerName) {
        int happiness = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT HAPPINESS FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");

            if (rs.next()) {
                happiness = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return happiness;
    }

    public int loadFriendship(String playerName) {
        int friendship = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT FRIENDSHIP FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");

            if (rs.next()) {
                friendship = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return friendship;
    }

    //Return the petName from the database
    public String getExistingPetName(String playerName) {
        String petName = "";
        try {
            ResultSet rs = statement.executeQuery("SELECT PET_NAME FROM SAVEDGAMES WHERE PLAYER_NAME = '" + playerName + "'");

            if (rs.next()) {
                petName = rs.getString(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return petName;

    }

    //Close the connection to the database
    public void closeConnections() {
        this.dbManager.closeConnections();
    }

}
