/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author alei
 */
public class AdoptionView {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight / 2;
    //Get player name
    private JTextField inputPlayerName = new JTextField(10);;
    private JPanel playerPanel = new JPanel();
    private JLabel playerPrompt = new JLabel("Enter your name: ");
    private JButton submitPlayerName =   submitPlayerName = new JButton("submit");

    //Adoption menu 
    private JFrame adoptionFrame = new JFrame("Virtual Pet Game");;
    private JPanel adoptionPanel =  new JPanel();;
    JLabel adoptionPrompt = new JLabel("Pick an animal to adopt: ");
    private ButtonGroup pets = new ButtonGroup();
    private JRadioButton newDog = new JRadioButton("Dog", true);
    private JRadioButton newCat = new JRadioButton("Cat");
    private JRadioButton newBird = new JRadioButton("Bird");

    //Get animal name
    private JTextField inputPetName  = new JTextField(10);;
    private JPanel newPetPanel =  new JPanel();
    JLabel petPrompt = new JLabel("Enter the name of your pet: ");
    private JButton submitPetName = new JButton("submit");

    //Adoption DB Manager
    GameDBManager dbManager = new GameDBManager();

    //Making the adoption frame
    public AdoptionView() {
        adoptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adoptionFrame.setSize(frameWidth, frameHeight);
        adoptionFrame.setResizable(false);
        adoptionFrame.setLocationRelativeTo(null);

        getPlayerName();
        adoptionFrame.add(playerPanel);

        adoptionMenu();
        adoptionFrame.add(adoptionPanel);

        getPetName();
        adoptionFrame.add(newPetPanel);

        adoptionFrame.setLayout(new GridLayout(3, 1));
        adoptionFrame.setVisible(true);
    }

//Creating the panel which stores textfield to retrieve player name and button to submit
    public void getPlayerName() {
        playerPanel.add(playerPrompt);
        playerPanel.add(inputPlayerName);
        playerPanel.add(submitPlayerName);

        submitPlayerName.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
            boolean found = dbManager.findExistingPlayer(inputPlayerName.getText());
            if(found == true)
             {
            JOptionPane.showMessageDialog(null, "Existing player already exists", "VirtualPetApp", JOptionPane.INFORMATION_MESSAGE);
            }
            dbManager.newPlayer(inputPlayerName.getText());
            }
        });

    }

    //Creating the adoption menu : buttons
    public void adoptionMenu() {
    
        //Adding buttons to button group (radio buttons)
        pets.add(newDog);
        pets.add(newCat);
        pets.add(newBird);

        //Adding buttons to panel
        adoptionPanel.add(adoptionPrompt);
        adoptionPanel.add(newDog);
        adoptionPanel.add(newCat);
        adoptionPanel.add(newBird);

    }

    //Creating the panel that has textfield which retrieves the name of the pet and submit button
    public void getPetName() {
      
        newPetPanel.add(petPrompt);
        newPetPanel.add(inputPetName);
        newPetPanel.add(submitPetName);

        //When submit button is pressed, we go to the main playing game frame 
        submitPetName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbManager.newPet(inputPetName.getText());
                adoptionFrame.dispose();
                MainFrame mainFrame = new MainFrame();
            }
        });
    }

    public JFrame getAdoptionFrame() {
        return adoptionFrame;
    }

    public void setAdoptionFrame(JFrame adoptionFrame) {
        this.adoptionFrame = adoptionFrame;
    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    public void setPlayerPanel(JPanel playerPanel) {
        this.playerPanel = playerPanel;
    }

    public JPanel getAdoptionPanel() {
        return adoptionPanel;
    }

    public void setAdoptionPanel(JPanel adoptionPanel) {
        this.adoptionPanel = adoptionPanel;
    }

    public JPanel getNewPetPanel() {
        return newPetPanel;
    }

    public void setNewPetPanel(JPanel newPetPanel) {
        this.newPetPanel = newPetPanel;
    }

    public JButton getSubmitPlayerName() {
        return submitPlayerName;
    }

    public void setSubmitPlayerName(JButton submitPlayerName) {
        this.submitPlayerName = submitPlayerName;
    }

}