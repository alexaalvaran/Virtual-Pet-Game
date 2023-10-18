/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author alei
 */

import javax.swing.*;

public class VirtualPetApplication extends JPanel
{
   
    
    public static void main(String[] args) 
    {

         PGCreateDBTables dbTable = new PGCreateDBTables();
          dbTable.createSavedGamesTable();
    
         GameModel game = new GameModel();
         game.welcomeFrame();
         
         dbTable.closeConnections();
    }
 
}
