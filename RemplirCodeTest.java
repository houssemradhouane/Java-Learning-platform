<<<<<<< Updated upstream
import java.io.IOException;

import javax.swing.JFrame;
/**
 * 
 * @author Youssef MINYARI et Othmane MOKRANE
 *
 */
public class RemplirCodeTest {

	public static void main(String[] args) throws InterruptedException {
		RemplirCode exercice = new RemplirCode("Ecrire un programme qui retourne le caractere c!",'c');
		JFrame fenetre = new JFrame ("RemplirCode Test") ;
		fenetre.setSize(800,500);
		RemplirCodeFrame rcf = new RemplirCodeFrame(exercice, fenetre);
		int time = 60;
		rcf.getCode(time);
	}

}
=======
import java.io.IOException;

import javax.swing.JFrame;
/**
 * 
 * @author Youssef MINYARI et Othmane MOKRANE
 *
 */
public class RemplirCodeTest {

	public static void main(String[] args) throws InterruptedException {
		RemplirCode exercice = new RemplirCode("Ecrire un programme qui retourne le caractere c!",'c');
		JFrame fenetre = new JFrame ("RemplirCode Test") ;
		fenetre.setSize(800,500);
		RemplirCodeFrame rcf = new RemplirCodeFrame(exercice, fenetre);
		int time = 60;
		rcf.getCode(time);
	}

}
>>>>>>> Stashed changes
