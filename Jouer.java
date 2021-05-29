import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.*;
<<<<<<< Updated upstream
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
=======
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

>>>>>>> Stashed changes
/**
 * @author Salahdine Ouhmmiali
 */
/* La classe main */
public class Jouer {
<<<<<<< Updated upstream
	public static void main(String[] args) throws InterruptedException {
        
	      JFrame window = new JFrame ("Jeu Java") ;  
	      window.setSize(800,500);
	      window.setLocationRelativeTo(null);
	      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      window.setResizable(false);
	     while(true) {
	          // nbr1, nbr2 : numéro de la question dans qcm ou qrc
                  // score1, score2 : les scores dans qcm et qrc
	          int nbr1 =0 ,nbr2=0, score1=0 , m=0 , s=0,score2=0 ;
	          int time = 60 ; //sec 
	          PremierePage premierepage = new PremierePage(window);
	          premierepage.choose();
	          Themes themes = new Themes(window);
	          themes.choose();
                  // numero du theme choisi par l'utilisateur
	          int numero = Themes.numero; 
	          SupportCours pagePrincipale = new SupportCours (window);
	          pagePrincipale.choose();
	          boolean isCour = SupportCours.cour;
	           Quizs quizs = new Quizs();
                   // Tous les qcm du jeu .
	           Qcm [] quiz_All = quizs.quizQcm();
                   // les qcm du thème choisi par l'utilisateur 
	           Qcm [] quiz_theme = Arrays.copyOfRange(quiz_All, numero-1, numero);
                   // tous les qrc du jeu 
	           Qrc [] qrcs= quizs.quizQrc();
                       // Qcm 
	               while (nbr1 != quiz_theme.length  ) {
	                    QcmFrame quiz = new QcmFrame(quiz_theme[nbr1], window);
	                    quiz.getAnswer(time);
	                    m = quiz.getTime().M ;
	                    s = quiz.getTime().S ;
	                    score1 = quiz.getScore();
	                    if (nbr1 == quiz_theme.length-1 || (s==time)) { quiz.Reset();}
	                     nbr1++ ;
	                }
	             
	           //Qrc
	           while (nbr2 != qrcs.length  ) {
                   QrcFrame quiz = new QrcFrame(qrcs[nbr2], window);
                   quiz.getAnswer(time);
                   m = quiz.getTime().M ;
                   s = quiz.getTime().S ;
                   score2 = quiz.getScore();
                   if (nbr2 == qrcs.length-1 || (s==time)) { quiz.Reset();}
                    nbr2++ ;
               }
               // nb total du question du test passé
               int nbrQ = qrcs.length + quiz_theme.length ;
               // score total du test passé
               int score = score1 + score2;
               // Afficahe du score sur l'interface graphique
               Score scorePage = new Score (window,score,nbrQ) ;
               // Obtenir le choix de l'utilisateur ( Quitter ou Recommencer )
               scorePage.choose();
                   
               
	            
	           
	     }      	        
}
=======
	JFrame window;
	public static void main(String[] args) throws InterruptedException {
		Jouer jeu = new Jouer();
	}

	public Jouer() {
		initialize();
	}

	private void initialize() {
		window = new JFrame("Jeu Java");
		window.setSize(800, 500);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setResizable(false);
		while (true) {
			// nbr1, nbr2 : numéro de la question dans qcm ou qrc
			// score1, score2 : les scores dans qcm et qrc
			int nbr1 = 0, nbr2 = 0, score1 = 0, m = 0, s = 0, score2 = 0;
			int time = 60; // sec
			PremierePage premierepage = new PremierePage(window);
			premierepage.choose();
			Themes themes = new Themes(window);
			themes.choose();
			// numero du theme choisi par l'utilisateur
			int numero = Themes.numero;
			SupportCours pagePrincipale = new SupportCours(window);
			pagePrincipale.choose();
			boolean isCour = SupportCours.cour;
			Quizs quizs = new Quizs();
			// Tous les qcm du jeu .
			Qcm[] quiz_All = quizs.quizQcm();
			// les qcm du thème choisi par l'utilisateur
			Qcm[] quiz_theme = Arrays.copyOfRange(quiz_All, (numero - 1) * 4, numero * 4);
			// tous les qrc du jeu
			Qrc[] qrcs = quizs.quizQrc();
			Qrc[] qrcs_theme = Arrays.copyOfRange(qrcs, numero - 1, numero);

			// Qcm
			while (nbr1 != quiz_theme.length) {
				QcmFrame quiz = new QcmFrame(quiz_theme[nbr1], window);
				try {
					quiz.getAnswer(time);
				} catch (InterruptedException i) {
					System.out.println(i.getMessage());
				}
				m = quiz.getTime().M;
				s = quiz.getTime().S;
				score1 = quiz.getScore();
				if (nbr1 == quiz_theme.length - 1 || (s == time)) {
					quiz.Reset();
				}
				nbr1++;
			}

			// Qrc
			while (nbr2 != qrcs_theme.length) {
				QrcFrame quiz = new QrcFrame(qrcs_theme[nbr2], window);
				try {
					quiz.getAnswer(time);
				} catch (InterruptedException i) {
					System.out.println(i.getMessage());
				}
				m = quiz.getTime().M;
				s = quiz.getTime().S;
				score2 = quiz.getScore();
				if (nbr2 == qrcs_theme.length - 1 || (s == time)) {
					quiz.Reset();
				}
				nbr2++;
			}
			// nb total du question du test passé
			int nbrQ = qrcs_theme.length + quiz_theme.length;
			// score total du test passé
			int score = score1 + score2;
			// Afficahe du score sur l'interface graphique
			Score scorePage = new Score(window, score, nbrQ);
			// Obtenir le choix de l'utilisateur ( Quitter ou Recommencer )
			scorePage.choose();

		}
	}
>>>>>>> Stashed changes
}
