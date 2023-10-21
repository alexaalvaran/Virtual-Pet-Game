/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alei
 */
public class Animal extends Thread {

    private int x;
    private int y;
    private int vx;
    private int vy;
    private int destination_x;
    private int destination_y;

    public Animal() {
        x = 0;
        y = 0;
        vx = 0;
        vy = 0;
    }

    public void run() {
        while (true) {
            moveToDestination(destination_x, destination_y);
            x += vx;
            y += vy;

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void moveToDestination(int destination_x, int destination_y) {
        if (x < destination_x) {
            vx = 1;
        } else if (x > destination_x) {
            vx = -1;
        } else {
            vx = 0;
        }

        if (y < destination_y) {
            vy = 1;
        } else if (y > destination_y) {
            vy = -1;
        } else {
            vy = 0;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getDestination_x() {
        return destination_x;
    }

    public void setDestination_x(int destination_x) {
        this.destination_x = destination_x;
    }

    public int getDestination_y() {
        return destination_y;
    }

    public void setDestination_y(int destination_y) {
        this.destination_y = destination_y;
    }

}
