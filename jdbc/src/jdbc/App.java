package jdbc;

// ============================================================
// JDBC IMPORTS - java.sql.* ke andar yeh saare classes hain:
//   Connection        - Database se connection represent karta hai
//   DriverManager     - Connection banane ka factory class
//   Statement         - Simple SQL execute karne ke liye
//   PreparedStatement - Parameterized SQL (SQL Injection safe)
//   CallableStatement - Stored Procedures call karne ke liye
//   ResultSet         - SELECT query ka result (table form)
//   ResultSetMetaData - Column names, types ki info
//   DatabaseMetaData  - Database ki info (version, tables, etc.)
//   SQLException      - Saari JDBC errors yahi pakadta hai
//   Savepoint         - Transaction mein partial rollback ke liye
// ============================================================
import java.sql.*;

// ============================================================
// JAR DEPENDENCY -- lib/mysql-connector-j-8.3.0.jar
// ============================================================
// Is project ke lib/ folder mein yeh JAR file hai:
//   mysql-connector-j-8.3.0.jar  <-- MySQL ka Type 4 (Thin) Driver
//
// VS Code settings.json mein already configured hai:
//   "java.project.referencedLibraries": ["lib/**/*.jar"]
//   Iska matlab lib/ ke andar saare .jar automatically classpath mein!
//
// Maven project mein yeh likha jaata:
//   <dependency>
//       <groupId>com.mysql</groupId>
//       <artifactId>mysql-connector-j</artifactId>
//       <version>8.3.0</version>
//   </dependency>
//
// JDBC Driver ke 4 Types:
//   Type 1 (JDBC-ODBC Bridge) - Deprecated, Java 8+ mein remove ho gaya
//   Type 2 (Native API)       - Platform dependent, C/C++ library chahiye
//   Type 3 (Network Protocol) - Middleware server chahiye
//   Type 4 (Thin/All Java)    - BEST! Direct TCP/IP, platform independent
//                               --> mysql-connector-j-8.3.0.jar yahi hai
// ============================================================

public class App {

    // ============================================================
    // CONNECTION CREDENTIALS - Database se connect karne ki info
    // ============================================================

    // JDBC URL Format: jdbc:[driver]://[host]:[port]/[database]
    //
    // MySQL        : jdbc:mysql://localhost:3306/college
    // Oracle       : jdbc:oracle:thin:@localhost:1521:XE
    // PostgreSQL   : jdbc:postgresql://localhost:5432/college
    // SQLite       : jdbc:sqlite:college.db
    // SQL Server   : jdbc:sqlserver://localhost:1433;databaseName=college
    //
    // Useful MySQL URL Parameters:
    //   ?useSSL=false              -- SSL disable (local dev ke liye)
    //   ?serverTimezone=UTC        -- Timezone set karo
    //   ?autoReconnect=true        -- Auto reconnect
    //   ?characterEncoding=utf8    -- UTF-8 encoding
    //
    // Full Example:
    //   jdbc:mysql://localhost:3306/college?useSSL=false&serverTimezone=UTC
    private static final String URL = "jdbc:mysql://localhost:3306/college";

    // MySQL ka default admin user -- Production mein dedicated user banao!
    // CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
    // GRANT SELECT, INSERT, UPDATE, DELETE ON college.* TO 'appuser'@'localhost';
    private static final String USERNAME = "root";

    // IMPORTANT: Password kabhi hardcode mat karo Production mein!
    // Iske bajaye use karo:
    //   System.getenv("DB_PASSWORD")              -- Environment variable
    //   properties.load(new FileInputStream(...)) -- .properties file
    private static final String PASSWORD = "8839178090@Az#";

