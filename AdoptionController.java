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
public class AdoptionController implements ActionListener
{
   private AdoptionView view;
   private AdoptionModel adoptionModel;
   private GameModel gameModel = new GameModel();

   
   public AdoptionController(AdoptionView view, AdoptionModel model, GameModel gameModel)
   {
       this.view = view;
       this.adoptionModel = model;
       this.gameModel = gameModel;
       
       view.addSubmitPlayerNameListener(this);
       view.addSubmitPetNameListener(this);
       view.addReturnMenuListener(this);
   }
   
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch(command)
        {
            
            case "Submit Player Name":
                
                adoptionModel.newPlayer();
                
                if(!adoptionModel.checkNullPlayerName())
                {
                   
                    if(adoptionModel.existingPlayer())
                    {
                         JOptionPane.showMessageDialog(null, "Existing player already exists - continuing will overwrite existing game", "VirtualPetApp", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                    
                }
                break;
                
            case "Submit Pet Name":
          
                if(!adoptionModel.checkNullPetName() && !adoptionModel.checkNullPlayerName())
                {
                    adoptionModel.newPet();
                   
                    view.dispose(); 
                    gameModel.mainFrame();
                }
                break;
                
            case "Return to menu":
                view.getAdoptionFrame().dispose();
                gameModel.welcomeFrame();
                break;
        }
    }

}
