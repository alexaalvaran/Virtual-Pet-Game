/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alei
 */

//WelcomeController handles the action listener for the buttons in welcome view 
public class WelcomeController implements ActionListener {
    
    //Variables
    private WelcomeView welcomeView;
    private GameModel gameModel = new GameModel();
    
    //Constructor
    public WelcomeController(WelcomeView welcomeView, GameModel gameModel) {
        this.welcomeView = welcomeView;
        this.gameModel = gameModel;
        
        welcomeView.addNewGameListener(this);
        welcomeView.addExistingGameListener(this);
        welcomeView.addExplainGameListener(this);
        welcomeView.addQuitGameListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        AdoptionView adoptionView;
        
        switch (command) {
            //If play game is choosen then welcome view is disposed and it is passed onto the adoption frame
            case "Play new game":
                welcomeView.dispose();
                gameModel.adoptionFrame();
                
                break;
            //If existing game is choosen then welcome view is diposed and its passed onto a adoption frame but with less prompts
            case "Play existing game":
                welcomeView.setExistingGame(true);
                welcomeView.dispose();
                gameModel.adoptionFrame();
                gameModel.getAdoptionView().getAdoptionFrame().remove(gameModel.getAdoptionView().getAdoptionPanel());
                gameModel.getAdoptionView().getAdoptionFrame().remove(gameModel.getAdoptionView().getNewPetPanel());
                
                break;
                
            //Explains the pet game through a pop up message which can easily be discarded by player after
            case "Explain the game":
                JOptionPane.showMessageDialog(null, "This is a virtual pet game where you can adopt different dogs, cats, or birds and take care of them. \n"
                        + "You can feed, play with, bathe, groom, and walk with your pet which increases your friendship level.\n"
                        + "Make sure to keep taking care of your pet to keep their levels up and your friendship level high!\n "
                        + "Have fun :)", "Virtual Pet App", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            //Exits game
            case "Quit":
                System.exit(0);
                break;
            
        }
    }
    
}
