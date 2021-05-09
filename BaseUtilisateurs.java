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
	 * V�rifie si l'identifiant donn� est utilis� par un �tudiant
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
	 * V�rifie si l'identifiant donn� est utilis� par un enseignant
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
	 * V�rifie si l'identifiant donn� est utilis� par un utilisateur
	 * 
	 * @param usern l'identifiant
	 * @return
	 */
    public boolean utilisateurExistant(String usern) {
    	return enseignantExistant(usern) || etudiantExistant(usern);
    }

}
