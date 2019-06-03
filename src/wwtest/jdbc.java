package wwtest;
import com.mysql.jdbc.*;

import java.sql.*;

public class jdbc {
	public static void main(String args[]) {
	String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/library";
    String username = "root";
    String password = "123456";
    Connection conn = null;
    try {
        Class.forName(driver); //classLoader,加载对应驱动
        conn = (Connection) DriverManager.getConnection(url, username, password);
        
        String sql = "select * from book";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                 }
                System.out.println("");
            }
                System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    
	}

}
