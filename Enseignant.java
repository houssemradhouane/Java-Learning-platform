import java.util.*;

/**
 * Enseignant modélise un utilisateur du jeu en mode enseignant. Un enseignant
 * est caractérisé par son identifiant et son mot de passe. Il a accès au
 * progrès de ses étudiants et peut donner des remarques.
 *
 * @author Houssem Radhouane
 */

public class Enseignant implements Utilisateur {

	/* Identifiant de l'enseignant */
	private String identifiant;

	/* Mot de passe de l'enseignant */
	private String mdp;

	/* Base de données */
	BaseUtilisateurs base = new BaseUtilisateurs();

	/**
	 * Construire un enseignant à partir de son identifiant et son mot de passe.
	 * 
	 * @param id    identifiant
	 * @param motdp mot de passe
	 */
	public Enseignant(String id, String motdp) {
		this.identifiant = id;
		this.mdp = motdp;
	}

	/**
	 * Obtenir l'identifiant de l'enseignant.
	 * 
	 * @return identifiant de l'enseignant
	 */
	public String getIdentifiant() {
		return this.identifiant;
	}

	/**
	 * Obtenir le mot de passe de l'enseignant.
	 * 
	 * @return mot de passe de l'enseignant
	 */
	public String getMDP() {
		return this.mdp;
	}

	/**
	 * Inscrire des remarques dans les notes d'un étudiant.
	 * 
	 * @param idEtudiant identifiant de l'étudiant
	 * @param remarque   la/les remarque(s) à faire
	 */
	public void faireRemarque(String remarque, String idEtudiant) {
		base.ajouterRemarque(this.getIdentifiant(), idEtudiant, remarque);
	}
}