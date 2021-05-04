import java.util.*;

/** Enseignant mod�lise un utilisateur du jeu en mode enseignant.
 * Un enseignant est caract�ris� par son identifiant et son mot de
 * passe.
 * Il a acc�s au progr�s de ses �tudiants et peut donner des remarques.
 *
 * @author  Houssem Radhouane
 */

public class Enseignant implements Utilisateur {

       /* Identifiant de l'enseignant */
       private String identifiant;

       /* Mot de passe de l'enseignant */
       private String mdp;

       /* Liste des �tudiants affili�s � l'enseignant */
       private List<EtudiantProxy> etudiants;

       /** Construire un enseignant � partir de son identifiant et son mot de passe.
	 * @param id identifiant
	 * @param motdp mot de passe
	 */
	public Enseignant(String id, String motdp) {
               this.identifiant = id;
               this.mdp = motdp;
               this.etudiants = new ArrayList<>();
        }

        /** Obtenir l'identifiant de l'enseignant.
	 * @return identifiant de l'enseignant
	 */
	public String getIdentifiant() {
		return this.identifiant;
	}

        /** Obtenir le mot de passe de l'enseignant.
	 * @return mot de passe de l'enseignant
	 */
	public String getMDP() {
		return this.mdp;
	}

        /** Ajouter un �tudiant � la liste �tudiants affili�s � l'enseignant.
         * @param etudiant l'�tudiant � ajouter
         */
        public void ajouter(EtudiantProxy etudiant) {
               this.etudiants.add(etudiant);
        }

        /** Inscrire des remarques dans les notes d'un �tudiant.
         * @param etudiant l'�tudiant
         * @param remarque la/les remarque(s) � faire
         */
        public void setRemarques(String remarque, EtudiantProxy etudiant) {
               etudiant.inscrire("Remarque enseignant : "+remarque);
        }
}