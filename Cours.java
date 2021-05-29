
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
	private static Themes th = new Themes();
    private static final String themes[][] = th.themes;

	private String coursTypeDonnees = "<html> * On distingue deux genres de  types de données sur Java :\n"
			+ "<br> -Types primitifs : byte, short, int, long, float, double,boolean et char.\n"
			+ "<br> -Types non-primitifs : String, Arrays, Classes …\n" + "<br>" + "<br>"
			+ "<br> * Types de données primitifs de base:\n" + "<br>"
			+ "<br> -byte :  stocke les nombres entre -128 à 127.\n"
			+ "<br> -int : stocke les entiers jusqu’à  10 digits.\n"
			+ "<br> -double & float : pour stocker les nombres à virgule flottante.\n"
			+ "<br> -char: stocke les caractères (lettres, signes ou nombres).\n"
			+ "<br> -boolean : type logique qui prend les valeurs true et false.\n" + "<br>" + "<br>"
			+ "<br> * Strings\n" + "<br>  Les chaînes de caractères sur Java sont de type string.\n" + "<br>"
			+ "<br>Exemples :\n" + "<br>String sequence = “ This is a string” ;\n"
			+ "<br> String concat = “ This” + “string” \n"
			+ "                                   + “is” + “concatenated” ;\n" + "\n" + "\n" + "</html>";

	private String coursStrings = "<html>br> * Strings\n"
			+ "<br>  Les chaînes de caractères sur Java sont de type string.\n" + "<br>" + "<br>Exemples :\n"
			+ "<br>String sequence = “ This is a string” ;\n" + "<br> String concat = “ This” + “string” \n"
			+ "                                   + “is” + “concatenated” ;\n" + "\n" + "\n </html>";

	private String coursTableaux = "<html> Un tableau est une structure de données pour stocker "
			+ "<br>des données de  même type." + "<br>Un fois déclaré, sa taille est fixée."
			+ "<br>Pour déclarer un tableau on utilise une des deux formules : " + "<br>elementType[] tableau;"
			+ "<br>elementType tableau[];" + "<br>Instanciation  : " + "<br> tableau = new elementType[taille];"
			+ "<br> On peut remplir tableau par des éléments du type elementType " + "<br> par l'éxpression : "
			+ "tableau[indice] = valeur; avec indice qui va de 0 à taille -1 ."
			+ "<br> On peut déclaré et initialisé un tableau directement par :"
			+ "<br> elementType[] tableau = {v1,v2,v3,v4}; </html>";
	
	private String coursExceptions = "Cours non écrit !";
	private String coursCollections = "Cours non écrit !";

	Cours(String theme) {

		setEditable(false);
		setContentType("text/html");

		if (theme.equals(themes[0][0])) {
			setText(coursTypeDonnees);
		}
		else if (theme.equals(themes[0][1])) {
			setText(coursStrings);
		}
		else if (theme.equals(themes[0][2])) {
			setText(coursTableaux);
		}
		else if (theme.equals(themes[1][0])) {
			setText(coursExceptions);
		}
		else if (theme.equals(themes[2][0])) {
			setText(coursCollections);
		}

		setFont(new Font("Verdana", Font.PLAIN, 15));
		setForeground(Color.WHITE);
	}
}
