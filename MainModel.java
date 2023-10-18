/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alei
 */
public class MainModel
{
    private GameDBManager db = new GameDBManager();
    private PetStats stats;
    private Player player;
    private Pet pet;
    
    public MainModel(Player player, Pet pet, PetStats stats)
    {
     this.player = player;
     this.pet = pet;
     this.stats = stats;
    }
    
    public void loadExistingGame()
    {
        if(db.findExistingPlayer(this.player.getPlayerName()))
      {
          if(db.findExistingPet(this.pet.getPetName()))
          {
        stats.setHungerValue(db.loadHunger(player.getPlayerName(), pet.getPetName()));
        stats.setThirstValue(db.loadThirst(player.getPlayerName(), pet.getPetName()));
        stats.setEnergyValue(db.loadEnergy(player.getPlayerName(), pet.getPetName()));
        stats.setHygieneValue(db.loadHygiene(player.getPlayerName(), pet.getPetName()));
        stats.setHappinessValue(db.loadHappiness(player.getPlayerName(), pet.getPetName()));
        stats.setFriendshipValue(db.loadFriendship(player.getPlayerName(), pet.getPetName()));
          }
          else
          {
              stats.setHungerValue(30);
              stats.setThirstValue(30);
              stats.setThirstValue(80);
              stats.setHygieneValue(80);
              stats.setHappinessValue(5);
          }
        stats.getHungerStat().setValue(stats.getHungerValue());
        stats.getHappinessStat().setValue(stats.getHappinessValue());
        stats.getThirstStat().setValue(stats.getThirstValue());
        stats.getEnergyStat().setValue(stats.getEnergyValue());
        stats.getFriendshipStat().setValue(stats.getFriendshipValue());
        stats.getHygieneStat().setValue(stats.getHygieneValue());
        
          System.out.println("stats loaded");
          
      }
        
        else
        {
            System.out.println("??");
        }
        
   
    }
    public void play()
    {
        stats.setHungerValue(stats.getHungerValue() + 5);
        stats.getHungerStat().setValue(stats.getHungerValue());
        
      
        stats.getHappinessStat().setValue(stats.getHappinessValue() + 5);
        stats.getThirstStat().setValue(stats.getThirstValue() -5);
        stats.getEnergyStat().setValue(stats.getEnergyValue() -5);
        stats.getFriendshipStat().setValue(stats.getFriendshipValue() + 2);
        stats.getHygieneStat().setValue(stats.getHygieneValue() - 2);
    }
    
    public void walk()
    {
        stats.getHungerStat().setValue(stats.getHungerValue()- 10);
        stats.getHappinessStat().setValue(stats.getHappinessValue() + 5);
        stats.getThirstStat().setValue(stats.getThirstValue() -10);
        stats.getEnergyStat().setValue(stats.getEnergyValue() -10);
        stats.getFriendshipStat().setValue(stats.getFriendshipValue() + 5);
        stats.getHygieneStat().setValue(stats.getHygieneValue() - 5);
    }
    
    public void feed()
    {
        stats.setHungerValue(stats.getHungerValue() + 5);
        stats.getHungerStat().setValue(stats.getHungerValue());
        
        stats.getHappinessStat().setValue(stats.getHappinessValue() + 5);
        stats.getThirstStat().setValue(stats.getThirstValue() -2);
        stats.getEnergyStat().setValue(stats.getEnergyValue() +1);
        stats.getFriendshipStat().setValue(stats.getFriendshipValue() + 2);
        stats.getHygieneStat().setValue(stats.getHygieneValue() - 2);
    }
    
    public void water()
    {  
        stats.getThirstStat().setValue(stats.getThirstValue() +10);
    }
    
    public void groom()
    {
        stats.getHappinessStat().setValue(stats.getHappinessValue() + 5);
        stats.getEnergyStat().setValue(stats.getEnergyValue() - 5);
        stats.getFriendshipStat().setValue(stats.getFriendshipValue() + 5);
        stats.getHygieneStat().setValue(stats.getHygieneValue() + 20);
    }
    
    public void sleep()
    {
         stats.getEnergyStat().setValue(stats.getEnergyValue() + 30);
    }
    
    public void saveGame()
    {
        db.saveGame(player.getPlayerName(), pet.getPetName(), stats.getHungerValue(), stats.getThirstValue(), stats.getEnergyValue(), stats.getHygieneValue(), stats.getHappinessValue(), stats.getFriendshipValue());
    }
}
