import java.util.*;

/** Enseignant modélise un utilisateur du jeu en mode enseignant.
 * Un enseignant est caractérisé par son identifiant et son mot de
 * passe.
 * Il a accès au progrès de ses étudiants et peut donner des remarques.
 *
 * @author  Houssem Radhouane
 */

public class Enseignant implements Utilisateur {

       /* Identifiant de l'enseignant */
       private String identifiant;

       /* Mot de passe de l'enseignant */
       private String mdp;

       /* Liste des étudiants affiliés à l'enseignant */
       private List<EtudiantProxy> etudiants;

       /** Construire un enseignant à partir de son identifiant et son mot de passe.
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

        /** Ajouter un étudiant à la liste étudiants affiliés à l'enseignant.
         * @param etudiant l'étudiant à ajouter
         */
        public void ajouter(EtudiantProxy etudiant) {
               this.etudiants.add(etudiant);
        }

        /** Inscrire des remarques dans les notes d'un étudiant.
         * @param etudiant l'étudiant
         * @param remarque la/les remarque(s) à faire
         */
        public void setRemarques(String remarque, EtudiantProxy etudiant) {
               etudiant.inscrire("Remarque enseignant : "+remarque);
        }
}