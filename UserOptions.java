/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author alei
 */
public class UserOptions {

    Scanner input = new Scanner(System.in);
    private String playerName;

    public void welcMenu() {
        System.out.println("Enter your name: ");
        this.setPlayerName(input.nextLine());
        Player aPlayer = new Player(playerName);

        System.out.println("Hi " + aPlayer.getName() + "! Welcome to Virtual Pet Game :)!");
        System.out.println("Choose an option below:");
        System.out.println("[1] Play New Game");
        System.out.println("[2] Play Existing Game ");
        System.out.println("[3] Explain the game");
        System.out.println("[4] Quit");

    }

    //Display the action menu 
    public int dispMenu() {
        int menuInput = 0;

        System.out.println("What would you like to do next?");
        System.out.println("[1] Play");
        System.out.println("[2] Go for a Walk");
        System.out.println("[3] Feed");
        System.out.println("[4] Drink water");
        System.out.println("[5] Wash and Groom ");
        System.out.println("[6] Sleep");
        System.out.println("[7] Display Status");
        System.out.println("[8] Save Game");

        try {
            menuInput = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Not an option! Please try again");
            input.next();
            menuInput = input.nextInt();
        }
        return menuInput;
    }

    //Display pet status
    public void dispStatus(Animal aPet) {
        //Displaying the wrong stats
        System.out.print("Thirst: " + aPet.stats.getThirst());
        System.out.print("   Hunger: " + aPet.stats.getHunger());
        System.out.print("   Energy: " + aPet.stats.getEnergy());
        System.out.print("   Hygiene: " + aPet.stats.getHygiene());
        System.out.print("   Happiness: " + aPet.stats.getHappiness());
        System.out.println("  Friendship: " + aPet.stats.getFriendship() + "\n");
    }

    public void lowStatus(Animal aPet) {

        if (aPet.stats.getEnergy() < 5) {
            System.out.println("*YAWN* " + aPet.getName() + " is starting to feel sleepy!\n Hooo I can barely keep my eyes open! Time to sleep.");
        }

        if (aPet.stats.getHappiness() < 10) {
            System.out.println("Wahhhh! " + aPet.getName() + " is feeling sad!\n I'm feeling so down right now. Please cheer me up.");
        }

        if (aPet.stats.getHunger() < 10) {
            System.out.println("*GRUMBLE* " + aPet.getName() + " is hungry!\n *GRUMBLE* My stomach is grumbling so hard, please feed me soon!");
        }

        if (aPet.stats.getThirst() < 10) {
            System.out.println("*PANT* " + aPet.getName() + " is thirsty!\n I can't keep going! My throat is parched, please get me water!");
        }

        if (aPet.stats.getHygiene() < 10) {
            System.out.println("Oh no! " + aPet.getName() + " stinks!\n I've been playing all day and I'm dirty! I need a shower!");
        }

        if (aPet.stats.getFriendship() < 10) {
            System.out.println("Hey! " + aPet.getName() + " needs more love!\n I've been alone for too long, please don't leave me! ");
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
