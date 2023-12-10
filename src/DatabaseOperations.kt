   package Database

   import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.DriverManager
import java.sql.SQLException


   class DatabaseOperations {
    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    fun createNewDatabase(fileName: String) {
        val url = "jdbc:sqlite:/home/hiroji/Documents/code/sqlite/connect/$fileName"

        var conn: Connection? = null
        try {
            conn = DriverManager.getConnection(url)
            conn?.let {
                val meta: DatabaseMetaData = it.metaData
                println("The driver name is ${meta.driverName}")
                println("A new database has been created.")
            }
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            try {
                conn?.close()
            } catch (ex: SQLException) {
                println(ex.message)
            }
        }
    }

    /**
 *
 * @author sqlitetutorial.net
 */
     /**
     * Connect to a sample database
     */
    fun connect() {
        var conn: Connection? = null
        try {
            // db parameters
            val url = "jdbc:sqlite:/home/hiroji/Documents/code/sqlite/connecttest.db"
            // create a connection to the database
            conn = DriverManager.getConnection(url)
    
            println("Connection to SQLite has been established.")
            
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            try {
                conn?.close()
            } catch (ex: SQLException) {
                println(ex.message)
            }
        }
    }
    
}


// need a new db created called test db



 



