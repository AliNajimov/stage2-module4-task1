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
    public Connection createConnection() throws IOException, SQLException {
        Properties pr = new Properties();
        String prFile = "h2database.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(prFile);
        while (inputStream != null) {
            pr.load(inputStream);

        }
        return DriverManager.getConnection(
                pr.getProperty("jdbc:h2:~/test"),
                pr.getProperty("user"),
                pr.getProperty("password")
        );
    }
    // Write your code here!


}

