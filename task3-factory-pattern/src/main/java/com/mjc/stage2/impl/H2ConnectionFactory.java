package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Properties pr = new Properties();
        String prFile = "h2database.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(prFile);
        while (inputStream != null) {
            try {
                pr.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            return DriverManager.getConnection(
                    pr.getProperty("jdbc:h2:~/test"),
                    pr.getProperty("user"),
                    pr.getProperty("password")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

