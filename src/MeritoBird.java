package main.java.Merito_Tap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MeritoBird extends JPanel implements ActionListener {

    int boardWidth = 360; //width of the game window
    int boardHeight = 640; //height of the game window

    //Images 
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg; //load the top pipe image
    Image bottomPipeImg;

    //Bird
    int brirdX = boardWidth/8; // x position of the bird
    int birdY = boardHeight/2; // y position of the bird
    int birdWidth = 51; //width of the bird
    int birdHeight = 36; //height of the bird

    class Bird {
        int x = brirdX; // x position of the bird
        int y = birdY; // y position of the bird
        int width = birdWidth; //width of the bird
        int height = birdHeight; //height of the bird
        Image img;

        Bird(Image img) {
            this.img = img; //set the image of the bird
        }
    }

    //game logic
    Bird bird;
    int velocityY = 0; //velocity of the bird in the y direction

    Timer gameLoop; //create an instance of the Timer class to control the game loop

    MeritoBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight)); //set the size of the game window
        setBackground(Color.blue); //set the background color of the game window

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("./assets/meritotapbg.png")).getImage(); //load the background image
        birdImg = new ImageIcon(getClass().getResource("./assets/meritoup.png")).getImage(); //load the bird image
        topPipeImg = new ImageIcon(getClass().getResource("./assets/toppillar.png")).getImage(); //  load the top pipe image
        bottomPipeImg = new ImageIcon(getClass().getResource("./assets/bottompillar.png")).getImage(); //load the bottom pipe image

        //bird
        bird = new Bird(birdImg); //create an instance of the Bird class

        //game timer
        gameLoop = new Timer(1000/60, this); //Makes sure game runs at 60 frames per second
        gameLoop.start(); //start the game loop



    } 

    @Override
    public void paintComponent(Graphics g) { //override the paintComponent method to draw the images on the game window
        super.paintComponent(g); //call the paintComponent method of the JPanel class to draw the background color
        draw(g);
    }

    public void draw(Graphics g) {
        System.out.println("Draw"); //print "Drawing" to the console to check if the draw method is being called
        //background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null); //draw the background image on the game window

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null); //draw the bird image on the game window

    }
    @Override 
    public void actionPerformed(ActionEvent e) { //override the actionPerformed method to update the game logic
        repaint(); //repaint the game window
    }
}




