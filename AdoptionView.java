/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

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
import cui.Player;

/**
 *
 * @author alei
 */
public class AdoptionView {

    //Screen dimensions
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize = kit.getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight / 2;

    //Player variables
    private JTextField inputPlayerName = new JTextField(10);
    private JPanel playerPanel = new JPanel();
    private JLabel playerPrompt = new JLabel("Enter your name: ");
    private JButton submitPlayerName = submitPlayerName = new JButton("Submit Player Name");

    //Adoption menu 
    private JFrame adoptionFrame = new JFrame("Virtual Pet Game");
    private JPanel adoptionPanel = new JPanel();
    private JLabel adoptionPrompt = new JLabel("Pick an animal to adopt: ");
    private ButtonGroup pets = new ButtonGroup();
    private JRadioButton newDog = new JRadioButton("Dog", true);
    private JRadioButton newCat = new JRadioButton("Cat");
    private JRadioButton newBird = new JRadioButton("Bird");

    //Animal variables
    private JTextField inputPetName = new JTextField(10);
    private JPanel newPetPanel = new JPanel();
    private JLabel petPrompt = new JLabel("Enter the name of your pet: ");
    private JButton submitPetName = new JButton("Submit Pet Name");

    //Return to main menu variables
    private JButton returnMenu = new JButton("Return to menu");
    private JPanel menuReturn = new JPanel();

    //Constructor
    public void AdoptionView() {
        adoptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adoptionFrame.setSize(frameWidth, frameHeight);
        adoptionFrame.setResizable(false);
    }

    //Adding label, text field and button to player panel
    public void inputPlayerName() {

        playerPanel.add(playerPrompt);
        playerPanel.add(inputPlayerName);
        playerPanel.add(submitPlayerName);
    }

    //Adding radio buttons for the different types of pets
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
        adoptionPanel.setVisible(true);

    }

    //Adding label, text field and button to pet panel
    public void inputPetName() {

        newPetPanel.add(petPrompt);
        newPetPanel.add(inputPetName);
        newPetPanel.add(submitPetName);
    }

    //Adding button to return to menu
    public void returntoMenu() {
        menuReturn.add(returnMenu);
    }

    //Adding actionListeners to buttons
    public void addSubmitPlayerNameListener(ActionListener listener) {
        submitPlayerName.addActionListener(listener);
    }

    public void addSubmitPetNameListener(ActionListener listener) {
        submitPetName.addActionListener(listener);
    }

    public void addReturnMenuListener(ActionListener listener) {
        returnMenu.addActionListener(listener);
    }
    
    //Method to display the adoptionFrame method - which is the entire adoption menu
     public void display() {

        adoptionFrame.setSize(frameWidth, frameHeight);
        adoptionFrame.setLocationRelativeTo(null);

        inputPlayerName();
        adoptionFrame.add(playerPanel);

        adoptionMenu();
        adoptionFrame.add(adoptionPanel);

        inputPetName();
        adoptionFrame.add(newPetPanel);

        returntoMenu();
        adoptionFrame.add(menuReturn);

        adoptionFrame.setLayout(new GridLayout(4, 1));

        adoptionFrame.setVisible(true);
    }

     //Method to get rid of the adoption frame
    public void dispose() {
        adoptionFrame.dispose();
    }

    //Get methods
    
    //Returns the type of pet : dog, cat or bird
    public String getPetType() {

        String petType = " ";

        if (newDog.isSelected()) {
            petType = "Dog";
        } else if (newCat.isSelected()) {
            petType = "Cat";
        } else if (newBird.isSelected()) {
            petType = "Bird";
        }

        return petType;
    }

    public JFrame getAdoptionFrame() {
        return adoptionFrame;
    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    public JPanel getAdoptionPanel() {
        return adoptionPanel;
    }

    public JPanel getNewPetPanel() {
        return newPetPanel;
    }

    public String getPlayerName() {
        return this.inputPlayerName.getText();
    }
    
    public String getPetName() {
        return this.inputPetName.getText();
    }
    
    //Set method to set playerName
    public void setPlayerName(String playerName)
    {
        inputPlayerName.setText(playerName);
    }

   

}
