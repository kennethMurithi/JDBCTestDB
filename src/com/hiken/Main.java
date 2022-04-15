package com.hiken;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{

            Connection conn = DriverManager.getConnection("Jdbc:sqlite:E:\\Tutorial Materials\\SpringBoot\\TestDB\\testjava.db");
            Statement statement = conn.createStatement();
//            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
//                            "(name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts(name, phone, email)" +
//                            "VALUES('Ken', 07232222,'ken@email.com')");
//            statement.execute("INSERT INTO contacts(name, phone, email)" +
//                            "VALUES('Eva', 0987222,'eva@pmain.com')");
//            statement.execute("INSERT INTO contacts(name, phone, email)" +
//                            "VALUES('Joel', 0987662,'joel@fcome.com')");

//            statement.execute("UPDATE contacts SET phone='0982222' where name='Ken' ");
//            statement.execute("DELETE FROM contacts WHERE name='Joel'");

            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while (results.next()){
                System.out.println(results.getString("name") + " "
                                    + results.getInt("phone") + " "
                                    + results.getString("email"));
            }
            results.close();

            statement.close();
            conn.close();

        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
