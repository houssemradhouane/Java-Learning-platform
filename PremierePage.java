import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/* Afficher la premiere page de l'interface graphique */
public class PremierePage extends JPanel {
	JButton themes,quitter;
    static boolean go  = false ;
    PremierePage(JFrame window){
    	 setSize(window.getSize().width,window.getSize().height);
         setLayout(null);
         setBackground(Color.DARK_GRAY);
         window.setContentPane(this);
         
         themes = new JButton ("Jouer");
         themes.setBackground(new Color(255,255,255)) ;
         themes.setBounds(300,150,200,50);
         add(themes);
         
         quitter = new JButton ("Quiter");
         quitter.setBackground(new Color(255,255,255)) ;
         quitter.setBounds(300,250,200,50);
         add(quitter);
         
         window.setVisible(true);
         
    }
/* Ajouter les actions pour chaque bouton */
void choose () {
        
        themes.addActionListener((ActionEvent e) -> {
            go = true ;
            setVisible(false);
        });
       
        quitter.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        while (!go) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {}
        }
        
        go = false ;
    
    }
}


