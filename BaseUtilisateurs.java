import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * BaseDD mod�lise une base de donn�es utilisateurs.
 * Elle permet d'ajouter des utilisateurs, consulter, v�rifier
 * et mettre � jour leurs informations.
 *
 * @author Houssem Radhouane
 */

public class BaseUtilisateurs {
	
	/*initialiser les propri�t�s de la base de donn�es */
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
    	  ResultSet resultset = Base.select("SELECT identifiant FROM users.etudiant WHERE identifiant = '" + usern+"'");
    	  return (resultset.next());
    	} catch(SQLException e) {
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
    	  ResultSet resultset = Base.select("SELECT identifiant FROM users.enseignant WHERE identifiant = '" + usern+"'");
    	  return (resultset.next());
    	} catch(SQLException e) {
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
	 * ajoute un nouveau enseignant au tableau �tudiant
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
	 * Authentifie un �tudiant � partir de son username et mot de passe.
	 * 
	 * @param usern l'identifiant
	 * @param pwd mot de passe
	 * @return true si l'identifiant est utilis� par un enseignant
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
	 * Se d�connecter de la base de donn�es utilisateurs
	 */
	public void disconnect() {
		this.Base.disconnect();
	}
}
