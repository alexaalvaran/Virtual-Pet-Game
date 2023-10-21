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
public class PetStats 
{
    private JProgressBar hungerStat = new JProgressBar(0, 100);
    private JProgressBar thirstStat = new JProgressBar(0, 100);
    private JProgressBar energyStat = new JProgressBar(0, 100);
    private JProgressBar hygieneStat = new JProgressBar(0, 100);
    private JProgressBar happinessStat = new JProgressBar(0, 100);
    private JProgressBar friendshipStat = new JProgressBar(0, 100);
   
    private int hungerValue;
    private int thirstValue;
    private int energyValue;
    private int hygieneValue;
    private int happinessValue;
    private int friendshipValue;
    
    public PetStats()
    {
        this.hungerValue = 30;
        this.thirstValue = 30;
        this.energyValue = 80;
        this.hygieneValue = 80;
        this.happinessValue = 5;
        this.friendshipValue = 0 ;
        
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

    public void setHungerValue(int hungerValue) {
        this.hungerValue = hungerValue;
    }

    public void setThirstValue(int thirstValue) {
        this.thirstValue = thirstValue;
    }

    public void setEnergyValue(int energyValue) {
        this.energyValue = energyValue;
    }

    public void setHygieneValue(int hygieneValue) {
        this.hygieneValue = hygieneValue;
    }

    public void setHappinessValue(int happinessValue) {
        this.happinessValue = happinessValue;
    }

    public void setFriendshipValue(int friendshipValue) {
        this.friendshipValue = friendshipValue;
    }
    
}
