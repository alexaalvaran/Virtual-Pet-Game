/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author alei
 */

//WelcomeView handles the visual aspects of the welcome menu frame
public class WelcomeView {

    //Screen dimension variables
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize = kit.getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight / 2;

    //welcome frame variables
    private JFrame welcomeFrame;
    private JPanel welcomePanel;
    private JButton newGame = new JButton("Play new game");
    private JButton existingGame = new JButton("Play existing game");
    private JButton explainGame = new JButton("Explain the game");
    private JButton quitGame = new JButton("Quit");

    //returns true if 'existing game' is choosen
    private boolean selectedExisting = false;
    
    //Default constructor
    public WelcomeView() {
        welcomeFrame = new JFrame("Virtual Pet App");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(frameWidth, frameHeight);
        welcomeFrame.setResizable(false);
        welcomeFrame.setLocationRelativeTo(null);

    }

    //Welcome menu adds corresponding buttons to welcome panel and gives it a box layout
    public void welcomeMenu() {

        welcomePanel = new JPanel();

        welcomePanel.add(Box.createHorizontalGlue());
        welcomePanel.add(Box.createHorizontalStrut(frameWidth / 4));
        welcomePanel.add(Box.createVerticalGlue());
        welcomePanel.add(newGame);
        welcomePanel.add(Box.createVerticalStrut(10));
        welcomePanel.add(existingGame);
        welcomePanel.add(Box.createVerticalStrut(10));
        welcomePanel.add(explainGame);
        welcomePanel.add(Box.createVerticalStrut(10));
        welcomePanel.add(quitGame);
        welcomePanel.add(Box.createVerticalGlue());
        welcomePanel.add(Box.createHorizontalStrut(frameWidth / 4));
        welcomePanel.add(Box.createHorizontalGlue());

        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
    }
    
    //Adds the welcome panel to the welcome frame to be displayed
    public void display() {
        welcomeMenu();
        welcomeFrame.add(welcomePanel);

        welcomeFrame.setVisible(true);
    }

    //Dispose the welcome frame
    public void dispose() {
        welcomeFrame.dispose();
    }

    //Adding action listeners to the buttons 
    public void addNewGameListener(ActionListener listener) {
        newGame.addActionListener(listener);
    }

    public void addExistingGameListener(ActionListener listener) {
        existingGame.addActionListener(listener);
    }

    public void addExplainGameListener(ActionListener listener) {
        explainGame.addActionListener(listener);
    }

    public void addQuitGameListener(ActionListener listener) {
        quitGame.addActionListener(listener);
    }

    //Get and set method for existing game 
    public void setExistingGame(boolean value) {
        selectedExisting = value;
    }

    public boolean getExistingGame() {
        return selectedExisting;
    }
}
