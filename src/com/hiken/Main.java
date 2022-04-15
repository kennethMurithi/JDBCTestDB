package com.hiken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try{

            Connection conn = DriverManager.getConnection("Jdbc:sqlite:E:\\Tutorial Materials\\SpringBoot\\TestDB\\testjava.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                            "(name TEXT, phone INTEGER, email TEXT)");
            statement.execute("INSERT INTO contacts(name, phone, email)" +
                            "VALUES('Ken', 07232222,'ken@email.com')");
            statement.execute("INSERT INTO contacts(name, phone, email)" +
                    "VALUES('Eva', 0987222,'eva@pmain.com')");
            statement.execute("INSERT INTO contacts(name, phone, email)" +
                    "VALUES('Joel', 0987662,'joel@fcome.com')");

            statement.close();
            conn.close();

        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
