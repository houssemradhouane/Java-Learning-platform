/**
*
*	@author ?????? v1.0, Flavien Mithieux v1.1
*	Description : Support des cours
*
*/

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

/* Afficher le cours sur l'interface graphique */
public class Cours extends JEditorPane {
	private String coursTypeDonnees = "<html> * On distingue deux genres de  types de données sur Java :\n"
						+ "<br> -Types primitifs : byte, short, int, long, float, double,boolean et char.\n"
						+ "<br> -Types non-primitifs : String, Arrays, Classes …\n" + "<br>" + "<br>"
						+ "<br> * Types de données primitifs de base:\n" + "<br>"
						+ "<br> -byte :  stocke les nombres entre -128 à 127.\n"
						+ "<br> -int : stocke les entiers jusqu’à  10 digits.\n"
						+ "<br> -double & float : pour stocker les nombres à virgule flottante.\n"
						+ "<br> -char: stocke les caractères (lettres, signes ou nombres).\n"
						+ "<br> -boolean : type logique qui prend les valeurs true et false.\n" + "<br>" + "<br>"
						+ "<br> * Strings\n" + "<br>  Les chaînes de caractères sur Java sont de type string.\n"
						+ "<br>" + "<br>Exemples :\n" + "<br>String sequence = “ This is a string” ;\n"
						+ "<br> String concat = “ This” + “string” \n"
						+ "                                   + “is” + “concatenated” ;\n" + "\n" + "\n" + "</html>";

	Cours(String theme) {

		setEditable(false);
		setContentType("text/html");

		switch (theme) {
			case "Types de données":
				setText(coursTypeDonnees);
				setFont(new Font("Verdana", Font.BOLD, 15));
				setForeground(Color.WHITE);
				break;
		}
	}
}
