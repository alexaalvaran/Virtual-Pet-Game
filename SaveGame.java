/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author alei
 */
public class SaveGame {

    //read and write to file functions to save game 
    public HashMap<String, String> readFile() {
        HashMap<String, String> records = new HashMap();

        try {
            FileReader fr = new FileReader("/Users/alei/NetBeansProjects/ENSE600_Project1/resources/PlayerRecord.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            //Printing the records until eof
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                String[] str = line.split(" ");
                records.put(str[0], str[1]);
            }

            //closing the bufferedreader and filereader
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading from the file");
        }

        return records;
    }

    public void writeToFile(HashMap<String, String> records) {
        try {
            FileWriter fw = new FileWriter("/Users/alei/NetBeansProjects/ENSE600_Project1/resources/PlayerRecord.txt");
            PrintWriter pw = new PrintWriter(fw);

            //Printing input from keyboard to the record
            for (Map.Entry<String, String> entry : records.entrySet()) {
                pw.println(entry.getKey() + " " + entry.getValue());
            }

            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

    }

    //Need to check if game with same name alr exists ??????????
    public void checkExisting(String userName, HashMap<String, String> records) {
        //Checking if the input name matches that of the records
        if (records.containsKey(userName)) {
            System.out.println("Welcome back " + userName + "!");
        }
        
        

    }

    //Player name, pet name
}
