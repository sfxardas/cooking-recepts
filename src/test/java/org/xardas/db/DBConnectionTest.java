package org.xardas.db;

import org.junit.Before;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sebastian on 18.02.14.
 */
public class DBConnectionTest {


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testName() throws Exception {

        String dbURL = "jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/cookingrecipes";
        String username ="sfxardas";
        String password = "werfen";

        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query ="select * from recipes";

        try {
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, password);

            //getting PreparedStatment to execute query
            stmt = dbCon.prepareStatement(query);

            //Resultset returned by query
            rs = stmt.executeQuery(query);

            while(rs.next()){

                String name = rs.getString("recipeobject");
                System.out.println(name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            dbCon.close();
        }
    }


}

