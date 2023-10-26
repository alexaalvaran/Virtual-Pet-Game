/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author alei
 */
public class Pet {

    //Variables
    private String petName;
    private String petType;

    //Default constructor
    public Pet() {

    }

    //Constructor
    public Pet(String petName, String petType) {
        this.petName = petName;
        this.petType = petType;
    }

    //Get and set methods for variables
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

}
