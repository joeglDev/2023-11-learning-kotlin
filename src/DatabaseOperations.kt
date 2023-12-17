   package Database

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.DriverManager
import java.sql.SQLException
import java.io.File
import java.nio.file.Paths


   class DatabaseOperations {

    // Create a new database if does not exist
    fun refreshDatabase(databaseName: String) {
        val filePath = Paths.get("").toAbsolutePath().toString() + "/database/$databaseName"
        val table = "test_table"

        val dbFile = File(filePath)
            if (!dbFile.exists()) {
                dbFile.createNewFile()
                println("Created new test database $filePath.")
             } 
             
            // Drop all tables
            val dropTablesProcess = ProcessBuilder("sqlite3", filePath, "DROP $table IF EXISTS")
            dropTablesProcess.start()
            println("Dropped table: $table")

            // Recreate the table
            val createTableProcess = ProcessBuilder("sqlite3", filePath, "CREATE TABLE IF NOT EXISTS $table (id INTEGER PRIMARY KEY, name TEXT)")
            createTableProcess.start()
            println("Created new table: $table")
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


// need a new db created called test db



 



