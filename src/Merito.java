import javax.swing.JFrame;

public class Merito {
    public static void main (String[] args) throws Exception {
        int boardWidth = 360;
        int boardHeight = 640;

        JFrame frame = new JFrame("Merito Tap!");   
        frame.setVisible(true); // Make the frame with game name visible
        frame.setSize(boardWidth, boardHeight); //Impliments the size of the window that we specified in the variables above
        frame.setLocationRelativeTo(null); //places the windows in the center of the screen
        frame.setResizable(false); //makes the window not resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the window when the user clicks on the close button
        

        MeritoBird meritoBird = new MeritoBird(); //creates an instance of the MeritoBird class
        frame.add(meritoBird); //adds the instance of the MeritoBird class to
        frame.pack(); //adds the instance of the MeritoBird class to the frame
        frame.setVisible(true);
        
    }
}