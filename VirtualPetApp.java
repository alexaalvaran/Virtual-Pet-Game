/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author alei
 */
import java.util.*;

public class VirtualPetApp {

    static int menuOption;

    public static void main(String[] args) {
        //Variables
        Scanner keyboard = new Scanner(System.in);
        GameManager petGame = new GameManager();
        int welcomeInput = 0;
        //User input - try and catch 

        try {
            welcomeInput = petGame.welcomeMenu(keyboard);
        } catch (InputMismatchException e) {
            System.out.println("Not an option! Please try again");
            keyboard.next();
            welcomeInput = petGame.welcomeMenu(keyboard);

        }

        if (welcomeInput == 1 || welcomeInput == 2) {
            do {
                menuOption = petGame.menuOption();

            } while (menuOption != 8);

            //End of game
        }

    }

}
