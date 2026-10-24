import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel; //store all the pipes in the game

public class MeritoBird extends JPanel {

    int boradWidth = 360; //width of the game window
    int boradHeight = 640; //height of the game window

    //Images 
    Image mbackgroundImg;
    Image birdImg;
    Image topPipeImg;
    

    MeritoBird() {
        setPreferredSize(new Dimension(boradWidth, boradHeight)); //set the size of the game window
        setBackground(Color.blue); //set the background color of the game window



    }
}




