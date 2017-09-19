package kun.tools;




import java.sql.*;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class JDBCUtil {
    public static Connection getconn(){
        String mysqlDriver = "com.mysql.jdbc.Driver";
        String mysqlURL = "jdbc:mysql://localhost:3306/seveneleven";
        String mysqlUser = "root";
        String mysqlPwd = "wwww";
        try {
            Class.forName(mysqlDriver);
            return DriverManager.getConnection(mysqlURL,mysqlUser,mysqlPwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet rs, Statement ps, Connection conn) {
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(ps, conn);
        }
    }
    public static void close(Statement ps, Connection conn){
        try {
            if (ps != null){
                ps.close();
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        close(conn);
    }
    public static void close(Connection conn){
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
