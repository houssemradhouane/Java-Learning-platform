import java.util.*;

/**
 * Etudiant mod�lise un utilisateur du jeu en mode �tudiant. Un �tudiant est
 * caract�ris� par son identifiant et son mot de passe. Il garde un historique
 * de ses activit�s(progr�s, remarques...) et il peut �tre affili� � un
 * enseignant.
 *
 * @author Houssem Radhouane
 */

public class Etudiant implements Utilisateur {

	/* Identifiant de l'�tudiant */
	private String identifiant;

	/* Mot de passe de l'�tudiant */
	private String mdp;

	/* Base de donn�es */
	BaseUtilisateurs base = new BaseUtilisateurs();

	/**
	 * Construire un �tudiant � partir de son identifiant et son mot de passe.
	 * 
	 * @param id    identifiant
	 * @param motdp mot de passe
	 */
	public Etudiant(String id, String motdp) {
		this.identifiant = id;
		this.mdp = motdp;
	}

	/**
	 * Obtenir l'identifiant de l'�tudiant.
	 * 
	 * @return identifiant de l'�tudiant
	 */
	public String getIdentifiant() {
		return this.identifiant;
	}

	/**
	 * Obtenir le mot de passe de l'�tudiant.
	 * 
	 * @return mot de passe de l'�tudiant
	 */
	public String getMDP() {
		return this.mdp;
	}

	/**
	 * Poser une question � l'enseignant de l'�tudiant.
	 * 
	 * @param identifiant de l'enseignant
	 */
	public void poserQuestion(String question) {
		String ens = base.trouverEnseignant(this.getIdentifiant());
		base.ajouterQuestion(ens, this.getIdentifiant(), question);
	}
}