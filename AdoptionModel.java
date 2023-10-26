/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alei
 */

//Adoption model class handles methods for the Adoption view and Adoption Controller calss
public class AdoptionModel {

    //Variables
    private GameDBManager dbManager = new GameDBManager();
    private AdoptionView view;
    private Player player;
    private Pet pet;

    //Constructor
    public AdoptionModel(AdoptionView view) {
        this.view = view;

    }

    //Checks if existing player exists in the database
    public boolean existingPlayer() {
        return dbManager.findExistingPlayer(view.getPlayerName());
    }

    //Checks if user has input a player name
    public boolean checkNullPlayerName() {
        return view.getPlayerName().isEmpty();
    }

    //Creates a new player instance
    public void newPlayer() {
        player = new Player(view.getPlayerName());
        dbManager.newPlayer(view.getPlayerName());
    }

    //Checks if user has input a pet name
    public boolean checkNullPetName() {
        return view.getPetName().isEmpty();
    }

    //Creates a new pet instance
    public void newPet() {
        pet = new Pet(view.getPlayerName(), view.getPetType());
        dbManager.newPet(view.getPetName());
    }

    //Get methods for player name, pet name and pet type
    public String getPlayerName() {
        return view.getPlayerName();
    }

    public String getPetName() {
        return view.getPetName();
    }

    public String getPetType() {
        return view.getPetType();
    }

}
