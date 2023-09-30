/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alei
 */
public class PGCreateDBTables {

    private PetGameDBManager dbManager;
    private Connection conn;
    private Statement statement;

    public PGCreateDBTables() {
        dbManager = new PetGameDBManager();
        conn = dbManager.getConnection();

        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    //Creates savedGames table which stores player name, pet name and pet stats
    //Initializes table with 2 existing saved games for test purposes
    public void createSavedGamesTable()
    {
        try
        {
        String savedGamesTable = "CREATE TABLE SAVEDGAMES (PLAYER_NAME VARCHAR(15), PET_NAME VARCHAR(15),"
                + " HUNGER INT, THIRST INT, ENERGY INT, HYGIENE INT, HAPPINESS INT, FRIENDSHIP INT,"
                + "CONSTRAINT PLAYER_NAME_PK PRIMARY KEY(PLAYER_NAME))";
       this.statement.addBatch(savedGamesTable);
        
        String existingGame1 = "INSERT INTO SAVEDGAMES VALUES ('Alexa', 'Sage', 35, 26, 42, 35,58, 21)";
        this.statement.addBatch(existingGame1);
        String existingGame2 = "INSERT INTO SAVEDGAMES VALUES('Adrienne', 'Jojo', 40, 20, 18, 32, 12, 9)";
        this.statement.addBatch(existingGame2);
        
        this.statement.executeBatch();
            System.out.println("values inserted");
        
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
     
    }
    public void closeConnections()
    {
        this.dbManager.closeConnections();
    }
}
