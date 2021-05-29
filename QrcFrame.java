import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
/*
 Frame pour les questions à réponse courtes 
*/
public class QrcFrame extends JPanel {
	String reponse_correcte;
	JLabel questionLabel,
	yourAnswer;
	JTextField answer;
	JButton valider;
	static boolean next = false ;
	static int score = 0 ;

	static JLabel timer = new JLabel ("00 : 00 : 000") ;
	static Compteur count = new Compteur ();
         /* Constructeur de la frame */
	 QrcFrame(Qrc obj, JFrame window){
		 questionLabel = new JLabel (obj.question);
         reponse_correcte = obj.reponse;
         valider = new JButton("Valider");
         yourAnswer = new JLabel("Réponse :");
         answer = new JTextField(20);

         JPanel pan = new JPanel () ;     
         pan.setLayout(null);
         pan.setBorder(BorderFactory.createLineBorder(Color.gray));
         pan.setBackground(Color.DARK_GRAY);
         window.setContentPane(pan);
         setLayout(null);
<<<<<<< Updated upstream
         setBackground(Color.getHSBColor(154, 254, 25));
=======
         setBackground(Color.LIGHT_GRAY);
>>>>>>> Stashed changes
         setBounds(100,90,600,300);
         setBorder(BorderFactory.createLineBorder(Color.black));
         pan.add(this);
         add(questionLabel); add(answer); add(yourAnswer); add(valider);

         questionLabel.setBounds(40,8,520,150);
<<<<<<< Updated upstream
         questionLabel.setBorder(new LineBorder(Color.blue, 2, true));
=======
         questionLabel.setBorder(new LineBorder(Color.white, 2, true));
>>>>>>> Stashed changes
         questionLabel.setHorizontalAlignment(JLabel.CENTER);
         yourAnswer.setBounds(80,180,100,40);
         yourAnswer.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED)); 
         answer.setBounds(200,180,200,40);
         answer.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
         valider.setBounds(160,240,100,40);
         valider.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
         timer.setBounds(250,420,300,30);
         timer.setFont(new Font("Verdana", Font.BOLD, 40));
         timer.setHorizontalAlignment(JLabel.CENTER);
         timer.setBorder(BorderFactory.createLineBorder(Color.white));
         timer.setForeground(Color.white);
         pan.add(timer);
         window.setVisible(true);
         
	}
        /* Valider la réponse de l'utilisateur */
	void getAnswer (int time) throws InterruptedException {
		   
	       valider.addActionListener((ActionEvent e) -> {
	           if (answer.getText().equals(reponse_correcte)) score++ ;  
	           next = true ;
	       });

	       
	       while (next == false ) {
	           
	           timer.setText(String.format("%02d", count.M)+" : "+String.format("%02d", count.S)+" : "+String.format("%03d", count.Ms)); 
	              count.Ms++ ;
	              Thread.sleep(1);
	              if (count.Ms==999){
	                  count.S++ ;
	                  count.Ms=0 ;
	              }
	              if (count.S==59){
	                  count.M++ ;
	                  count.S=0;
	              }
	              
	              if ((count.S + count.M*60) > time-3 ) {
	                  
	                  timer.setForeground(Color.red);
	                  
	                       if ((count.S + count.M*60)==time) { 
	                           return ;
	                       }
	              }
	       
	       } 
	   next = false ;

	}
        /* Obtenir le score */
	int getScore() {return score ;}
    
	Compteur getTime () {return count ;}
        /* Réinitialiser les paramètres du test */
	void Reset () {
	    
	    count.M=0 ; 
	    count.Ms=0 ; 
	    count.S=0;
	    score = 0 ;

	}

}
