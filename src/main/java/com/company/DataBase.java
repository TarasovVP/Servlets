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


    public void insert(String name, String surname){

        String insert = "INSERT INTO sakila.actor (first_name, last_name)" + "VALUES (?, ?)";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(url, user, passwd); PreparedStatement prpdSttm = con.prepareStatement(insert)) {

            prpdSttm.setString(1, name);
            prpdSttm.setString(2, surname);

            prpdSttm.execute();

            System.out.println(name + " is added to first_name, " + surname + " is added to last_name.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    private Properties getConnectionData() {
        props = new Properties();
        String fileName = "D:\\IT\\Java\\LevelUp\\Servlets\\src\\main\\resources\\db.properties";

        try (FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
