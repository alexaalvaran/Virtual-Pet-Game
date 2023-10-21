/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alei
 */
public class GameModel {

    private WelcomeView welcomeView = new WelcomeView();
    private AdoptionView adoptionView = new AdoptionView();
    private AdoptionModel adoptionModel = new AdoptionModel(adoptionView);

    private MainView mainView = new MainView();

    public void welcomeFrame() {

        WelcomeController welcomeController = new WelcomeController(welcomeView, this);
        welcomeView.display();

    }

    public void adoptionFrame() {

        AdoptionController adoptionController = new AdoptionController(adoptionView, adoptionModel, this);
        adoptionView.display();
    }

    public void mainFrame() {

        Player player = new Player(adoptionModel.getPlayerName());
        Pet pet = new Pet(adoptionModel.getPetName(), adoptionModel.getPetType());

        MovingAnimal movingAnimal = new MovingAnimal("");

        if (adoptionView.getPetType().equalsIgnoreCase("Dog")) {
            movingAnimal = new MovingAnimal("/Users/alei/NetBeansProjects/ENSE600_Project1/dog.png");
        } else if (adoptionView.getPetType().equalsIgnoreCase("Cat")) {
            movingAnimal = new MovingAnimal("/Users/alei/NetBeansProjects/ENSE600_Project1/cat.png");
        } else if (adoptionView.getPetType().equalsIgnoreCase("Bird")) {
            movingAnimal = new MovingAnimal("/Users/alei/NetBeansProjects/ENSE600_Project1/bird.png");
        }

        mainView.display();
        mainView.getMainFrame().add(movingAnimal);

        MainModel mainModel = new MainModel(player, pet, mainView.getPetStats());

        mainModel.loadExistingGame();

        MainController mainController = new MainController(mainView, mainModel, this);

    }

    public AdoptionView getAdoptionView() {
        return this.adoptionView;
    }

    public WelcomeView getWelcomeView() {
        return this.welcomeView;
    }

}
