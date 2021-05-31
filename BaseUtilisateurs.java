import java.util.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * BaseDD mod�lise une base de donn�es utilisateurs. Elle permet d'ajouter des
 * utilisateurs, consulter, v�rifier et mettre � jour leurs informations.
 *
 * @author Houssem Radhouane
 */

public class BaseUtilisateurs {

	/* initialiser les propri�t�s de la base de donn�es */
	private String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
	private String USERNAME = "root";
	private String PASSWORD = "55686Nsd";
	private BaseDD Base;

	public BaseUtilisateurs() {
		this.Base = new BaseDD();
		Base.connect(DATABASE_URL, USERNAME, PASSWORD);
	}

	/**
	 * V�rifie si l'identifiant donn� est utilis� par un �tudiant.
	 * 
	 * @param usern l'identifiant
	 * @return true si l'identifiant est utilis� par un �tudiant
	 */
	public boolean etudiantExistant(String usern) {
		try {
			ResultSet resultset = Base
					.select("SELECT identifiant FROM users.etudiant WHERE identifiant = '" + usern + "'");
			return (resultset.next());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * V�rifie si l'identifiant donn� est utilis� par un enseignant.
	 * 
	 * @param usern l'identifiant
	 * @return true si l'identifiant est utilis� par un enseignant
	 */
	public boolean enseignantExistant(String usern) {
		try {
			ResultSet resultset = Base
					.select("SELECT identifiant FROM users.enseignant WHERE identifiant = '" + usern + "'");
			return (resultset.next());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * V�rifie si l'identifiant donn� est utilis� par un utilisateur.
	 * 
	 * @param usern l'identifiant
	 * @return true si l'identifiant est utilis�
	 */
	public boolean utilisateurExistant(String usern) {
		return (this.enseignantExistant(usern) || this.etudiantExistant(usern));
	}

	/**
	 * ajoute un nouveau �tudiant au tableau �tudiant
	 * 
	 * @param usern  l'identifiant
	 * @param mdp    le mot de passe
	 * @param nom    le nom
	 * @param prenom le prenom
	 * @param ens    l'identifiant de l'enseignant responsable
	 */
	public void ajouterEtudiant(String usern, String mdp, String nom, String prenom, String ens) {
		if (!utilisateurExistant(usern)) {
			try {
				int status = Base.createOrUpdateOrDelete(
						"INSERT INTO users.etudiant (identifiant, nom, prenom, mdp, enseignant) " + "VALUES ('" + usern
								+ "', '" + nom + "', '" + prenom + "', '" + mdp + "', '" + ens + "')");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * ajoute un nouveau enseignant au tableau �tudiant
	 * 
	 * @param usern  l'identifiant
	 * @param mdp    le mot de passe
	 * @param nom    le nom
	 * @param prenom le prenom
	 */
	public void ajouterEnseignant(String usern, String mdp, String nom, String prenom) {
		if (!utilisateurExistant(usern)) {
			try {
				int status = Base.createOrUpdateOrDelete("INSERT INTO users.enseignant (identifiant, nom, prenom, mdp) "
						+ "VALUES ('" + usern + "', '" + nom + "', '" + prenom + "', '" + mdp + "')");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Authentifie un �tudiant � partir de son username et mot de passe.
	 * 
	 * @param usern l'identifiant
	 * @param pwd   mot de passe
	 * @return true si l'identifiant est utilis� par un enseignant
	 */
	public boolean authentifier(String usern, String pwd) {
		try {
			ResultSet resultset = Base.select(
					"SELECT * FROM users.etudiant,users.enseignant WHERE (users.etudiant.identifiant = '" + usern
							+ "' AND users.etudiant.mdp = '" + pwd + "')" + " OR (users.enseignant.identifiant = '"
							+ usern + "' AND users.enseignant.mdp = '" + pwd + "')");
			return (resultset.next());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Trouver l'enseignant associ� � l'�tudiant.
	 * 
	 * @param usern l'identifiant
	 * @return l'identifiant de l'enseignant associ� � l'�tudiant
	 */
	public String trouverEnseignant(String usern) {
		try {
			ResultSet resultset = Base
					.select("SELECT users.etudiant.enseignant FROM users.etudiant WHERE (users.etudiant.identifiant = '"
							+ usern + "')");
			if (resultset.next()) {
				return (resultset.getString(1));
			} else {
				return " ";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return " ";
		}
	}

	/**
	 * Lister tous les �tudiants associ�s � un enseignant.
	 * 
	 * @param usern l'identifiant de l'enseignant
	 * @return liste des �tudiants
	 */
	public ArrayList<String> listerEtudiant(String usern) {
		ArrayList<String> resultat = new ArrayList<String>();
		try {
			ResultSet resultset = Base
					.select("SELECT users.etudiant.identifiant FROM users.etudiant WHERE (users.etudiant.enseignant = '"
							+ usern + "')");
			ResultSetMetaData rsmd = resultset.getMetaData();
			int columncount = rsmd.getColumnCount();
			System.out.println(columncount);
			while (resultset.next()) {
				for (int i = 1; i <= columncount; i++) {
					resultat.add(resultset.getString(i));
				}
			}
			return resultat;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return resultat;
		}
	}

	/**
	 * ajoute une question de l'�tudiant � son enseignant
	 * 
	 * @param usern    l'identifiant de l'�tudiant
	 * @param userne   l'identifiant de l'enseignant
	 * @param question la question
	 */
	public void ajouterQuestion(String usern, String userne, String question) {
		try {
			int status = Base.createOrUpdateOrDelete("INSERT INTO users.Questions (idProf, idEtudiant, Question) "
					+ "VALUES ('" + userne + "', '" + usern + "', '" + question + "')");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * ajoute une remarque de l'enseignant � l'un de ses �tudiants
	 * 
	 * @param usern    l'identifiant de l'�tudiant
	 * @param userne   l'identifiant de l'enseignant
	 * @param question la remarque
	 */
	public void ajouterRemarque(String usern, String userne, String remarque) {
		try {
			int status = Base.createOrUpdateOrDelete("INSERT INTO users.Remarques (idProf, idEtudiant, Remarque) "
					+ "VALUES ('" + userne + "', '" + usern + "', '" + remarque + "')");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lister toutes les questions pos�es � un enseignant.
	 * 
	 * @param usern l'identifiant de l'enseignant
	 * @return liste des questions avec les �tudiants
	 */
	public ArrayList<String> listerQuestions(String usern) {
		ArrayList<String> resultat = new ArrayList<String>();
		try {
			ResultSet resultset = Base.select(
					"SELECT users.Questions.idEtudiant, users.Questions.Question FROM users.Questions WHERE (users.Questions.idProf = '"
							+ usern + "')");
			ResultSetMetaData rsmd = resultset.getMetaData();
			int columncount = rsmd.getColumnCount();
			while (resultset.next()) {
				for (int i = 1; i <= columncount; i++) {
					resultat.add(resultset.getString(i));
				}
			}
			return resultat;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return resultat;
		}
	}

	/**
	 * Lister toutes les remarques faites � un �tudiant.
	 * 
	 * @param usern l'identifiant de l'�tudiant
	 * @return liste des remarques avec l'enseignant
	 */
	public ArrayList<String> listerRemarques(String usern) {
		ArrayList<String> resultat = new ArrayList<String>();
		try {
			ResultSet resultset = Base.select(
					"SELECT users.Remarques.idProf, users.Remarques.Remarque FROM users.Remarques WHERE (users.Remarques.idEtudiant = '"
							+ usern + "')");
			ResultSetMetaData rsmd = resultset.getMetaData();
			int columncount = rsmd.getColumnCount();
			while (resultset.next()) {
				for (int i = 1; i <= columncount; i++) {
					resultat.add(resultset.getString(i));
				}
			}
			return resultat;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return resultat;
		}
	}

	/**
	 * Se d�connecter de la base de donn�es utilisateurs
	 */
	public void disconnect() {
		this.Base.disconnect();
	}
}
