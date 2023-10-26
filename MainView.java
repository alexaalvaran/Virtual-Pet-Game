/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.OverlayLayout;

/**
 *
 * @author alei
 */

//MainView class handles the main game frame with the pet and the game buttons and stats
public class MainView {

    //Screen dimensions variable
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize = kit.getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight / 2;

    //Main Game frame
    private JFrame mainFrame = new JFrame("Virtual Pet Game");
    
    //Panel that stores all the different game buttons 
    private JPanel buttonPanel;
    private JButton play = new JButton("Play");
    private JButton walk = new JButton("Walk");
    private JButton feed = new JButton("Feed");
    private JButton water = new JButton("Water");
    private JButton groom = new JButton("Groom");
    private JButton sleep = new JButton("Sleep");
    private JButton saveGame = new JButton("Quit and save game");
    private JButton resetGame = new JButton("Reset");
    private JButton returntoMenu = new JButton("Return to menu");

    //Pet stats 
    private JPanel statsPanel;
    private PetStats stats = new PetStats();
    private JLabel hungerLabel = new JLabel("Hunger: ");
    private JLabel thirstLabel = new JLabel("Thirst: ");
    private JLabel energyLabel = new JLabel("Energy: ");
    private JLabel hygieneLabel = new JLabel("Hygiene: ");
    private JLabel happinessLabel = new JLabel("Happiness: ");
    private JLabel friendshipLabel = new JLabel("Friendship: ");

    //Default constructor 
    public void MainView() {

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(frameWidth, frameHeight);
        mainFrame.setResizable(false);

    }

    //Adds the petStats labels and the progress bars to the stats panel 
    public void petStats() {
        statsPanel = new JPanel();

        statsPanel.add(hungerLabel);
        statsPanel.add(stats.getHungerStat());

        statsPanel.add(thirstLabel);
        statsPanel.add(stats.getThirstStat());

        statsPanel.add(energyLabel);
        statsPanel.add(stats.getEnergyStat());

        statsPanel.add(hygieneLabel);
        statsPanel.add(stats.getHygieneStat());

        statsPanel.add(happinessLabel);
        statsPanel.add(stats.getHappinessStat());

        statsPanel.add(friendshipLabel);
        statsPanel.add(stats.getFriendshipStat());

        statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    //Addinng button action listeners
    public void addPlayListener(ActionListener listener) {
        play.addActionListener(listener);
    }

    public void addWalkListener(ActionListener listener) {
        walk.addActionListener(listener);
    }

    public void addFeedListener(ActionListener listener) {
        feed.addActionListener(listener);
    }

    public void addWaterListener(ActionListener listener) {
        water.addActionListener(listener);
    }

    public void addGroomListener(ActionListener listener) {
        groom.addActionListener(listener);
    }

    public void addSleepListener(ActionListener listener) {
        sleep.addActionListener(listener);
    }

    public void addSaveGameListener(ActionListener listener) {
        saveGame.addActionListener(listener);
    }
    
    public void addResetGameListener(ActionListener listener){
        resetGame.addActionListener(listener);
    }

    public void addReturnToMenuListener(ActionListener listener) {
        returntoMenu.addActionListener(listener);
    }


    //Displays the game frame
    public void display() {
       
        mainFrame.setSize(frameWidth, frameHeight);
        mainFrame.setLocationRelativeTo(null);
        
        buttonPanel = new JPanel();

        buttonPanel.add(play);
        buttonPanel.add(walk);
        buttonPanel.add(feed);
        buttonPanel.add(water);
        buttonPanel.add(groom);
        buttonPanel.add(sleep);
        buttonPanel.add(saveGame);
        buttonPanel.add(resetGame);
        buttonPanel.add(returntoMenu);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        petStats();
 
        mainFrame.add(statsPanel, BorderLayout.SOUTH);
        mainFrame.add(buttonPanel, BorderLayout.NORTH);
      
        mainFrame.setVisible(true);
  
  
    }
    
    //Disposes the game frame 
    public void dispose() {
        mainFrame.dispose();
    }
    
    //Get methods
    public PetStats getPetStats() {
        return this.stats;
    }

    public JFrame getMainFrame() {
        return this.mainFrame;
    }

    

}
