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
public class WelcomeController implements ActionListener
{
    private WelcomeView welcomeView;
    private GameModel gameModel = new GameModel();
    
    public WelcomeController(WelcomeView welcomeView)
    {
        this.welcomeView = welcomeView;
        
        welcomeView.addNewGameListener(this);
        welcomeView.addExistingGameListener(this);
        welcomeView.addExplainGameListener(this);
        welcomeView.addQuitGameListener(this);
    }
    
    @Override 
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        AdoptionView adoptionView;
        
        switch(command)
        {
            case "Play new game":
           
            welcomeView.dispose();
             gameModel.adoptionFrame();
           

                 break;
            
            case "Play existing game":
                welcomeView.dispose();
                gameModel.adoptionFrame();
                gameModel.getAdoptionView().getAdoptionFrame().remove(gameModel.getAdoptionView().getAdoptionPanel());
                 gameModel.getAdoptionView().getAdoptionFrame().remove(gameModel.getAdoptionView().getNewPetPanel());
                break;
                
            case "Explain the game":
                JOptionPane.showMessageDialog(null, "This is a virtual pet game where you can adopt different dogs, cats, or birds and take care of them. \n"
                        + "You can feed, play with, bathe, groom, and walk with your pet which increases your friendship level.\n"
                        + "Make sure to keep taking care of your pet to keep their levels up and your friendship level high!\n "
                        + "Have fun :)", "Virtual Pet App", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            case "Quit":
                 System.exit(0);
                 break;
                 
        }
    }
 
}
