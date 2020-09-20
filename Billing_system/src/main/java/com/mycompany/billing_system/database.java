/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.billing_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Shrinidhi T S
 */
public class database {
    Connection conn;
    Statement stmt;
    public database()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/general_stores?"+"&rewriteBatchedStatements=true","root","Shri@1208") ;
            stmt=conn.createStatement();
        }  
        catch(ClassNotFoundException | SQLException e)
        { 
            System.out.println(e);
	}
    }
}