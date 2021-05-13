import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class testBaseUtilisateurs {

	public static void main(String[] args) {
		BaseUtilisateurs base = new BaseUtilisateurs();
		base.ajouterEnseignant("admin", "admin", "admin", "admin");
		//base.ajouterEtudiant("hradhou", "0000", "houssem", "radhouane", "aure");
		//if (base.authentifier("xav","0000")) { System.out.println("ok");}
		//base.disconnect();

	}

}
