/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author alei
 */
public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        this.stats.increaseHunger(5);
        this.stats.increaseHappiness(5);
        this.stats.decreaseThirst(5);
        this.stats.decreaseHygiene(5);
        this.stats.increaseEnergy(10);
    }

    @Override
    public void drink() {
        this.stats.increaseThirst(5);
    }

    @Override
    public void play() {
        this.stats.increaseHappiness(10);
        this.stats.decreaseEnergy(10);
        this.stats.increaseFriendship(10);
        this.stats.decreaseHunger(10);
        this.stats.decreaseThirst(5);
        this.stats.decreaseHygiene(5);
    }

    @Override
    public void pet() {
        this.stats.increaseHappiness(10);
        this.stats.increaseFriendship(10);
    }

    @Override
    public void bathe() {
        this.stats.increaseHygiene(10);
        this.stats.decreaseEnergy(5);
    }

    @Override
    public void groom() {
        this.stats.increaseHygiene(10);
        this.stats.increaseHappiness(10);
    }

    @Override
    public void walk() {
        this.stats.increaseFriendship(10);
        this.stats.increaseHappiness(10);
        this.stats.decreaseEnergy(20);
        this.stats.decreaseHunger(20);
        this.stats.decreaseThirst(20);
        this.stats.decreaseHygiene(20);
    }

    @Override
    public void sleep() {
        this.stats.increaseEnergy(80);
    }

    @Override
    public void speak() {
        System.out.println("Tweet!");
    }

}
