package main.java.Merito_Tap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MeritoBird extends JPanel implements ActionListener, KeyListener {
    private static final int FRAMES_PER_SECOND = 1000 / 60; // ~ 16 frames per second

    int boardWidth = 360; //width of the game window
    int boardHeight = 640; //height of the game window

    //Images 
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg; //load the top pipe image
    Image bottomPipeImg;

    //Bird
    int birdX = boardWidth / 8; // x position of the bird
    int birdY = boardHeight / 2; // y position of the bird
    int birdWidth = 51; //width of the bird
    int birdHeight = 36; //height of the bird

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -9;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    class Bird {
        int x = birdX; // x position of the bird
        int y = birdY; // y position of the bird
        int width = birdWidth; //width of the bird
        int height = birdHeight; //height of the bird
        Image img;

        Bird(Image img) {
            this.img = img; //set the image of the bird
        }
    }

    //Pipes
    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    class Pipe {
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed = false;

        Pipe(Image img) {
            this.img = img;
        }
    }

    //game logic
    Bird bird;
    int velocityX = -4;
    int velocityY = 0;
    int gravity = 1;

    ArrayList<Pipe> pipes;

    Timer gameLoop;
    Timer placePipesTimer;

    MeritoBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight)); //set the size of the game window
        setFocusable(true);
        addKeyListener(this);

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("./assets/meritotapbg.png")).getImage(); //load the background image
        birdImg = new ImageIcon(getClass().getResource("./assets/meritoup.png")).getImage(); //load the bird image
        topPipeImg = new ImageIcon(getClass().getResource("./assets/toppillar.png")).getImage(); //  load the top pipe image
        bottomPipeImg = new ImageIcon(getClass().getResource("./assets/bottompillar.png")).getImage(); //load the bottom pipe image

        //bird
        bird = new Bird(birdImg); //create an instance of the Bird class
        pipes = new ArrayList<Pipe>();

        placePipesTimer = new Timer(1500, (e) -> placePipes());
        placePipesTimer.start();
        gameLoop = new Timer(1000 / 60, this); //game timer
        gameLoop.start(); // start the game timer

    }

    public void placePipes() {
        Pipe topPipe = new Pipe(topPipeImg);
        pipes.add(topPipe);
    }

    @Override
    protected void paintComponent(Graphics g) { //override the paintComponent method to draw the images on the game window
        super.paintComponent(g); //call the paintComponent method of the JPanel class to draw the background color
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null); //draw the background image on the game window

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null); //draw the bird image on the game window

        //pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }
    }

    public void move() {
        velocityY += gravity;
        bird.y += velocityY; //move the bird up
        bird.y = Math.max(bird.y, 0);

        //pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;
        }
    }
}




