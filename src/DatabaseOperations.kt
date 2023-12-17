   package Database

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.DriverManager
import java.sql.SQLException
import java.io.File
import java.nio.file.Paths
import java.io.BufferedReader
import java.io.InputStreamReader

//to do: refactor filePAth to class property so dont have to enter each time
   class DatabaseOperations {

    // Create a new database if does not exist
    fun refreshDatabase(databaseName: String, tableName: String) {
        val filePath = Paths.get("").toAbsolutePath().toString() + "/database/$databaseName"

        val dbFile = File(filePath)
            if (!dbFile.exists()) {
                dbFile.createNewFile()
                println("Created new test database $filePath.")
             } 
             
            // Drop all tables
            val dropTablesProcess: ProcessBuilder = ProcessBuilder("sqlite3", filePath, "DROP TABLE IF EXISTS '$tableName';")
            var process = dropTablesProcess.start()
            process.waitFor()
            process.destroy()
            println("Dropped table: $tableName")

            // Recreate the table
            val createTableProcess = ProcessBuilder("sqlite3", filePath, "CREATE TABLE IF NOT EXISTS $tableName (id INTEGER PRIMARY KEY, species TEXT, name TEXT);")
            val process2 = createTableProcess.start()
            process2.waitFor()
            process2.destroy()
            println("Created new table: $tableName")
            }

    // Connect to a sample database
    fun connectToDatabase (databaseName: String) {
        var dbConnection: Connection? = null
        val filePath = Paths.get("").toAbsolutePath().toString() + "/database/$databaseName"
        try {
            // create a connection to the database
            dbConnection = DriverManager.getConnection(filePath)
    
            println("Connection to SQLite has been established: $filePath.")
            
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            try {
                dbConnection?.close()
            } catch (ex: SQLException) {
                println(ex.message)
            }
        }
    }

    //insert a row into a database
    fun insertIntoTable (databaseName: String, tableName: String, value1: String, value2: String) {
        val filePath = Paths.get("").toAbsolutePath().toString() + "/database/$databaseName"
        try {
            val insertIntoTableProcess = ProcessBuilder("sqlite3", filePath, "INSERT INTO  $tableName (species, name) VALUES('$value1', '$value2');")
            val process = insertIntoTableProcess.start()
            process.waitFor()
            process.destroy()
            println("Inserted into table: $tableName, values: $value1, $value2")
            } catch (e: SQLException) {
                println(e)
            }
        } 

    //read from table
    fun readTable (databaseName: String, tableName: String) {
        val filePath = Paths.get("").toAbsolutePath().toString() + "/database/$databaseName"
        try {
            var readTableProcess = ProcessBuilder("sqlite3", filePath, "SELECT * FROM $tableName;")
            val process = readTableProcess.start()
            process.waitFor()

            val reader = BufferedReader(InputStreamReader(process.inputStream))
            var line: String? = reader.readLine()
            while (line != null) {
              println(line)
             line = reader.readLine()
            }

            reader.close()
            process.destroy()

        } catch (e: SQLException) {
            println(e)
        }
    }
    }


 



