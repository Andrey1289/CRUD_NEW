package andrey.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcUtils {
    /**
     * JDBC Driver and database url
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/finishjdbcdatabase";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "root";
    static
        ReadApplicationProperties readApplicationProperties = new ReadApplicationProperties();
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null){
            try {
                Class.forName(readApplicationProperties.getJDBC_DRIVER());
                connection = DriverManager.getConnection(readApplicationProperties.getDATABASE_URL()
                        , readApplicationProperties.getUSER()
                        , readApplicationProperties.getPASSWORD());

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }
}
