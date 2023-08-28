/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author alei
 */
public abstract class Animal implements AnimalActions {

    //Variables
    private String name;
    PetStatus stats;

    //Constructor
    public Animal(String name) {
        this.setName(name);
        stats = new PetStatus();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
