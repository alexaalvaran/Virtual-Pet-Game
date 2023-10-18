/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
/**
 *
 * @author alei
 */
public class MainView 
{
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight / 2;

    private JFrame mainFrame =  new JFrame("Virtual Pet Game");;
    private JPanel mainPanel;
    private JButton play = new JButton("Play");
    private JButton walk = new JButton("Walk");
    private JButton feed = new JButton("Feed");
    private JButton water = new JButton("Water");
    private JButton groom = new JButton("Groom");
    private JButton sleep = new JButton("Sleep");
    private JButton saveGame = new JButton("Quit and save game");

    //Pet stats 
    private JPanel statsPanel;
    private PetStats stats = new PetStats();
    private JLabel hungerLabel = new JLabel("Hunger: ");
    private JLabel thirstLabel = new JLabel("Thirst: ");
    private JLabel energyLabel = new JLabel("Energy: ");
    private JLabel hygieneLabel = new JLabel("Hygiene: ");
    private JLabel happinessLabel = new JLabel("Happiness: ");
    private JLabel friendshipLabel = new JLabel("Friendship: ");
    
    public void MainView()
    {
       
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(frameWidth, frameHeight);
        mainFrame.setResizable(false);
     
    }
    
    public void petStats()
    {
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
    public void addPlayListener(ActionListener listener)
    {
        play.addActionListener(listener);
    }
    
    public void addWalkListener(ActionListener listener)
    {
        walk.addActionListener(listener);
    }
    
    public void addFeedListener(ActionListener listener)
    {
        feed.addActionListener(listener);
    }
    
    public void addWaterListener(ActionListener listener)
    {
        water.addActionListener(listener);
    }
    
    public void addGroomListener(ActionListener listener)
    {
        groom.addActionListener(listener);
    }
    
    public void addSleepListener(ActionListener listener)
    {
        sleep.addActionListener(listener);
    }
    
    public void addSaveGameListener(ActionListener listener)
    {
        saveGame.addActionListener(listener);
    }  
    
    public void display()
    {
         mainFrame.setSize(frameWidth, frameHeight);
         mainFrame.setLocationRelativeTo(null);
        mainPanel = new JPanel();
        mainPanel.add(play);
        mainPanel.add(walk);
        mainPanel.add(feed);
        mainPanel.add(water);
        mainPanel.add(groom);
        mainPanel.add(sleep);
        mainPanel.add(saveGame);
        
        petStats();
        mainPanel.add(statsPanel);
        
       mainFrame.add(mainPanel, BorderLayout.PAGE_START);
        mainFrame.add(statsPanel, BorderLayout.PAGE_END);
        
              
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
    
    public PetStats getPetStats()
    {
        return this.stats;
    }
}
