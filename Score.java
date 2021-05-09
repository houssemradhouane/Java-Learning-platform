import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
/**
 * @author Salahdine Ouhmmiali v 1.0
 */
/* Afficher le score sur l'interface graphique */
public class Score extends JPanel {
	JButton recommencer ,
    quitter;
	
JLabel scoreLabel ;

static boolean again =false;
/* Constructeur de la frame Score */
Score (JFrame window , int score , int nbrQ) {

setSize(window.getSize().width,window.getSize().height);
setLayout(null);
setBackground(Color.DARK_GRAY);
window.setContentPane(this);

recommencer = new JButton ("Retour au menu");
recommencer .setBackground(new Color(255,255,255)) ;
recommencer .setBounds(300,250,200,50);
add(recommencer);

quitter = new JButton ("Exit");
quitter.setBackground(new Color(255,255,255)) ;
quitter.setBounds(300,350,200,50);
add(quitter);

scoreLabel = new JLabel ("You Got : "+score+"/"+nbrQ);
scoreLabel.setHorizontalAlignment(JLabel.CENTER);
scoreLabel.setFont(new Font("Verdana", Font.BOLD, 40));
scoreLabel.setForeground(Color.white);
scoreLabel.setBorder(new LineBorder(Color.white, 2, true));
scoreLabel.setBounds(200,100,400,100);
add(scoreLabel);

window.setVisible(true);

}
/* Ajouter les actions aux bouttons */
void choose () {

recommencer.addActionListener((ActionEvent e) -> {
    again= true ;
});

quitter.addActionListener((ActionEvent e) -> {
    System.exit(0);
});

while (!again) {
    try {        
        Thread.sleep(0);
    } catch (InterruptedException ex) {}
}

again = false ;

}

}

