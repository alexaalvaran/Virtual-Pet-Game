/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author alei
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PetAppGUI extends JPanel {

    //Getting the size of the users screen so frame size can be set accordingly
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth;
    int frameHeight = screenHeight/2;

    //Welcome menu
    JFrame welcomeFrame;
    JPanel welcomePanel;
    JButton newGame = new JButton("Play new game");
    JButton existingGame = new JButton("Play existing game");
    JButton explainGame = new JButton("Explain the game");
    JButton quitGame = new JButton("Quit");

    //Get player name
    JTextField inputPlayerName;
    JPanel playerPanel;
    JButton submitPlayerName;

    //Adoption menu 
    JFrame adoptionFrame;
    JPanel adoptionPanel;
    ButtonGroup pets = new ButtonGroup();
    JRadioButton newDog = new JRadioButton("Dog", true);
    JRadioButton newCat = new JRadioButton("Cat");
    JRadioButton newBird = new JRadioButton("Bird");

    //Get animal name
    JTextField inputPetName;
    JPanel newPetPanel;
    JButton submitPetName;

    //Game menu
    JFrame mainFrame;
    JPanel mainPanel;
    JButton play = new JButton("Play");
    JButton walk = new JButton("Walk");
    JButton feed = new JButton("Feed");
    JButton water = new JButton("Water");
    JButton groom = new JButton("Groom");
    JButton sleep = new JButton("Sleep");
    JButton saveGame = new JButton("Quit and save game");
    
    //Pet stats  - progress bars
    JPanel statsPanel;
    JProgressBar hungerStat = new JProgressBar(0 ,100);
    JProgressBar thirstStat = new JProgressBar(0,100);
    JProgressBar energyStat = new JProgressBar(0, 100);
    JProgressBar hygieneStat = new JProgressBar(0, 100);
    JProgressBar happinessStat = new JProgressBar(0,100);
    JProgressBar friendshipStat = new JProgressBar(0, 100);
    JLabel hungerLabel = new JLabel("Hunger: ");
    JLabel thirstLabel = new JLabel("Thirst: ");
        JLabel energyLabel = new JLabel("Energy: ");
            JLabel hygieneLabel = new JLabel("Hygiene: ");
                JLabel happinessLabel = new JLabel("Happiness: ");
                    JLabel friendshipLabel = new JLabel("Friendship: ");

    public void petApp() {

        //welcomeFrame = new PetGameFrame(); //Creating the welcome frame
        this.makeWelcomeFrame();
        this.welcomeMenu();
        welcomeFrame.add(welcomePanel);
        welcomeFrame.setVisible(true);
        this.mainFrame();

    }

    public void makeWelcomeFrame() {
        welcomeFrame = new JFrame("Virtual Pet App");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(frameWidth, frameHeight);
        welcomeFrame.setResizable(false);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setVisible(true);
    }

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

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == newGame) {

                    welcomeFrame.dispose();
                    makeAdoptionFrame();
                    adoptionMenu();
                    getPlayerName();
                    getPetName();
                    adoptionFrame.add(playerPanel);
                    adoptionFrame.add(adoptionPanel);
                    adoptionFrame.add(newPetPanel);
                    adoptionFrame.setLayout(new GridLayout(3, 1));
                    adoptionFrame.setVisible(true);
                }
            }
        });

        existingGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.dispose();
                makeAdoptionFrame();
                getPlayerName();
                adoptionFrame.add(playerPanel, BorderLayout.CENTER);
                adoptionFrame.setVisible(true);

            }
        });

        explainGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This is a virtual pet game where you can adopt different dogs, cats, or birds and take care of them. \n"
                        + "You can feed, play with, bathe, groom, and walk with your pet which increases your friendship level.\n"
                        + "Make sure to keep taking care of your pet to keep their levels up and your friendship level high!\n "
                        + "Have fun :)", "Virtual Pet App", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public void getPlayerName() {
        playerPanel = new JPanel();
        inputPlayerName = new JTextField(10);
        submitPlayerName = new JButton("submit");

        JLabel playerPrompt = new JLabel("Enter your name: ");
        playerPanel.add(playerPrompt);
        playerPanel.add(inputPlayerName);
        playerPanel.add(submitPlayerName);
    }

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

    public void makeAdoptionFrame() {
        adoptionFrame = new JFrame("Virtual Pet Game");
        adoptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adoptionFrame.setSize(frameWidth, frameHeight);
        adoptionFrame.setResizable(false);
        adoptionFrame.setLocationRelativeTo(null);
        adoptionFrame.setVisible(true);
    }

    public void getPetName() {
        newPetPanel = new JPanel();
        inputPetName = new JTextField(10);
        submitPetName = new JButton("submit");

        JLabel petPrompt = new JLabel("Enter the name of your pet: ");
        newPetPanel.add(petPrompt);
        newPetPanel.add(inputPetName);
        newPetPanel.add(submitPetName);
        
        submitPetName.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
           adoptionFrame.dispose();
           makeMainFrame();
        }
    });
    }

    public void makeMainFrame() {
        mainFrame = new JFrame("Virtual Pet Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(frameWidth, frameHeight);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.add(mainPanel, BorderLayout.PAGE_START);
        mainFrame.add(statsPanel, BorderLayout.PAGE_END);
        mainFrame.setVisible(true);
    }

    public void mainFrame() {
        mainPanel = new JPanel();
        mainPanel.add(play);
        mainPanel.add(walk);
        mainPanel.add(feed);
        mainPanel.add(water);
        mainPanel.add(groom);
        mainPanel.add(sleep);
        mainPanel.add(saveGame);
        saveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        statsPanel = new JPanel();
        
        statsPanel.add(hungerLabel);
        statsPanel.add(hungerStat);
        
        statsPanel.add(thirstLabel);
        statsPanel.add(thirstStat);
        
        statsPanel.add(energyLabel);
        statsPanel.add(energyStat);
        
        statsPanel.add(hygieneLabel);
        statsPanel.add(hygieneStat);
        
        statsPanel.add(happinessLabel);
        statsPanel.add(happinessStat);
        
        statsPanel.add(friendshipLabel);
        statsPanel.add(friendshipStat);
        
        statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
     
    }
}
