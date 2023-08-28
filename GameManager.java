/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;

/**
 *
 * @author alei
 */
public class GameManager {

    private UserOptions userInput = new UserOptions();
    private Animal anAnimal;
    private String petName;
    private SaveGame saveGame = new SaveGame();
    private HashMap<String, String> savedGames = saveGame.readFile();

    //Opening menu 
    public int welcomeMenu(Scanner sc) {
        userInput.welcMenu();
        int welcomeInput = sc.nextInt();

        switch (welcomeInput) {
            case 1:
                System.out.println("Pick an animal to adopt");
                System.out.println("[1] Dog");
                System.out.println("[2] Cat");
                System.out.println("[3] Bird");
                this.animalAdoption(sc);
                break;

            case 2:
                saveGame.checkExisting(userInput.getPlayerName(), savedGames); // There is no animal assocaited with this!!!!
                //Try a diff collection ??????
               
                break;

            case 3:
                System.out.println("This is a virtual pet game where you can adopt different dogs, cats, or birds and take care of them. \n"
                        + "You can feed, play with, bathe, groom, and walk with your pet which increases your friendship level.\n"
                        + "Make sure to keep taking care of your pet to keep their levels up and your friendship level high!\n "
                        + "Have fun :)");
                welcomeMenu(sc);
                break;

            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("This is not an option. Please try again!");
                welcomeMenu(sc);
        }

        return welcomeInput;
    }

    //Adopting a new pet 
    private void animalAdoption(Scanner sc) {
        Scanner keyboard = new Scanner(System.in);
        int animalAdoption = sc.nextInt();
        System.out.println("Pick a name for your new pet: ");
        this.setPetName(keyboard.nextLine());

        switch (animalAdoption) {
            case 1:
                anAnimal = new Dog(petName);
                break;

            case 2:
                anAnimal = new Cat(petName);
                break;

            case 3:
                anAnimal = new Bird(petName);
                break;

        }

        System.out.println("Welcome home " + anAnimal.getName() + "!");
    }

    public int menuOption() {
        int input = userInput.dispMenu();

        switch (input) {
            case 1:
                anAnimal.play();
                System.out.println("I had a fun time playing with you!");
                userInput.dispStatus(anAnimal);
                userInput.lowStatus(anAnimal);
                break;

            case 2:
                anAnimal.walk();
                userInput.dispStatus(anAnimal);
                userInput.lowStatus(anAnimal);
                break;

            case 3:
                anAnimal.eat();
                userInput.dispStatus(anAnimal);
                userInput.lowStatus(anAnimal);
                break;

            case 4:
                anAnimal.drink();
                userInput.dispStatus(anAnimal);
                userInput.lowStatus(anAnimal);

            case 5:
                anAnimal.bathe();
                userInput.dispStatus(anAnimal);
                userInput.lowStatus(anAnimal);
                break;

            case 6:
                anAnimal.sleep();
                userInput.dispStatus(anAnimal);
                userInput.lowStatus(anAnimal);
                break;

            case 7:
                System.out.println(anAnimal.getName() + "'s stats: ");
                userInput.dispStatus(anAnimal);
                userInput.lowStatus(anAnimal);
                break;

            case 8:
                savedGames.put(userInput.getPlayerName(), this.getPetName());
                saveGame.writeToFile(savedGames);
                System.out.println("Game saved! See you again soon :) <3");

            default:
                anAnimal.speak();
                break;

        }

        return input;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

}
