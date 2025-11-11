package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnection {
    private static final Logger logger = LogManager.getLogger(DatabaseConnection.class);
    
    private static final String URL = "jdbc:oracle:thin:@10.169.140.212:14147:hlddb";
    private static final String USERNAME = "flinkuser";
    private static final String PASSWORD = "Fdsx_TUHC6";
    
    public static Connection getConnection() throws SQLException {
        try {
            // 加载Oracle JDBC驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            logger.info("Oracle JDBC Driver Registered!");
            
            // 建立连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            logger.info("Connected to Oracle database successfully!");
            return connection;
        } catch (ClassNotFoundException e) {
            logger.error("Oracle JDBC Driver not found!", e);
            throw new SQLException("Oracle JDBC Driver not found", e);
        }
    }
}