import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MeritoBird extends JPanel {

    int boardWidth = 360; //width of the game window
    int boardHeight = 640; //height of the game window

    //Images 
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;
    

    MeritoBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight)); //set the size of the game window
        setBackground(Color.blue); //set the background color of the game window

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("/meritotapbg.png")).getImage();
        birdImg = new ImageIcon((getClass().getResource("/meritoup.png"))).getImage();
        topPipeImg = new ImageIcon((getClass().getResource("/toppillar.png"))).getImage();
        bottomPipeImg = new ImageIcon((getClass().getResource("/bottompillar.png"))).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
    }
}




