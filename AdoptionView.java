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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author alei
 */
public class AdoptionFrame {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight / 2;
    //Get player name
    private JTextField inputPlayerName;
    private JPanel playerPanel;
    private JButton submitPlayerName;

    //Adoption menu 
    private JFrame adoptionFrame;
    private JPanel adoptionPanel;
    private ButtonGroup pets = new ButtonGroup();
    private JRadioButton newDog = new JRadioButton("Dog", true);
    private JRadioButton newCat = new JRadioButton("Cat");
    private JRadioButton newBird = new JRadioButton("Bird");

    //Get animal name
    private JTextField inputPetName;
    private JPanel newPetPanel;
    private JButton submitPetName;
    
      //Making the adoption frame
    public AdoptionFrame() {
        adoptionFrame = new JFrame("Virtual Pet Game");
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
        playerPanel = new JPanel();
        inputPlayerName = new JTextField(10);
        submitPlayerName = new JButton("submit");

        JLabel playerPrompt = new JLabel("Enter your name: ");
        playerPanel.add(playerPrompt);
        playerPanel.add(inputPlayerName);
        playerPanel.add(submitPlayerName);
    }

    //Creating the adoption menu : buttons
    public void adoptionMenu() {
        adoptionPanel = new JPanel();

        //Adding buttons to button group (radio buttons)
        pets.add(newDog);
        pets.add(newCat);
        pets.add(newBird);

        JLabel adoptionPrompt = new JLabel("Pick an animal to adopt: ");

        //Adding buttons to panel
        adoptionPanel.add(adoptionPrompt);
        adoptionPanel.add(newDog);
        adoptionPanel.add(newCat);
        adoptionPanel.add(newBird);

    }

 
    //Creating the panel that has textfield which retrieves the name of the pet and submit button
    public void getPetName() {
        newPetPanel = new JPanel();
        inputPetName = new JTextField(10);
        submitPetName = new JButton("submit");

        JLabel petPrompt = new JLabel("Enter the name of your pet: ");
        newPetPanel.add(petPrompt);
        newPetPanel.add(inputPetName);
        newPetPanel.add(submitPetName);

        //When submit button is pressed, we go to the main playing game frame 
        submitPetName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adoptionFrame.dispose();
                MainFrame mainFrame = new MainFrame();
            }
        });
    }

}
