import java.sql.*;
import java.util.ArrayList;

public class DBConnector  {

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/my_streaming";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "B1nd12200";



    public void readData() {

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String serie = "SELECT name, genre, yearToAndFrom, rating, seasonsAndEpisodes FROM my_streaming.serie WHERE SERIEID BETWEEN 1 and 99";
            stmt = conn.prepareStatement(serie);

            ResultSet rs = stmt.executeQuery(serie);

            //STEP 4: Extract data from result set
            int count=1;
            while(rs.next()){
                //Retrieve by column name


                String name = rs.getString("name");
                String genre= rs.getString("genre");
                String seasonsAndEpisodes=rs.getString("seasonsAndEpisodes");
                double rating= rs.getDouble("rating");
                String yearToAndFrom = rs.getString("yearToAndFrom");
                System.out.println(count++ +" " + name + ": "+ genre+ ": "+rating+ ": "+yearToAndFrom + ": "+seasonsAndEpisodes);

            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }


    public int readName(String name ) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String findN = "SELECT name FROM my_streaming.serie WHERE name = ?";
            stmt = conn.prepareStatement(findN);

            stmt.setString(1,name);

            ResultSet rs = stmt.executeQuery();

            //STEP 4: Extract data from result set
            while(rs.next()){
                //Retrieve by column name

            return rs.getInt("name");

            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return 0;
    }



    public int readPopulation(String city) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT population FROM world.city WHERE name = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, city);

            ResultSet rs = stmt.executeQuery();

            //STEP 4: Extract data from result set
            while(rs.next()){
                //Retrieve by column name

                return rs.getInt("Population");

            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return 0;


    }
}