/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alei
 */
public class AdoptionModel
{
    
    private GameDBManager dbManager = new GameDBManager();
    private AdoptionView view; 
    private Player player;
    private Pet pet;

    
    public AdoptionModel(AdoptionView view)
    {
        this.view = view;
       
    }
    
    public boolean existingPlayer()
    {
        return dbManager.findExistingPlayer(view.getPlayerName());
    }
    
    public boolean checkNullPlayerName()
    {
        return view.getPlayerName().isEmpty();
    }
    
    public void newPlayer()
    {
        player = new Player(view.getPlayerName());
        dbManager.newPlayer(view.getPlayerName());
    }
    
    public boolean checkNullPetName()
    {
        return view.getPetName().isEmpty();
    }
    
    public void newPet()
    {
        pet = new Pet(view.getPlayerName());
        dbManager.newPet(view.getPetName());
    }
    
    public String getPlayerName()
    {
        return view.getPlayerName();
    }
    
    public String getPetName()
    {
        return view.getPetName();
    }
    
 
    
}
