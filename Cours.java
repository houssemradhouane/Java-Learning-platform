import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/* Afficher le cours sur l'interface graphique */
public class Cours extends JFrame {

        /* Creer un JPanel pour contenir le cours */
	void createPan(JLabel border,JPanel panel) {
		  setSize(600,500);
	      setLocationRelativeTo(null);
	      setResizable(false);
	      panel.setSize(this.getSize().width,this.getSize().height);
	      panel.setBackground(Color.DARK_GRAY);
	      panel.setLayout(null);
	      setContentPane(panel);
	      border.setBorder(new LineBorder(Color.white, 2, true));
	      border.setBounds(20,5,550,450);
	      panel.add(border);
	     
	}
	
	Cours (int numero) {
	      JLabel border = new JLabel();
          JPanel panel = new JPanel();

	      switch( numero) {
	      case 1 : createPan(border,panel);
	               JLabel cour = new JLabel("<html> * On distingue deux genres de  types de données sur Java :\n" + 
	               		"<br> -Types primitifs : byte, short, int, long, float, double,boolean et char.\n" + 
	               		"<br> -Types non-primitifs : String, Arrays, Classes …\n" + 
	               		"<br>"+
	               		"<br>"+
	               		"<br> * Types de données primitifs de base:\n" +
	               		"<br>"+
	               		"<br> -byte :  stocke les nombres entre -128 à 127.\n" + 
	               		"<br> -int : stocke les entiers jusqu’à  10 digits.\n" + 
	               		"<br> -double & float : pour stocker les nombres à virgule flottante.\n" + 
	               		"<br> -char: stocke les caractères (lettres, signes ou nombres).\n" + 
	               		"<br> -boolean : type logique qui prend les valeurs true et false.\n" + 
	               		"<br>"+
	               		"<br>"+
	               		"<br> * Strings\n" + 
	               		"<br>  Les chaînes de caractères sur Java sont de type string.\n" + 
	               		"<br>"+	               	
	               		"<br>Exemples :\n" +	               		
	               		"<br>String sequence = “ This is a string” ;\n" + 
	               		"<br> String concat = “ This” + “string” \n" + 
	               		"                                   + “is” + “concatenated” ;\n" + 
	               		"\n" + 
	               		"\n" + 
	               		"</html>");
                        cour.setFont(new Font("Verdana", Font.BOLD, 15));
                        cour.setBounds(8,5,550,450);
                        cour.setForeground(Color.white);
                        border.add(cour);
                        setVisible(true);
	               
	      }
	   


	      }
	  }

