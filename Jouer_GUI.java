/**
 * Jouer_GUI
 * @author Flavien Mithieux
 * Description : Main GUI of the project with a modern-style UI,
 *               the GUI is a JFrame using various JPanel
 */

//TODO implementation with other classes
//TODO menu wasn't working, showing only big icons


import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.*;

public class Jouer_GUI extends JFrame {

    Jouer_GUI() {

        // modern look for Swing API
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception e ) {
            System.err.println( "Failed to initialize LookAndFeel," );
            System.err.println( "check that the flatlaf-1.1.2.jar is referenced in classpath." );
        }
        
        // different windows of the application
        // better to use panels than multiple frames
        // CardLayout is used to swap from one to another
        JPanel main_GUI = new Main_GUI();      

        CardLayout layout = new CardLayout();
        setLayout(layout);
        
        add("Main", main_GUI);
        //layout.next(getContentPane());
        //svn co http://cregut.svn.enseeiht.fr/2020/1sn/tob/pl/XX-N
        
        setTitle("Apprendre Java");
        setSize(800,600);

        ImageIcon icone = new ImageIcon("images/icon.png");
        setIconImage(icone.getImage());

        layout.first(getContentPane());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new Jouer_GUI();
    }

}
