import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
/**
 * @author Salahdine Ouhmmiali v 1.0
 */
public class SupportCours extends JPanel {
	JButton tests,cours,quitter;
    static boolean go  = false ;
    static boolean cour = false;
    int numero = Themes.numero;
    SupportCours(JFrame window){
    	 setSize(window.getSize().width,window.getSize().height);
         setLayout(null);
         setBackground(Color.DARK_GRAY);
         window.setContentPane(this);
         /* Bouton pour aller vers les tests */
         tests = new JButton ("Tests");
         tests.setBackground(new Color(255,255,255)) ;
         tests.setBounds(300,100,200,50);
         add(tests);
         /* Bouton pour aller vers le cours */
         cours = new JButton ("Cours");
         cours.setBackground(new Color(255,255,255)) ;
         cours.setBounds(300,200,200,50);
         add(cours);
         /* Bouton pour quitter */
         quitter = new JButton ("Quiter");
         quitter.setBackground(new Color(255,255,255)) ;
         quitter.setBounds(300,300,200,50);
         add(quitter);
         
         window.setVisible(true);
         
    }
/* Ajouter les actions à chaque bouton */
void choose () {
        
        tests.addActionListener((ActionEvent e) -> {
            go = true ;
            setVisible(false);
            cour=false;
        });
        cours.addActionListener((ActionEvent e) -> {
            cour  = true; 
            new Cours(numero);
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
