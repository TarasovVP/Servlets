package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBase {

    private Properties props = getConnectionData();

    private String url = props.getProperty("db.url");
    private String user = props.getProperty("db.user");
    private String passwd = props.getProperty("db.passwd");

    public void create() {

        try (Connection con = DriverManager.getConnection(url, user, passwd); Statement stat = con.createStatement()) {
            stat.execute("create schema `my_schema`");
            stat.execute("create table my_schema.phonebook(" + "  contact VARCHAR(45)," + "  address VARCHAR(100));");

            System.out.println("New table \"phonebook\" is created.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insert(String contact, String address) {

        String insert = "INSERT INTO my_schema.phonebook (contact, address)" + "VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, passwd); PreparedStatement prpdSttm = con.prepareStatement(insert)) {

            prpdSttm.setString(1, contact);
            prpdSttm.setString(2, address);

            prpdSttm.execute();

            System.out.println(contact + " is added to contact, " + address + " is added to address.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    private Properties getConnectionData() {
        props = new Properties();
        String fileName = "src/main/resources/db.properties";

        try (FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
