import java.util.*;

/** Etudiant modélise un utilisateur du jeu en mode étudiant.
 * Un étudiant est caractérisé par son identifiant et son mot de
 * passe.
 * Il garde un historique de ses activités(progrès, remarques...) et il peut être affilié à un enseignant.
 *
 * @author  Houssem Radhouane
 */

public class Etudiant implements Utilisateur {

       /* Identifiant de l'étudiant */
       private String identifiant;

       /* Mot de passe de l'étudiant */
       private String mdp;

       /** Construire un étudiant à partir de son identifiant et son mot de passe.
	 * @param id identifiant
	 * @param motdp mot de passe
	 */
	public Etudiant(String id, String motdp) {
               this.identifiant = id;
               this.mdp = motdp;
       }

       /** Obtenir l'identifiant de l'étudiant.
	 * @return identifiant de l'étudiant
	 */
       public String getIdentifiant() {
		return this.identifiant;
       }

       /** Obtenir le mot de passe de l'étudiant.
	 * @return mot de passe de l'étudiant
	 */
       public String getMDP() {
		return this.mdp;
       }

       /** Inscrire l'étudiant à un enseignant.
         * @param identifiant de l'enseignant
         */
       public void inscrire(String identifiant) {
              if (BaseDD.enseignantExistant(identifiant)) {
                 