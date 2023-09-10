/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author alei
 */
import java.awt.Dimension;
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
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;

    //Welcome menu button
    JFrame welcomeFrame;
    JPanel welcomePanel;
    JButton newGame = new JButton("Play new game");
    JButton existingGame = new JButton("Play existing game");
    JButton explainGame = new JButton("Explain the game");
    JButton quitGame = new JButton("Quit");

    //Adoption menu buttons
    JFrame adoptionFrame;
    JPanel adoptionPanel;
    JButton newDog = new JButton("Dog");
    JButton newCat = new JButton("Cat");
    JButton newBird = new JButton("Bird");

    public void petApp() {

        //welcomeFrame = new PetGameFrame(); //Creating the welcome frame
        this.makeWelcomeFrame();
        this.welcomeMenu();
        welcomeFrame.add(welcomePanel);
        welcomeFrame.setVisible(true);

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
                    adoptionFrame.add(adoptionPanel);
                    adoptionFrame.setVisible(true);

                }
            }
        });

        existingGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Starting existing game!", "Virtual Pet App", JOptionPane.INFORMATION_MESSAGE);
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

    public void adoptionMenu() {
        adoptionPanel = new JPanel();
        
        adoptionPanel.add(Box.createHorizontalGlue());
        adoptionPanel.add(Box.createHorizontalStrut(frameWidth / 4));
        adoptionPanel.add(Box.createVerticalGlue());
        JLabel  adoptionPrompt = new JLabel("Pick a new animal to adopt: ", JLabel.CENTER);
        adoptionPanel.add(adoptionPrompt);
        adoptionPanel.add(newDog);
        adoptionPanel.add(newCat);
        adoptionPanel.add(newBird);
        adoptionPanel.add(Box.createVerticalGlue());
        adoptionPanel.add(Box.createHorizontalStrut(frameWidth / 4));
        adoptionPanel.add(Box.createHorizontalGlue());
        
        adoptionPanel.setLayout(new BoxLayout(adoptionPanel, BoxLayout.Y_AXIS));

    }

    public void makeAdoptionFrame() {
        adoptionFrame = new JFrame("Virtual Pet Game");
        adoptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adoptionFrame.setSize(frameWidth, frameHeight);
        adoptionFrame.setResizable(false);
        adoptionFrame.setLocationRelativeTo(null);
        adoptionFrame.setVisible(true);
    }

}
