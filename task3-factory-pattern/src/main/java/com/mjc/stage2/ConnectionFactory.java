package com.mjc.stage2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
    Connection createConnection() throws IOException, SQLException;
}
