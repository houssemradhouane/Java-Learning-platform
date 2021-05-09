import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
/**
 * @author Salahdine Ouhmmiali v 1.0
 *
 */
/* Construire la frame pour les qcm */
public class QcmFrame extends JPanel {
	  JLabel Q;

JButton option1 ,
       option2,
       option3,
       option4 ;  

String reponse_correcte;

static boolean next = false ;
static int score = 0 ;

static JLabel timer = new JLabel ("00 : 00 : 000") ;
static Compteur count = new Compteur ();

/* Constructeur de la frame QcmFrame */
QcmFrame (Qcm obj , JFrame window) {
       
 Q = new JLabel (obj.question); // La question
 option1 = new JButton (obj.option1) ; // les choix 
 option2 = new JButton (obj.option2) ;
 option3 = new JButton (obj.option3) ;
 option4 = new JButton (obj.option4) ;
 reponse_correcte = obj.reponse_correcte ; // la réponse correcte

 JPanel pan = new JPanel () ;     
 pan.setLayout(null);
 pan.setBorder(BorderFactory.createLineBorder(Color.gray));
 pan.setBackground(Color.DARK_GRAY);
 window.setContentPane(pan);
 setLayout(null);
 setBackground(Color.getHSBColor(154, 254, 25));
 setBounds(100,90,600,300);
 setBorder(BorderFactory.createLineBorder(Color.black));
 pan.add(this);
 
 add(Q); add(option1); add(option2); add(option3); add(option4);
 
 Q.setBounds(40,8,520,150);
 Q.setBorder(new LineBorder(Color.blue, 2, true));
 Q.setHorizontalAlignment(JLabel.CENTER);
 option1.setBounds(80,180,200,40); option1.setBackground(new Color(255,255,255)) ; 
 option2.setBounds(80,240,200,40); option2.setBackground(new Color(255,255,255)) ;
 option3.setBounds(320,180,200,40);  option3.setBackground(new Color(255,255,255)) ;
 option4.setBounds(320,240,200,40); option4.setBackground(new Color(255,255,255)) ;
 option1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED)); 
 option2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
 option3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
 option4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
 timer.setBounds(250,420,300,30);
 timer.setFont(new Font("Verdana", Font.BOLD, 40));
 timer.setHorizontalAlignment(JLabel.CENTER);
 timer.setBorder(BorderFactory.createLineBorder(Color.white));
 timer.setForeground(Color.white);
 pan.add(timer);
 
 window.setVisible(true);              
}
/*Valider la réponse de l'utilisateur */
void getAnswer (int time) throws InterruptedException {
   
       option1.addActionListener((ActionEvent e) -> {
           if (option1.getText().equals(reponse_correcte)) score++ ;  
           next = true ;
       });

       option2.addActionListener((ActionEvent e) -> {
           if (option2.getText().equals(reponse_correcte)) score++ ;  
           next = true ;
       });

       option3.addActionListener((ActionEvent e) -> {
           if (option3.getText().equals(reponse_correcte)) score++ ;  
           next = true ;
       });

       option4.addActionListener((ActionEvent e) -> {
           if (option4.getText().equals(reponse_correcte)) score++ ;  
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
/* Obtenir le score du test */
int getScore() {return score ;}
Compteur getTime () {return count ;}
void Reset () {
    
    count.M=0 ; 
    count.Ms=0 ; 
    count.S=0;
    score = 0 ;

}

}

