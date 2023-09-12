/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

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
public class MainFrame {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight / 2;

    private JFrame mainFrame;
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
    private JProgressBar hungerStat = new JProgressBar(0, 100);
    private JProgressBar thirstStat = new JProgressBar(0, 100);
    private JProgressBar energyStat = new JProgressBar(0, 100);
    private JProgressBar hygieneStat = new JProgressBar(0, 100);
    private JProgressBar happinessStat = new JProgressBar(0, 100);
    private JProgressBar friendshipStat = new JProgressBar(0, 100);
    private JLabel hungerLabel = new JLabel("Hunger: ");
    private JLabel thirstLabel = new JLabel("Thirst: ");
    private JLabel energyLabel = new JLabel("Energy: ");
    private JLabel hygieneLabel = new JLabel("Hygiene: ");
    private JLabel happinessLabel = new JLabel("Happiness: ");
    private JLabel friendshipLabel = new JLabel("Friendship: ");
    private int hungerValue = 30;
    private int thirstValue = 30;
    private int energyValue = 80;
    private int hygieneValue = 80;
    private int happinessValue = 5;
    private int friendshipValue = 0;

    public MainFrame() {
        mainFrame = new JFrame("Virtual Pet Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(frameWidth, frameHeight);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        makeMainPanel();
        mainFrame.add(mainPanel, BorderLayout.PAGE_START);
        mainFrame.add(statsPanel, BorderLayout.PAGE_END);
        mainFrame.setVisible(true);
    }

    //Components the main frame if composed of - the main panel and the stats panel
    public void makeMainPanel() {

        //Main panel which contains all the different actions users can take to interact with their pet
        //Also includes button which allows user to save and exit the game
        mainPanel = new JPanel();
        mainPanel.add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                happinessValue += 5;
                hungerValue -= 5;
                thirstValue -= 5;
                energyValue -= 5;
                friendshipValue += 2;
                hygieneValue -= 2;

                happinessStat.setValue(happinessValue);
                hungerStat.setValue(hungerValue);
                thirstStat.setValue(thirstValue);
                energyStat.setValue(energyValue);
                friendshipStat.setValue(friendshipValue);
                hygieneStat.setValue(hygieneValue);

            }
        });

        mainPanel.add(walk);
        walk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                happinessValue += 5;
                hungerValue -= 10;
                thirstValue -= 10;
                energyValue -= 10;
                friendshipValue += 5;
                hygieneValue -= 5;

                happinessStat.setValue(happinessValue);
                hungerStat.setValue(hungerValue);
                thirstStat.setValue(thirstValue);
                energyStat.setValue(energyValue);
                friendshipStat.setValue(friendshipValue);
                hygieneStat.setValue(hygieneValue);

            }
        });

        mainPanel.add(feed);
        feed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                happinessValue += 5;
                hungerValue += 5;
                thirstValue -= 2;
                energyValue += 1;
                friendshipValue += 2;
                hygieneValue -= 2;

                happinessStat.setValue(happinessValue);
                hungerStat.setValue(hungerValue);
                thirstStat.setValue(thirstValue);
                energyStat.setValue(energyValue);
                friendshipStat.setValue(friendshipValue);
                hygieneStat.setValue(hygieneValue);

            }
        });

        mainPanel.add(water);
        water.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thirstValue += 10;
                thirstStat.setValue(thirstValue);
            }
        });

        mainPanel.add(groom);
        groom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                happinessValue += 5;
                energyValue -= 5;
                friendshipValue += 5;
                hygieneValue += 20;

                happinessStat.setValue(happinessValue);
                energyStat.setValue(energyValue);
                friendshipStat.setValue(friendshipValue);
                hygieneStat.setValue(hygieneValue);

            }
        });

        mainPanel.add(sleep);
        sleep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                energyValue += 30;
                energyStat.setValue(energyValue);
            }
        });
        mainPanel.add(saveGame);
        saveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Stats panel contains the progress bar (status bar) of the pet
        statsPanel = new JPanel();

        statsPanel.add(hungerLabel);
        statsPanel.add(hungerStat);
        hungerStat.setValue(30);

        statsPanel.add(thirstLabel);
        statsPanel.add(thirstStat);
        thirstStat.setValue(30);

        statsPanel.add(energyLabel);
        statsPanel.add(energyStat);
        energyStat.setValue(80);

        statsPanel.add(hygieneLabel);
        statsPanel.add(hygieneStat);
        hygieneStat.setValue(80);

        statsPanel.add(happinessLabel);
        statsPanel.add(happinessStat);
        happinessStat.setValue(5);

        statsPanel.add(friendshipLabel);
        statsPanel.add(friendshipStat);

        statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    }
}