package main.java.Merito_Tap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter; // NEW: lets us react to mouse clicks without writing every mouse method
import java.awt.event.MouseEvent;   // NEW: the object that describes a mouse click
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Font;  

public class MeritoBird extends JPanel implements ActionListener, KeyListener {
    private static final int FRAMES_PER_SECOND = 1000 / 60; // ~ 16 ms per frame

    int boardWidth = 360; //width of the game window
    int boardHeight = 640; //height of the game window

    //Images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
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
        if (gameOver) {
            placePipesTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -6; // makes the bird jump when the space bar is pressed
            if (gameOver) {
                // Reset the game by ressetting the conditions to their initial values
                bird.y = birdY;
                velocityY = 0;
                pipes.clear();
                score = 0;
                gameOver = false;
                gameLoop.start();
                placePipesTimer.start();
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    class Bird {
        int x = birdX;
        double y = birdY; // now a double so slow movement isn't rounded away
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
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
    double velocityY = 1; // was int
    double gravity = 0.5; // was int 1

    ArrayList<Pipe> pipes;
    Random random = new Random();

    Timer gameLoop;
    Timer placePipesTimer;
    boolean gameOver = false;
    double score = 0;

    MeritoBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        addKeyListener(this);

        // NEW: start of the mouse click feature
        addMouseListener(new MouseAdapter() { // NEW: attaches a mouse listener to this panel
            @Override
            public void mousePressed(MouseEvent e) { // NEW: runs every time a mouse button is pressed on the game
                requestFocusInWindow(); // NEW: keeps keyboard focus on the game so space still works after clicking
                velocityY = -6; // NEW: makes the bird jump, same as pressing space
                if (gameOver) { // NEW: if the game is over, a click restarts it, same as space
                    bird.y = birdY;          // NEW: puts the bird back at its starting height
                    velocityY = 0;           // NEW: stops any leftover movement
                    pipes.clear();           // NEW: removes all pipes from the screen
                    score = 0;               // NEW: resets the score
                    gameOver = false;        // NEW: the game is running again
                    gameLoop.start();        // NEW: restarts the frame timer
                    placePipesTimer.start(); // NEW: restarts the pipe spawner
                }
            }
        });
        // NEW: end of the mouse click feature

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("/assets/meritotapbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("/assets/meritoup.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("/assets/toppillar.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("/assets/bottompillar.png")).getImage();

        //bird
        bird = new Bird(birdImg);
        pipes = new ArrayList<Pipe>();

        placePipesTimer = new Timer(1500, (e) -> placePipes());
        placePipesTimer.start();
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void placePipes() {
        int randomPipeY = (int) (pipeY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openingSpace = boardHeight / 6; //space between the top and bottom pipes

        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y + pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);

        //bird
        g.drawImage(bird.img, bird.x, (int) bird.y, bird.width, bird.height, null);

        //pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        //score
        g.setColor(Color.white);
        g. setFont(new Font("Oxanium", Font.BOLD, 26));
        if (gameOver) {
            g.drawString("Score: " + String.valueOf((int) score), 10, 35);
        }
        else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    public void move() {
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0);

        //pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;

            if (!pipe.passed && bird.x > pipe.x + pipe.width) {
                pipe.passed = true;
                score += 0.5; // Increment score by 0.5 for each pipe passed, because they are double pipes (top and bottom)
            }




            if (checkCollision(bird, pipe)) {
                gameOver = true;
            }
        }

        if (bird.y > boardHeight) {
            gameOver = true;
        }
    }

    public boolean checkCollision(Bird a, Pipe b) {
        int birdMargin = 6; // shrinks the bird's hitbox
        int padX = 8;       // transparent space on the pipe's sides
        int padY = 50;      // transparent space at the pipe's cap end

        int pipeTop = b.y;
        int pipeBottom = b.y + b.height;
        if (b.img == topPipeImg) {
            pipeBottom -= padY; // cap is at the bottom of the top pipe
        } else {
            pipeTop += padY;    // cap is at the top of the bottom pipe
        }

        return a.x + birdMargin < b.x + b.width - padX &&
                a.x + a.width - birdMargin > b.x + padX &&
                a.y + birdMargin < pipeBottom &&
                a.y + a.height - birdMargin > pipeTop;
    }
}