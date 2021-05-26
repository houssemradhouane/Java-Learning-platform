import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
/**
 * 
 * @author Salahdine Ouhmmiali v 1.0
 *
 */
/* Afficher les thèmes sur l'interface graphique */
public class Themes extends JPanel {
	JButton th1,th2,th3,th4,th5,th6;
	static int numero; // pour désigner le theme choisi par l'utilisateur
        static boolean go  = false ;
  /*  Constructeur de la frame Themes */
    Themes(JFrame window){
    	setSize(window.getSize().width,window.getSize().height);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        window.setContentPane(this);
        th1 = new JButton ("Types de données");
        th1.setBackground(new Color(255,255,255)) ;
        th1.setBounds(300,50,200,50);
        add(th1);
        th2 = new JButton ("Chaines de caractère : String");
        th2.setBackground(new Color(255,255,255)) ;
        th2.setBounds(300,110,200,50);
        add(th2);
        th3 = new JButton ("Tableaux");
        th3.setBackground(new Color(255,255,255)) ;
        th3.setBounds(300,170,200,50);
        add(th3);
        th4 = new JButton ("Exception");
        th4.setBackground(new Color(255,255,255)) ;
        th4.setBounds(300,230,200,50);
        add(th4);
        th5 = new JButton ("Collections");
        th5.setBackground(new Color(255,255,255)) ;
        th5.setBounds(300,290,200,50);
        add(th5);
        
    	
    }
/* Ajouter les actions pour chaque boutton */
void choose () {
        
        th1.addActionListener((ActionEvent e) -> {
            go = true ;
            numero = 1;
            setVisible(false);
        });
        th2.addActionListener((ActionEvent e) -> {
            go = true ;
            numero = 2; 
            setVisible(false);
        });
        th3.addActionListener((ActionEvent e) -> {
            go = true ;
            numero = 3; 
            setVisible(false);
        });
        th4.addActionListener((ActionEvent e) -> {
            go = true ;
            numero = 4; 
            setVisible(false);
        });
        
        th5.addActionListener((ActionEvent e) -> {
        	go = true ;
            numero = 5; 
            setVisible(false);
        });
        
        while (!go) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {}
        }
        
        go = false ;
    
    }
 public int getNumero() {
	 return numero;
 }
}
