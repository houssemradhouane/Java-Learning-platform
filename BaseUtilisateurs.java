import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * BaseDD modélise une base de données utilisateurs.
 * Elle permet d'ajouter des utilisateurs, consulter, vérifier
 * et mettre à jour leurs informations.
 *
 * @author Houssem Radhouane
 */

public class BaseUtilisateurs {
	
	/*initialiser les propriétés de la base de données */
    private String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    private String USERNAME = "root";
    private String PASSWORD = "55686Nsd";
    private BaseDD Base;
    
    public BaseUtilisateurs() {
    	this.Base = new BaseDD();
    	Base.connect(DATABASE_URL, USERNAME, PASSWORD);
    }
    
    /**
	 * Vérifie si l'identifiant donné est utilisé par un étudiant.
	 * 
	 * @param usern l'identifiant
	 * @return true si l'identifiant est utilisé par un étudiant
	 */
    public boolean etudiantExistant(String usern) {
    	try {
    	  ResultSet resultset = Base.select("SELECT identifiant FROM users.etudiant WHERE identifiant = '" + usern+"'");
    	  return (resultset.next());
    	} catch(SQLException e) {
    		System.out.println(e.getMessage());
    	    return false;	
    	}
    }
    
    /**
	 * Vérifie si l'identifiant donné est utilisé par un enseignant.
	 * 
	 * @param usern l'identifiant
	 * @return true si l'identifiant est utilisé par un enseignant
	 */
    public boolean enseignantExistant(String usern) {
    	try {
    	  ResultSet resultset = Base.select("SELECT identifiant FROM users.enseignant WHERE identifiant = '" + usern+"'");
    	  return (resultset.next());
    	} catch(SQLException e) {
    		System.out.println(e.getMessage());
    	    return false;	
    	}
    }
    
    /**
	 * Vérifie si l'identifiant donné est utilisé par un utilisateur.
	 * 
	 * @param usern l'identifiant
	 * @return true si l'identifiant est utilisé
	 */
    public boolean utilisateurExistant(String usern) {
    	return (this.enseignantExistant(usern) || this.etudiantExistant(usern));
    }

    /**
	 * ajoute un nouveau étudiant au tableau étudiant
	 * 
	 * @param usern l'identifiant
	 * @param mdp le mot de passe
	 * @param nom le nom
	 * @param prenom le prenom
	 * @param ens l'identifiant de l'enseignant responsable
	 */
    public void ajouterEtudiant(String usern, String mdp, String nom, String prenom, String ens) {
    	if (!utilisateurExistant(usern)) {
    		try {
    			int status = Base.createOrUpdateOrDelete("INSERT INTO users.etudiant (identifiant, nom, prenom, mdp, enseignant) "
    					+ "VALUES ('"+usern+"', '"+nom+"', '"+prenom+"', '"+mdp+"', '"+ens+"')");
    		} catch(SQLException e) {
        		System.out.println(e.getMessage());
    		}
    	}
    }
    
    /**
	 * ajoute un nouveau enseignant au tableau étudiant
	 * 
	 * @param usern l'identifiant
	 * @param mdp le mot de passe
	 * @param nom le nom
	 * @param prenom le prenom
	 */
    public void ajouterEnseignant(String usern, String mdp, String nom, String prenom) {
    	if (!utilisateurExistant(usern)) {
    		try {
    			int status = Base.createOrUpdateOrDelete("INSERT INTO users.enseignant (identifiant, nom, prenom, mdp) "
    					+ "VALUES ('"+usern+"', '"+nom+"', '"+prenom+"', '"+mdp+"')");
    		} catch(SQLException e) {
        		System.out.println(e.getMessage());
    		}
    	}
    }
    
    /**
	 * Authentifie un étudiant à partir de son username et mot de passe.
	 * 
	 * @param usern l'identifiant
	 * @param pwd mot de passe
	 * @return true si l'identifiant est utilisé par un enseignant
	 */
    public boolean authentifier(String usern, String pwd) {
    	try {
    	  ResultSet resultset = Base.select("SELECT * FROM users.etudiant,users.enseignant WHERE (users.etudiant.identifiant = '" + usern+"' AND users.etudiant.mdp = '"+ pwd +"')"
    			                                                                                 + " OR (users.enseignant.identifiant = '" + usern+"' AND users.enseignant.mdp = '"+ pwd +"')");
    	  return (resultset.next());
    	} catch(SQLException e) {
    		System.out.println(e.getMessage());
    	    return false;	
    	}
    }
    
    
    /**
	 * Se déconnecter de la base de données utilisateurs
	 */
	public void disconnect() {
		this.Base.disconnect();
	}
}
