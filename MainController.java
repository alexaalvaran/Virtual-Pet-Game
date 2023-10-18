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
public class MainController implements ActionListener
{
    private MainView view;
    private MainModel model;

    
    public MainController(MainView view, MainModel model)
    {
        this.view = view;
        this.model = model;
        
        view.addFeedListener(this);
        view.addGroomListener(this);
        view.addPlayListener(this);
        view.addSleepListener(this);
        view.addWalkListener(this);
        view.addWaterListener(this);
        view.addSaveGameListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        
        switch(command)
        {
            case "Play":
                model.play();
                break;
                
            case "Walk":
                model.walk();
                break;
              
            case "Feed":
                model.feed();
                break;
            
            case "Water":
                model.water();
                break;
            
            case "Groom":
                model.groom();
                break;
            
            case "Sleep":
                model.sleep();
                break;
                
            case "Quit and save game":
                model.saveGame();
                System.exit(0);
                break;
        }
    }
}
