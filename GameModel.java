/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alei
 */
public class GameModel 
{
    
     private AdoptionView adoptionView = new AdoptionView();
    private AdoptionModel adoptionModel =  new AdoptionModel(adoptionView);
    
     private MainView mainView = new MainView();
               
    public void welcomeFrame()
    {
    WelcomeView welcomeView = new WelcomeView();
    WelcomeController welcomeController = new WelcomeController(welcomeView);
    welcomeView.display();
    
    }
    
    public void adoptionFrame()
    {

     AdoptionController adoptionController = new AdoptionController(adoptionView, adoptionModel, this);
     adoptionView.display(); 
    }
    
    public void mainFrame()
    {
      
       mainView.display();
       
       Player player = new Player(adoptionModel.getPlayerName());
       Pet pet = new Pet(adoptionModel.getPetName());
        
       MainModel mainModel = new MainModel(player, pet, mainView.getPetStats());
       
       mainModel.loadExistingGame();
       
       MainController mainController = new MainController(mainView, mainModel);
        
    }
    
    public AdoptionView getAdoptionView()
    {
        return this.adoptionView;
    }
    
 
}
