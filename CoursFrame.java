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
public class CoursFrame extends JFrame {
	
	      CoursFrame (int numero) {
              Cours c = new Cours();
	      setSize(1086,679);
	      setLocationRelativeTo(null);
	      setResizable(false);
	      JPanel pan = new JPanel () ;
	      pan.setSize(this.getSize().width,this.getSize().height);
	      pan.setBackground(Color.DARK_GRAY);
	      pan.setLayout(null);
	      setContentPane(pan);
	      JLabel cours = new JLabel();
	      if(numero == 1) { cours = new JLabel(c.types_de_données());}
	      else if(numero == 2) { cours = new JLabel(c.strings());}
	      else if(numero == 3) { cours = new JLabel(c.tableaux());}
	      else if(numero == 4) { cours = new JLabel(c.exceptions());}
	      else if(numero == 5) { cours = new JLabel(c.collections());}
	      
	      cours.setFont(new Font("Verdana", Font.BOLD, 15));
	      cours.setBounds(200,25,1000,600);
	      cours.setForeground(Color.white);
	      JLabel border = new JLabel() ;
	      border.setBorder(new LineBorder(Color.white, 2, true));
	      border.setBounds(10,5,1000,600);
	      border.add(cours);
          pan.add(border);
          setVisible(true);
	      }
	  }
