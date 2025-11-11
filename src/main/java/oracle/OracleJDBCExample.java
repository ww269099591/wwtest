package oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OracleJDBCExample {
    private static final Logger logger = LogManager.getLogger(OracleJDBCExample.class);
    
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // 创建表
            createTable(connection);

            // 插入数据
            insertData(connection);

            // 查询数据
            queryData(connection);

            // 更新数据
            updateData(connection);

            // 删除数据
            deleteData(connection);
            
        } catch (SQLException e) {
            logger.error("Database operation failed", e);
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE employees (" +
                "id NUMBER PRIMARY KEY, " +
                "name VARCHAR2(100), " +
                "salary NUMBER(10,2))";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            logger.info("Table 'employees' created successfully");
        } catch (SQLException e) {
            // 表可能已存在
            logger.warn("Table creation failed (may already exist): " + e.getMessage());
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        String insertSQL = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            // 插入第一条记录
            pstmt.setInt(1, 1);
            pstmt.setString(2, "John Doe");
            pstmt.setDouble(3, 5000.00);
            pstmt.executeUpdate();

            // 插入第二条记录
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Jane Smith");
            pstmt.setDouble(3, 6000.00);
            pstmt.executeUpdate();

            logger.info("Data inserted successfully");
        }
    }

    private static void queryData(Connection connection) throws SQLException {
        String selectSQL = "SELECT id, name, salary FROM employees";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            
            logger.info("Employee data:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                logger.info("ID: {}, Name: {}, Salary: {}", id, name, salary);
            }
        }
    }

    private static void updateData(Connection connection) throws SQLException {
        String updateSQL = "UPDATE employees SET salary = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setDouble(1, 5500.00);
            pstmt.setInt(2, 1);
            int rowsUpdated = pstmt.executeUpdate();
            logger.info("{} row(s) updated", rowsUpdated);
        }
    }

    private static void deleteData(Connection connection) throws SQLException {
        String deleteSQL = "DELETE FROM employees WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, 2);
            int rowsDeleted = pstmt.executeUpdate();
            logger.info("{} row(s) deleted", rowsDeleted);
        }
    }
}
