import java.sql.*;

public class JDBCText {
    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/ssmdemo";
            String user="root";
            String password="iloveyou201314";
            connection=DriverManager.getConnection(url,user,password);
           String sql="select * from tb_user where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,1l);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                System.out.println(resultSet.getString("name"));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null)
            {
                connection.close();
            }
        }

    }
}
