/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author alei
 */

//This class contains the Pet stats which is displayed as a progress bar 
public class PetStats {

    //JProgressBar variables
    private JProgressBar hungerStat = new JProgressBar(0, 100);
    private JProgressBar thirstStat = new JProgressBar(0, 100);
    private JProgressBar energyStat = new JProgressBar(0, 100);
    private JProgressBar hygieneStat = new JProgressBar(0, 100);
    private JProgressBar happinessStat = new JProgressBar(0, 100);
    private JProgressBar friendshipStat = new JProgressBar(0, 100);

    //values to pass to the progress bars
    private int hungerValue;
    private int thirstValue;
    private int energyValue;
    private int hygieneValue;
    private int happinessValue;
    private int friendshipValue;

    //Default constructor 
    public PetStats() {
        this.hungerValue = 30;
        this.thirstValue = 30;
        this.energyValue = 80;
        this.hygieneValue = 80;
        this.happinessValue = 5;
        this.friendshipValue = 0;

        this.hungerStat.setValue(hungerValue);
        this.thirstStat.setValue(thirstValue);
        this.energyStat.setValue(energyValue);
        this.hygieneStat.setValue(hygieneValue);
        this.happinessStat.setValue(happinessValue);
        this.friendshipStat.setValue(friendshipValue);

        hungerStat.setStringPainted(true);
        thirstStat.setStringPainted(true);
        energyStat.setStringPainted(true);
        hygieneStat.setStringPainted(true);
        happinessStat.setStringPainted(true);
        friendshipStat.setStringPainted(true);
    }

    //Get and set values for the variables
    public JProgressBar getHungerStat() {
        return hungerStat;
    }

    public JProgressBar getThirstStat() {
        return thirstStat;
    }

    public JProgressBar getEnergyStat() {
        return energyStat;
    }

    public JProgressBar getHygieneStat() {
        return hygieneStat;
    }

    public JProgressBar getHappinessStat() {
        return happinessStat;
    }

    public JProgressBar getFriendshipStat() {
        return friendshipStat;
    }

    public int getHungerValue() {
        return hungerValue;
    }

    public int getThirstValue() {
        return thirstValue;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public int getHygieneValue() {
        return hygieneValue;
    }

    public int getHappinessValue() {
        return happinessValue;
    }

    public int getFriendshipValue() {
        return friendshipValue;
    }


}
