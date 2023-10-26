/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alei
 */
public class Player {

    //Variable
    private String playerName;

    //Default constructor
    public Player() {

    }

    //Constructor
    public Player(String playerName) {
        this.setPlayerName(playerName);
    }

    //Get and set method for vairable
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
