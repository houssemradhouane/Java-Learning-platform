/**
 * Jouer_GUI
 * @author Flavien Mithieux
 * Description : Main GUI of the project with a modern-style UI,
 *               the GUI is a JFrame using various JPanel
 */

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
        setTitle("Apprendre Java");
        setSize(800,600);
        getContentPane().setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon icone = new ImageIcon("images/icon.png");
        setIconImage(icone.getImage());
        
        // different windows of the application
        // better to use panels than multiple frames
        // CardLayout is used to swap from one to another
        JPanel GUI_Main = new GUI_Main();      

        CardLayout layout = new CardLayout(10,10);   
        setLayout(layout);
        
        add("Main", GUI_Main);
        
        layout.show(getContentPane(), "Main");
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new Jouer_GUI();
    }
}