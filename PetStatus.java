/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author alei
 */
public class PetStatus {

    //Variables
    private int happiness;
    private int hunger;
    private int thirst;
    private int energy;
    private int hygiene;
    private int friendship;

    //Default constructor
    public PetStatus() {
        this.setEnergy(80);
        this.setHappiness(20);
        this.setHunger(35);
        this.setThirst(35);
        this.setHygiene(100);
        this.setFriendship(5);
    }

    //Methods to increase and decrease variables
    public void increaseHunger(int amount) {
        if (this.getHunger() < 100) {
            this.setHunger(hunger + amount);
        }
    }

    public void increaseEnergy(int amount) {
        if (this.getEnergy() < 100) {
            this.setEnergy(energy + amount);
        }

    }

    public void increaseHappiness(int amount) {
        if (this.getHappiness() < 100) {
            this.setHappiness(happiness + amount);
        }

    }

    public void increaseThirst(int amount) {
        if (this.getThirst() < 100) {
            this.setThirst(thirst + amount);
        }

    }

    public void increaseHygiene(int amount) {
        if (this.getHygiene() < 100) {
            this.setHygiene(hygiene + amount);
        }

    }

    public void increaseFriendship(int amount) {
        if (this.getFriendship() < 100) {
            this.setFriendship(friendship + amount);
        }
    }

    public void decreaseHunger(int amount) {
        if (this.getHunger() > 0) {
            this.setHunger(hunger - amount);
        }

    }

    public void decreaseEnergy(int amount) {
        if (this.getEnergy() > 0) {
            this.setEnergy(energy - amount);
        }

    }

    public void decreaseHappiness(int amount) {
        if (this.getHappiness() > 0) {
            this.setHappiness(happiness - amount);
        }

    }

    public void decreaseThirst(int amount) {
        if (this.getThirst() > 0) {
            this.setThirst(thirst - amount);
        }

    }

    public void decreaseHygiene(int amount) {
        if (this.getHygiene() > 0) {
            this.setHygiene(hygiene - amount);
        }

    }

    public void decreaseFriendship(int amount) {
        if (this.getFriendship() > 0) {
            this.setFriendship(friendship - amount);
        }

    }

    //Get and set methods
    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if (happiness > 0 && happiness <= 100) {
            this.happiness = happiness;
        }
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        if (hunger > 0 && hunger <= 100) {
            this.hunger = hunger;
        }
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        if (thirst > 0 && thirst <= 100) {
            this.thirst = thirst;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy > 0 && energy <= 100) {
            this.energy = energy;
        }
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        if (hygiene > 0 && hygiene <= 100) {
            this.hygiene = hygiene;
        }
    }

    public int getFriendship() {
        return friendship;
    }

    public void setFriendship(int friendship) {
        if (friendship > 0 && friendship <= 100) {
            this.friendship = friendship;
        }
    }

}
