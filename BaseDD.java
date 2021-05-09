import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * BaseDD mod�lise une base de donn�es et ses op�rations de bases. Elle permet
 * de faire la connexion avec une base de donn�es d'ajouter, consulter, v�rifier
 * et mettre � jour ses informations.
 *
 * @author Houssem Radhouane
 */

public class BaseDD {

	/* intialiser la connexion */
	private Connection connection;

	/* init the statement */
	private Statement statement;

	/**
	 * Se connecter � la base de donn�es
	 * 
	 * @param DBURL URL de la base de donn�es
	 * @param UserName username de la base de donn�es
	 * @param PW mot de passe de la base de donn�es
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
	 * Se d�connecter de la base de donn�es
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
	 * Reourner le set des r�sultats quand une requ�te SQL correcte est donn�e
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
	 * Retourner le status quand une requ�te SQL est donn�e pour INSERT, UPDATE or DELETE
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