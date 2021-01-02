import java.sql.*;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/12/20 23:38
 **/
public class JDBCTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_user?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
            String username = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "select * from t_role_permission";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getObject("role_id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
