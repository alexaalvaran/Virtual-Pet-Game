/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alei
 */

//MainModel class which handles the methods for main view and main controller
public class MainModel {

    //Variables
    private GameDBManager db = new GameDBManager();
    private PetStats stats;
    private Player player;
    private Pet pet;
    
    //Stats variables
    private int hunger = 0;
    private int thirst = 0;
    private int energy = 0;
    private int hygiene = 0;
    private int happiness = 0;
    private int friendship = 0;

    //Constructor
    public MainModel(Player player, Pet pet, PetStats stats) {
        this.player = player;
        this.pet = pet;
        this.stats = stats;
    }

    //Loads an existing game from database 
    public void loadExistingGame() {
        //Checks if player exists first
        if (db.findExistingPlayer(this.player.getPlayerName())) {
            
            //Sets the stats value to existing values
            
            hunger = db.loadHunger(player.getPlayerName());
            thirst = db.loadThirst(player.getPlayerName());
            energy = db.loadEnergy(player.getPlayerName());
            hygiene = db.loadHygiene(player.getPlayerName());
            happiness = db.loadHappiness(player.getPlayerName());
            friendship = db.loadFriendship(player.getPlayerName());
            
        } else {
            //If player does not exist - sets stats values to default values
            hunger = 30;
            thirst = 30;
            energy = 80;
            hygiene = 80;
            happiness = 5;

        }
        //Set the stats (the progress bars) to have the corresponding set values
        stats.getHungerStat().setValue(hunger);
        stats.getHappinessStat().setValue(happiness);
        stats.getThirstStat().setValue(thirst);
        stats.getEnergyStat().setValue(energy);
        stats.getFriendshipStat().setValue(friendship);
        stats.getHygieneStat().setValue(hygiene);
    }

    //Play method which increase and decreases corresponding values and sets stats bars
    public void play() {
        hunger -=20;
        happiness += 5;
        thirst -= 10;
        energy -= 20;
        friendship += 10;
        hygiene -= 10;
        
        stats.getHungerStat().setValue(hunger);
        stats.getHappinessStat().setValue(happiness);
        stats.getThirstStat().setValue(thirst);
        stats.getEnergyStat().setValue(energy);
        stats.getFriendshipStat().setValue(friendship);
        stats.getHygieneStat().setValue(hygiene);
    }

    //Walk method which increase and decrease corresponding values and sets stats bars
    public void walk() {
        hunger -= 10;
        happiness += 15;
        thirst -= 10;
        energy -= 10;
        friendship += 10;
        hygiene -= 5;
        
        stats.getHungerStat().setValue(hunger);
        stats.getHappinessStat().setValue(happiness);
        stats.getThirstStat().setValue(thirst);
        stats.getEnergyStat().setValue(energy);
        stats.getFriendshipStat().setValue(friendship);
        stats.getHygieneStat().setValue(hygiene);
    }

    //Feed method which increases and decreases corresponding values and sets stats bars
    public void feed() {
        hunger += 10;
        happiness += 5;
        thirst -= 10;
        energy += 10;
        friendship += 10;
        hygiene -= 5;
        
         stats.getHungerStat().setValue(hunger);
        stats.getHappinessStat().setValue(happiness);
        stats.getThirstStat().setValue(thirst);
        stats.getEnergyStat().setValue(energy);
        stats.getFriendshipStat().setValue(friendship);
        stats.getHygieneStat().setValue(hygiene);
        
    }

    //Water method which increases thirst value and sets thirst bar stat
    public void water() {
        
        thirst += 10;
        
        stats.getThirstStat().setValue(thirst);
        
        
    }

    //Groom method which increases and decreases corresponding values and sets stats bars
    public void groom() {
        happiness += 5;
        energy -= 5;
        friendship += 10;
        hygiene += 20;
        
        
        stats.getHappinessStat().setValue(happiness);
        stats.getEnergyStat().setValue(energy);
        stats.getFriendshipStat().setValue(friendship);
        stats.getHygieneStat().setValue(hygiene);

    }

    //Sleep method which increases energy value and sets energy bar stat
    public void sleep() {
        energy += 30;
        
         stats.getEnergyStat().setValue(energy);
    }
    
    //Reset stats to all = 0
    public void reset()
    {
        int reset = 0;
        
        stats.getHungerStat().setValue(reset);
        stats.getHappinessStat().setValue(reset);
        stats.getThirstStat().setValue(reset);
        stats.getEnergyStat().setValue(reset);
        stats.getFriendshipStat().setValue(reset);
        stats.getHygieneStat().setValue(reset);
    }
    

    //Saves the game using the database method
    public void saveGame() {
        db.saveGame(player.getPlayerName(), pet.getPetName(), stats.getHungerValue(), stats.getThirstValue(), stats.getEnergyValue(), stats.getHygieneValue(), stats.getHappinessValue(), stats.getFriendshipValue());
    }

}
