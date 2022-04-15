package com.hiken;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "Jdbc:sqlite:E:\\Tutorial Materials\\SpringBoot\\TestDB\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                " (" + COLUMN_NAME + " text, " +
                                       COLUMN_PHONE + " integer, " +
                                       COLUMN_EMAIL + " text" +
                                    ")");

            insertContact(statement,"Ken",9822222,"ken@email.com");
            insertContact(statement,"Eva",9872200,"eva@pmail.com");
            insertContact(statement,"Peter",7628722,"peter@qmail.com");
            insertContact(statement,"John",3094222,"john@wmail.com");

            statement.execute("UPDATE " + TABLE_CONTACTS +  " SET "+
                                    COLUMN_PHONE + " ='1987222' where " +
                                    COLUMN_NAME + "='Ken' ");

            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " +
                                COLUMN_NAME + " ='John'");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
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
            e.printStackTrace();
        }
    }

    public static void insertContact(Statement statement, String name, int phone, String email) throws SQLException{
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME +", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ") " +
                "VALUES('"+ name + "', " + phone + ", '" + email + "')");
    }
}
