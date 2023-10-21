/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alei
 */
public class MainController implements ActionListener {

    private MainView view;
    private MainModel mainModel;
    private GameModel gameModel = new GameModel();

    public MainController(MainView view, MainModel mainModel, GameModel gameModel) {
        this.view = view;
        this.mainModel = mainModel;
        this.gameModel = gameModel;

        view.addFeedListener(this);
        view.addGroomListener(this);
        view.addPlayListener(this);
        view.addSleepListener(this);
        view.addWalkListener(this);
        view.addWaterListener(this);
        view.addSaveGameListener(this);
        view.addReturnToMenuListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Play":
                mainModel.play();
                break;

            case "Walk":
                mainModel.walk();
                break;

            case "Feed":
                mainModel.feed();
                break;

            case "Water":
                mainModel.water();
                break;

            case "Groom":
                mainModel.groom();
                break;

            case "Sleep":
                mainModel.sleep();
                break;

            case "Quit and save game":
                mainModel.saveGame();
                System.exit(0);
                break;

            case "Return to menu":
                view.dispose();
                gameModel.welcomeFrame();
                break;

        }
    }
}
