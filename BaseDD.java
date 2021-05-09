import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * BaseDD modélise une base de données et ses opérations de bases. Elle permet
 * de faire la connexion avec une base de données d'ajouter, consulter, vérifier
 * et mettre à jour ses informations.
 *
 * @author Houssem Radhouane
 */

public class BaseDD {

	/* intialiser la connexion */
	private Connection connection;

	/* init the statement */
	private Statement statement;

	/**
	 * Se connecter à la base de données
	 * 
	 * @param DBURL URL de la base de données
	 * @param UserName username de la base de données
	 * @param PW mot de passe de la base de données
	 * @return Connection
	 */
	public Connection connect(String DBURL, String UserName, String PW) {
		if (connection == null) {
			try {
				connection = (Connection) DriverManager.getConnection(DBURL, UserName, PW);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	/**
	 * Se déconnecter de la base de données
	 */
	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Reourner le set des résultats quand une requête SQL correcte est donnée
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select(String query) throws SQLException {
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}

	/**
	 * Retourner le status quand une requête SQL est donnée pour INSERT, UPDATE or DELETE
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int createOrUpdateOrDelete(String query) throws SQLException {
		statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		return result;
	}

}