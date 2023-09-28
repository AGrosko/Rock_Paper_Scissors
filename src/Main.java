import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        /**
         * The main method creates an instance of rpsFrame
         * and sets its dimensions based on the size of the screen
         * and centers the window on the users screen.
         */

        rpsFrame frame = new rpsFrame();

        frame.setTitle("Rock Paper Scissors");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (dimension.width)/2+ (dimension.width)/4;
        int height  = (dimension.height)/2 + (dimension.height)/4;
        int x = (dimension.width - width) / 2;
        int y = (dimension.height - height) / 2;
        frame.setLocation(x,y);
        frame.setSize(width,height);
        System.out.println(dimension.width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }




}