    // ============================================================
    // DRIVER CLASS NAME - MySQL ke do versions ke liye alag naam
    // ============================================================
    // MySQL Connector/J 8.x (NAYA - YEH USE KARO):
    //   "com.mysql.cj.jdbc.Driver"
    //
    // MySQL Connector/J 5.x (PURANA - deprecated):
    //   "com.mysql.jdbc.Driver"
    //
    // Hmare paas: mysql-connector-j-8.3.0.jar  --> isliye "cj" wala use karenge
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {

        // ============================================================
        // STEP 1: LOAD JDBC DRIVER -- Class.forName()
        // ============================================================
        // Class.forName(className) - Driver class ko JVM mein load karta hai
        //
        // Andar kya hota hai:
        //   1. JVM "com.mysql.cj.jdbc.Driver" class dhundta hai
        //   2. Woh class lib/mysql-connector-j-8.3.0.jar mein milti hai
        //   3. Class ka static block execute hota hai
        //   4. Static block Driver ko DriverManager mein register karta hai
        //   5. Ab DriverManager.getConnection() MySQL se connect kar sakta hai
        //
        // JDBC 4.0+ (Java 6+) mein AUTOMATIC loading bhi hoti hai:
        //   - JAR ki META-INF/services/java.sql.Driver file padhi jaati hai
        //   - Driver automatically register hota hai bina Class.forName ke
        //   - Isliye technically zaroorat nahi
        //
        // Phir bhi Class.forName() likhne ke fayde:
        //   1. EXPLICIT - code mein clearly dikhta hai kaunsa driver use ho raha
        //   2. EARLY ERROR - JAR missing ho to yahan turant pata chalega
        //   3. LEGACY - JDBC 4.0 se purane code ke saath compatible
        //   4. DYNAMIC - Runtime pe driver class naam change kar sakte ho
        //
        // ClassNotFoundException kab aata hai:
        //   - lib/ mein JAR file nahi hai
        //   - Driver class ka naam galat likha
        //   - settings.json mein "lib/**/*.jar" nahi add kiya
        try {
            Class.forName(DRIVER_CLASS);
            System.out.println("Driver loaded   : " + DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
            System.err.println("Fix: Check lib/mysql-connector-j-8.3.0.jar exists");
            return; // Driver nahi mila, aage connection banana bekar hai
        }

        // ============================================================
        // STEP 2-6: CONNECTION -> STATEMENT -> QUERY -> RESULT -> CLOSE
        // ============================================================
        // try-with-resources (Java 7+):
        //   - try(...) mein declare resources automatically close ho jaate hain
        //   - Chahe exception aaye ya na aaye -- finally likhne ki zaroorat nahi
        //   - Close karne ka order (REVERSE of declaration):
        //       1. ResultSet rs   closed first
        //       2. Statement stm  closed second
        //       3. Connection con closed last
        //   - Yeh resources AutoCloseable implement karte hain
        //
        // Bina try-with-resources (purana tarika):
        //   Connection con = null; Statement stm = null; ResultSet rs = null;
        //   try { ... } finally {
        //       if (rs != null) rs.close();
        //       if (stm != null) stm.close();
        //       if (con != null) con.close();
        //   }
        try (
                // ----------------------------------------------------------
                // STEP 2: DATABASE CONNECTION BANANA
                // ----------------------------------------------------------
                // DriverManager.getConnection() ke 3 tarike:
                //
                //   a) URL + Username + Password alag-alag:    <-- YEH USE HO RAHA
                //      DriverManager.getConnection(URL, USERNAME, PASSWORD)
                //
                //   b) Sab kuch URL mein:
                //      DriverManager.getConnection(
                //          "jdbc:mysql://localhost:3306/college?user=root&password=pass")
                //
                //   c) URL + Properties object:
                //      Properties p = new Properties();
                //      p.setProperty("user", "root");
                //      p.setProperty("password", "pass");
                //      p.setProperty("useSSL", "false");
                //      DriverManager.getConnection(URL, p)
                //
                // Connection ke important methods:
                //   con.createStatement()       --> Simple Statement banao
                //   con.prepareStatement(sql)   --> PreparedStatement (safe)
                //   con.prepareCall(sql)        --> CallableStatement (SP)
                //   con.setAutoCommit(false)    --> Transaction shuru karo
                //   con.commit()                --> Changes save karo (COMMIT)
                //   con.rollback()              --> Changes undo karo (ROLLBACK)
                //   con.setSavepoint("sp")      --> Savepoint set karo
                //   con.getMetaData()           --> DatabaseMetaData lo
                //   con.isClosed()              --> Connection closed hai?
                //   con.isValid(timeout)        --> Connection valid hai?
                //   con.close()                 --> Connection band karo
                Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                // ----------------------------------------------------------
                // STEP 3: STATEMENT BANANA
                // ----------------------------------------------------------
                // Statement ke 3 types:
                //   1. Statement         - Simple, static SQL
                //                          con.createStatement()
                //   2. PreparedStatement - Parameterized, precompiled, SAFE
                //                          con.prepareStatement("SELECT * FROM student WHERE id=?")
                //                          ps.setInt(1, 5); // ? ko value do
                //   3. CallableStatement - Stored Procedures ke liye
                //                          con.prepareCall("{call getStudent(?)}")
                //
                // Scrollable + Updatable ResultSet ke liye:
                //   con.createStatement(
                //       ResultSet.TYPE_FORWARD_ONLY,       // Sirf aage (DEFAULT)
                //       ResultSet.TYPE_SCROLL_INSENSITIVE, // Aage-peeche, DB changes nahi dikhte
                //       ResultSet.TYPE_SCROLL_SENSITIVE,   // Aage-peeche, DB changes dikhte
                //       ResultSet.CONCUR_READ_ONLY,        // Sirf read (DEFAULT)
                //       ResultSet.CONCUR_UPDATABLE         // ResultSet se directly update
                //   )
                //
                // Statement ke execute methods:
                //   stm.executeQuery(sql)   --> SELECT ke liye, ResultSet return
                //   stm.executeUpdate(sql)  --> INSERT/UPDATE/DELETE/DDL, int return
                //   stm.execute(sql)        --> Koi bhi SQL, boolean return
                //   stm.addBatch(sql)       --> Batch mein add karo
                //   stm.executeBatch()      --> Saara batch ek saath chalao
                //   stm.setMaxRows(100)     --> Max 100 rows fetch karo
                //   stm.setQueryTimeout(30) --> 30 second timeout
                //   stm.cancel()            --> Running query cancel karo
                Statement stm = con.createStatement();

                // ----------------------------------------------------------
                // STEP 4: QUERY EXECUTE KARO -- ResultSet lo
                // ----------------------------------------------------------
                // executeQuery() sirf SELECT ke liye hota hai
                //
                // Query ALTERNATIVES:
                //   "SELECT * FROM student"                -- Saare columns
                //   "SELECT id, name FROM student"         -- Specific columns
                //   "SELECT * FROM student WHERE id = 5"   -- Filter
                //   "SELECT * FROM student ORDER BY name"  -- Sort
                //   "SELECT * FROM student LIMIT 10"       -- Pehle 10 rows
                //   "SELECT s.id, s.name, c.course
                //    FROM student s
                //    JOIN courses c ON s.course_id = c.id" -- JOIN
                //
                // ResultSet cursor initially pehle row se PEHLE hota hai.
                // rs.next() call karne par cursor aage badhta hai.
                ResultSet rs = stm.executeQuery("SELECT * FROM student")) {

            System.out.println("Connection established successfully!");

            // ----------------------------------------------------------
            // STEP 5: RESULTSET SE DATA NIKALO
            // ----------------------------------------------------------
            // rs.next():
            //   - Cursor ko next row pe le jaata hai
            //   - true  = row mili, data read karo
            //   - false = koi row nahi bachi, loop khatam
            //
            // ResultSet Navigation (Scrollable RS chahiye except next/beforeFirst):
            //   rs.next()         -- Agla row (SABSE ZYADA USE)
            //   rs.previous()     -- Pichla row
            //   rs.first()        -- Pehla row
            //   rs.last()         -- Aakhri row
            //   rs.absolute(3)    -- 3rd row pe seedha jao
            //   rs.beforeFirst()  -- Cursor start se pehle
            //   rs.afterLast()    -- Cursor end ke baad
            //
            // Data read karne ke tarike:
            //   Column INDEX se (1 se start, 0 se NAHI!):
            //     rs.getInt(1), rs.getString(2), rs.getDouble(3)
            //
            //   Column NAME se (RECOMMENDED - readable aur safe):
            //     rs.getInt("id"), rs.getString("name"), rs.getDouble("marks")
            //
            // Saare getXxx() methods:
            //   rs.getInt()        -- INT, TINYINT, SMALLINT, BIGINT
            //   rs.getString()     -- VARCHAR, CHAR, TEXT, LONGTEXT
            //   rs.getDouble()     -- DOUBLE, FLOAT, DECIMAL, NUMERIC
            //   rs.getFloat()      -- FLOAT
            //   rs.getLong()       -- BIGINT
            //   rs.getBoolean()    -- BOOLEAN, BIT, TINYINT(1)
            //   rs.getDate()       -- DATE
            //   rs.getTime()       -- TIME
            //   rs.getTimestamp()  -- DATETIME, TIMESTAMP
            //   rs.getBigDecimal() -- DECIMAL (exact precision)
            //   rs.getBytes()      -- BLOB, VARBINARY
            //   rs.getObject()     -- Koi bhi type (generic)
            //
            // NULL check:
            //   rs.wasNull()                   -- getXxx() ke baad call karo
            //   rs.getObject("col") == null    -- ya yeh check karo
            //
            // ResultSet MetaData (Column info ke liye):
            //   ResultSetMetaData rsmd = rs.getMetaData();
            //   rsmd.getColumnCount()    -- Kitne columns hain
            //   rsmd.getColumnName(i)    -- ith column ka naam
            //   rsmd.getColumnTypeName(i)-- ith column ka type
            while (rs.next()) {
                // rs.getInt(1)    --> 1st column (id) ka integer value
                // rs.getString(2) --> 2nd column (name) ka String value
                System.out.println(rs.getInt("id") + " " + rs.getInt("rollnumber") + " " + rs.getString("email") +  " " + rs.getString(2));
                // BETTER: rs.getInt("id") + " " + rs.getString("name")
            }

            // con.close() explicitly call karna try-with-resources mein jaruri nahi
            // Yeh automatically close ho jaata hai block ke end mein
            System.out.println("Connection Closed Successfully");

        // ----------------------------------------------------------
        // STEP 6: EXCEPTION HANDLING
        // ----------------------------------------------------------
        } catch (SQLException e) {
            // SQLException - JDBC ki saari errors yahi exception pakadta hai
            //
            // getMessage():
            //   "Access denied for user 'root'@'localhost'" (wrong password)
            //   "Table 'college.student' doesn't exist"     (table nahi)
            //   "Communications link failure"               (server band)
            //
            // getSQLState() - 5-char SQL Standard error code:
            //   "08001" -- Server tak pahunch nahi saka
            //   "08S01" -- Communication link failure
            //   "28000" -- Wrong username/password
            //   "42S02" -- Table exist nahi karta
            //   "42000" -- SQL syntax error
            //   "23000" -- Duplicate entry / Constraint violation
            //   "HY000" -- General SQL error
            //
            // getErrorCode() - MySQL specific numeric code:
            //   1045 -- Access denied (wrong password)
            //   1049 -- Unknown database
            //   1064 -- SQL syntax error
            //   1146 -- Table doesn't exist
            //   1062 -- Duplicate entry for primary key
            //   2003 -- Can't connect to MySQL server (server down)
            //
            // getNextException() -- Chained exceptions ke liye
            // printStackTrace()  -- Full stack trace (debugging)
            System.err.println("Database error : " + e.getMessage());
            System.err.println("SQLState       : " + e.getSQLState());
            System.err.println("ErrorCode      : " + e.getErrorCode());
            e.printStackTrace();
        }
        // try-with-resources ne rs, stm, con -- teeno auto close kar diye!
    }
}
