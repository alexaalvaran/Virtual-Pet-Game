/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

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
public class WelcomeFrame {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight / 2;

    private JFrame welcomeFrame;
    private JPanel welcomePanel;
    private JButton newGame = new JButton("Play new game");
    private JButton existingGame = new JButton("Play existing game");
    private JButton explainGame = new JButton("Explain the game");
    private JButton quitGame = new JButton("Quit");

    public WelcomeFrame() {
        welcomeFrame = new JFrame("Virtual Pet App");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(frameWidth, frameHeight);
        welcomeFrame.setResizable(false);
        welcomeFrame.setLocationRelativeTo(null);

        welcomeMenu();
        welcomeFrame.add(welcomePanel);

        welcomeFrame.setVisible(true);

    }

    //Creating the welcome menu : buttons
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
                    AdoptionFrame adoptionFrame = new AdoptionFrame();
                }
            }
        });

        existingGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.dispose();
                AdoptionFrame adoptionFrame = new AdoptionFrame();
                adoptionFrame.getAdoptionFrame().remove(adoptionFrame.getAdoptionPanel());
                adoptionFrame.getAdoptionFrame().remove(adoptionFrame.getNewPetPanel());
                adoptionFrame.getSubmitPlayerName().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adoptionFrame.getAdoptionFrame().dispose();
                MainFrame mainFrame = new MainFrame();
            }
        });


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

}
