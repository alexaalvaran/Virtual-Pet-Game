/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author alei
 */

//Moving animal handles the movement of the animal image 
public class MovingAnimal extends JPanel implements MouseListener, ComponentListener {

    //Variables
    private int width = 50;
    private int height = 50;
    private Animal pet = new Animal();
    private Image image;

    //Constructor which takes in an image to be used - which is what moves around
    public MovingAnimal(String imageName) {
        this.addMouseListener(this);
        this.addComponentListener(this);
        this.setFocusable(true);
        image = new ImageIcon(imageName).getImage().getScaledInstance(100, 200, Image.SCALE_SMOOTH);
    }

    //Paint method to pain the image 
    public void paint(Graphics g) {
        paintComponent(g);

        g.drawImage(image, pet.getX(), pet.getY(), this);

        repaint();
    }

    //Handles user mouse input - allows the image to move where the mouse clicks 
   
    @Override
    public void componentResized(ComponentEvent ce) {
        width = this.getWidth();
        height = this.getHeight();
    }

    @Override
    public void componentMoved(ComponentEvent ce) {

    }

    @Override
    public void componentShown(ComponentEvent ce) {

    }

    @Override
    public void componentHidden(ComponentEvent ce) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (!pet.isAlive()) {
            pet.start();
        }

        pet.setDestination_x(me.getX());
        pet.setDestination_y(me.getY());

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}
