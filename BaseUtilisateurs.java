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
	 * Vérifie si l'identifiant donné est utilisé par un étudiant
	 * 
	 * @param usern l'identifiant
	 * @return
	 */
    public boolean etudiantExistant(String usern) {
    	try {
    	  ResultSet resultset = Base.select("SELECT identifiant FROM etudiant WHERE identifiant = " + usern);
    	return resultset != null;
    	} catch(SQLException e) {
    		System.out.println("Error in querry");
    	    return false;	
    	}
    }
    
    /**
	 * Vérifie si l'identifiant donné est utilisé par un enseignant
	 * 
	 * @param usern l'identifiant
	 * @return
	 */
    public boolean enseignantExistant(String usern) {
    	try {
    	  ResultSet resultset = Base.select("SELECT enseignant FROM etudiant WHERE identifiant = " + usern);
    	return resultset != null;
    	} catch(SQLException e) {
    		System.out.println("Error in querry");
    	    return false;	
    	}
    }
    
    /**
	 * Vérifie si l'identifiant donné est utilisé par un utilisateur
	 * 
	 * @param usern l'identifiant
	 * @return
	 */
    public boolean utilisateurExistant(String usern) {
    	return enseignantExistant(usern) || etudiantExistant(usern);
    }

}
