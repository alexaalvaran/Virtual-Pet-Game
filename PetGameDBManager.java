/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alei
 */

//This class establishes the connection with the embedded database 
public class PetGameDBManager {

    //Variables
    private static final String USER_NAME = "group44"; //Database username
    private static final String PASSWORD = "44"; //Database password
    private static final String URL = "jdbc:derby:PetGameDB_Ebd; create = true"; //url of the DB host
    private Connection conn;

    //Default Constructor
    public PetGameDBManager() {
        establishConnection();
    }

    //Get the connection 
    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection to embedded database
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + "Get connected successfully...");

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    //Close connection
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
