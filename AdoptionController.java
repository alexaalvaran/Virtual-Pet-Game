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

//Adoption Controller class controls the buttons from the Adoption View class
public class AdoptionController implements ActionListener {

    //Variables
    private AdoptionView view;
    private AdoptionModel adoptionModel;
    private GameModel gameModel = new GameModel();

    //Constructor
    public AdoptionController(AdoptionView view, AdoptionModel model, GameModel gameModel) {
        this.view = view;
        this.adoptionModel = model;
        this.gameModel = gameModel;

        view.addSubmitPlayerNameListener(this);
        view.addSubmitPetNameListener(this);
        view.addReturnMenuListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {

            //When player submtis player name
            case "Submit Player Name":

                //Checks if the text box is not null - player can't proceed if it is null
                if (!adoptionModel.checkNullPlayerName()) {

                    //Checks if there is already a player with existing name
                    if (adoptionModel.existingPlayer()) {
                        JOptionPane.showMessageDialog(null, "Existing player already exists - continuing will overwrite existing game", "VirtualPetApp", JOptionPane.INFORMATION_MESSAGE);

                        //This statement is for if the user chooses 'Play existing game' from the welcome menu
                        //Gets rid of the adoption frame and sets up the mainFrame which should load existing game from database
                        if (gameModel.getWelcomeView().getExistingGame()) {
                            view.dispose();
                            gameModel.mainFrame();
                        }

                    } else {
                        //If there is no existing game under that player name then a new player instance is created through the method
                        adoptionModel.newPlayer();
                    }

                }
                break;

                //When player submits player name
            case "Submit Pet Name":

                //Checks that both text boxes have receive an input - one for pet and the other for player name
                if (!adoptionModel.checkNullPetName() && !adoptionModel.checkNullPlayerName()) {
                    adoptionModel.newPet();

                    //If there is an input then the adoption frame is disposed and the game frame is loaded
                    view.dispose();
                    gameModel.mainFrame();
                }
                break;

                //Button that allows players to return to the menu frame
            case "Return to menu":
                view.getAdoptionFrame().dispose();
                gameModel.welcomeFrame();
                break;
        }
    }

}
