package canger.study;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyUtil {
    public static Connection getConnection() throws SQLException, IOException {
        Properties properties = getProperties();
//        Class.forName(properties.getProperty("jdbc.driverClassName"));
        Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                properties.getProperty("jdbc.username"),
                properties.getProperty("jdbc.password"));

        return connection;
    }

    public static Properties getProperties() throws IOException {
        InputStream resourceAsStream =
                MyUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        return properties;
    }
}
